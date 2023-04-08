package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public class Dealer extends Player {
//		counts as a player2
//		holds deck of cards
// 		deal public(Face Up) card to player 1st, private(Face Down) card to dealer 2nd, 
//		public(Face Up) card to player 3rd, public(Face Up) to dealer 4th
	
//		player can choose to hit or stand until they hit 21(win) or go above 21 (bust)
//		Once player chooses stand...
//		The Dealer will then automatically Hit or Stay based on the rules of Blackjack: 
//		if the Dealer's hand total is below 17, the Dealer must Hit; 
//		if the hand total is 17 or above, the Dealer must Stay.
	Deck deck = new Deck();
	BlackjackHand hand = new BlackjackHand();
	List<Card> dealerCards = new ArrayList<>();

	public Deck shuffle() {
		deck.shuffle();
		return deck;
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
		System.out.println("Player: " + playerCards + "\nPlayer Total: " + playerSum);
		System.out.println("\nDealer: " + dealerCards.get(1) + "\nShowing: " + dealerShowSum);
		
//		System.out.println("\nDealer: " + dealerCards + "\nTotal: " + dealerSum);     // TEST DEALER HAND
//		System.out.println(deck.checkDeckSize() + " cards left");  					  // TEST
	}

	

//	will extend hit() and stay() from Player
//  	but will have to use game logic at top (story 4)	

}
