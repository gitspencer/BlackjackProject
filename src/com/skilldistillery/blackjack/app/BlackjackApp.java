package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApp {
	Dealer dealer = new Dealer();
	Player player = new Player();
	
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
		dealer.dealerDeal();
	}
	
	public void dealerDeal() {
		int playerSum = 0;
		int dealerSum = 0;
		int dealerShowSum = 0;

		for (int i = 0; i < 2; i++) {
			Card playerCard = deck.dealCard();
			Card dealerCard = deck.dealCard();
			playerCards.add(playerCard);
			dealerCards.add(dealerCard);
			playerSum += playerCard.getRank().getValue();
			dealerSum += dealerCard.getRank().getValue();	
			if (i == 1) {
				dealerShowSum = dealerCard.getRank().getValue();
			}
		}
	}
	
	public void hitOrStay() {
		Scanner scanner = new Scanner(System.in);
		int selection;
		menu();
		do {
			selection = scanner.nextInt();
			switch(selection){
			case 1:
				player.hit();
				menu();
				break;
			case 2:	
				player.stay();
				//call dealersLogic() 
				break;
			case 3:
				quit();
				break;
			default:
				invalid();
				break;
			}
		} while (selection != 3);
		scanner.close();
	}
	
	//determine a winner for this round
//	public Player determineWinner() {
		//...
//		return theWinner;
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void menu() {
		System.out.println("\n(1) Hit  \t(2) Stay \t(3) Quit");		
	}
	
	public void quit() {
		System.out.println("Goodbye!");
	}
	
	public void invalid() {
		System.out.println("Invalid selection. Enter 1-3.");
	}

}
