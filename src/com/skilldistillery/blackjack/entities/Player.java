package com.skilldistillery.blackjack.entities;

public class Player {
	protected BlackjackHand hand = new BlackjackHand();
	
	public Hand playerHand() {
		return hand;
	}

	public void addCardToHand(Card card) {
		hand.addCard(card);
	}

	public void stay() {
		System.out.println("ending turn...");
	}

	public BlackjackHand getHand() {
		return hand;
	}

	public void setHand(BlackjackHand hand) {
		this.hand = hand;
	}
}
