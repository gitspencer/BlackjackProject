package com.skilldistillery.blackjack.app;

import java.util.Scanner;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApp {
	private Dealer dealer = new Dealer();
	private Player player = new Player();
	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		BlackjackApp bja = new BlackjackApp();
		bja.launch();
	}

	public void launch() {
		shuffleAndDeal();
		hitOrStay();
	}

	public void shuffleAndDeal() {
		dealer.shuffle();
		dealerDeal();
	}

	public void dealerDeal() {
		for (int i = 0; i < 2; i++) {
			player.addCardToHand(dealer.getDeck().dealCard());
			dealer.addCardToHand(dealer.getDeck().dealCard());
		}
		System.out.println(
				"Player: " + player.playerHand().getHand() 
				+ "\nPlayer Total: " + player.playerHand().getHandValue());
		System.out.println("\nDealer: " + dealer.playerHand().getHand().get(1) 
				+ "\nShowing: " + dealer.playerHand().getHand().get(1).getRank().getValue());
	}

	public void hitOrStay() {
		if (player.getHand().isBlackjack() == true) {
			blackjackWin();
		} else {
			int selection;
			menu();
			do {
				if (player.getHand().isBust() == true) {
					bust();
					break;
				} else if (player.getHand().isBlackjack() == true) {
					blackjackWin();
					break;
				}
				
				selection = scanner.nextInt();
				switch (selection) {
				case 1:
					player.addCardToHand(dealer.getDeck().dealCard());
					System.out.println("\nPlayer: " + player.playerHand().getHand() 
							+ "\nPlayer Total: " + player.playerHand().getHandValue());
					menu();
					break;
				case 2:
					player.stay();
					dealersLogic();
					break;
				case 3:
					quit();
					break;
				default:
					invalid();
					break;
				}
			} while (selection != 3);
		}
	}

	public void dealersLogic() {
		System.out.println("\nDealer Full Hand: " + dealer.playerHand().getHand() 
				+ "\nDealer Total: " + dealer.playerHand().getHandValue());

		if (dealer.playerHand().getHandValue() >= 17) {
			dealer.stay();
			whoWon();
		} else if (dealer.playerHand().getHandValue() < 17) {
			for (int i = dealer.playerHand().getHandValue(); i < 17; i++) {
				System.out.println("Dealer hits...");
				dealer.addCardToHand(dealer.getDeck().dealCard());
				System.out.println("Dealer: " + dealer.playerHand().getHand() 
						+ "\nDealer Total: " + dealer.playerHand().getHandValue());
				if (dealer.playerHand().getHandValue() >= 17 
						&& dealer.playerHand().getHandValue() < 22) {
					whoWon();
					break;
				} else if (dealer.playerHand().getHandValue() > 21) {
					System.out.println("You beat the Dealer!");
					playAgain();					
				}
			}
		}
	}

	public void whoWon() {
		if (dealer.playerHand().getHandValue() > player.playerHand().getHandValue()) {
			System.out.println("...Dealer Won \u2639");
			playAgain();
		} else if (dealer.playerHand().getHandValue() < player.playerHand().getHandValue()) {
			System.out.println("You beat the Dealer!");
			playAgain();
		} else if (dealer.playerHand().getHandValue() == player.playerHand().getHandValue()) {
			System.out.println("Tie \u2639");
			playAgain();
		}
	}

	public void playAgain() {
		if(dealer.getDeck().checkDeckSize() <= 12) {
			System.out.println("Game over, deck too low. Cards remaining: " 
						+ dealer.getDeck().checkDeckSize());
			System.exit(0);
		}
		System.out.println("\n----------------------------------------------"
						 + "\nWanna play again from the same shuffled deck? "
						 + "\n(1) Play Again \t(2) Quit"
						 + "\n----------------------------------------------");
		int choice;
		do {
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				player.playerHand().clearHand();
				dealer.playerHand().clearHand();
				dealerDeal();
				hitOrStay();
				break;
			case 2:
				quit();
				break;
			default:
				invalid();
				break;
			}
		} while (choice != 2);
	}

	public void bust() {
		System.out.println("\nBUSTED! You lost.");
		playAgain();
	}

	public void blackjackWin() {
		System.out.println("\nBLACKJACK! You have 21.");
		playAgain();
	}

	public void menu() {
		System.out.println("\n(1) Hit  \t(2) Stay \t(3) Quit");
	}

	public void quit() {
		System.out.println("Goodbye!");
		scanner.close();
		System.exit(0);
	}

	public void invalid() {
		System.out.println("Invalid selection.");
	}
}
