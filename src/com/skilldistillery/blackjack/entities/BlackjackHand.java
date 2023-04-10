package com.skilldistillery.blackjack.entities;

public class BlackjackHand extends Hand{	

	public BlackjackHand() {}
	
	@Override
	public int getHandValue() {
		int sumOfCards = 0;
		for (int i = 0; i < hand.size(); i++) {	
			sumOfCards += hand.get(i).getRank().getValue(); 
		}
		return sumOfCards;
	}
	
	public boolean isBlackjack() {		
		if(getHandValue() == 21) {
			return true;
		}
		return false;
	}
	
	public boolean isBust() {
		if(getHandValue() > 21) {
			return true;
		}
		return false;
	}
}
