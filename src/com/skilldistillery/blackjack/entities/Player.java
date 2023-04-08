package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public class Player {
	BlackjackHand hand = new BlackjackHand();
	List<Card> playerCards = new ArrayList<>();

	public List<Card> playerHand() {
		return playerCards;
	}

	public void hit(Card card) {
		hand.addCard(card);
	}

	public void stay() {
//		do not add any cards, move on
		System.out.println("Dealers turn...");
	}

}
