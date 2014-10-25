package poker;

import java.util.ArrayList;

public class Hand {
	
	private ArrayList<Card> cards;
	
	public Hand(){
	}
	
	public void addCard(Card c) throws Exception{
		cards.add(c);
		if(cards.size() > 2) throw new Exception("Too many cards in the hand") ;
	}
	
	public Card[] getHand(){
		return (Card[]) cards.toArray();
	}
	
}
