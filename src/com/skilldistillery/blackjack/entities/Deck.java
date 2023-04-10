package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck = new ArrayList<>();
	
	public Deck() {
		Suit[] suits = Suit.values();
		Rank[] ranks = Rank.values();
		
		for (Suit suit : suits) {
			for (Rank rank : ranks) {
				Card card = new Card(suit, rank);
				deck.add(card);
			}
		}
	}
	
	public List<Card> getDeck() {
		return deck;
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}

	public Card dealCard() {
		Card dealtCard = deck.remove(0);   // return = deck.remove(0); would be sufficient
		return dealtCard;
	}

	public Card dealCard(Hand hand) {
		Card dealtCard = deck.remove(0);   
		return dealtCard;
	}

	public int checkDeckSize() {
		return deck.size();
	}
	
}
