package com.skilldistillery.blackjack.test;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Deck;

public class DealerTest {

	public static void main(String[] args) {
		DealerTest dealer = new DealerTest();
		dealer.run();
	}

	public void run() {
		Deck deck = new Deck();
		deck.shuffle();

		Scanner sc = new Scanner(System.in);
		System.out.print("How many cards do you want (1-52)? ");
		int numCards = sc.nextInt();
		sc.nextLine();
		if (numCards > 0 && numCards <= deck.checkDeckSize()) {

			int sumOfCards = 0;
			for (int i = 0; i < numCards; i++) {
				Card dealtCard = deck.dealCard();
				sumOfCards += dealtCard.getRank().getValue();
				System.out.println("You now have: " + dealtCard + ", "
						+ "total: " + sumOfCards + ", "
						+ deck.checkDeckSize() + " cards left");

				sc.close();
			}

		} else {
			System.out.println("You entered an invalid number of cards (1-52).");
		}

	}

}
