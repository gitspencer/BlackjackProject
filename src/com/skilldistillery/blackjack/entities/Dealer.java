package com.skilldistillery.blackjack.entities;

public class Dealer extends Player {
	private Deck deck = new Deck();
	
	public Deck shuffle() {
		deck.shuffle();
		return deck;
	}
	
	public Card dealCard() {
		return deck.dealCard();
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}
}
