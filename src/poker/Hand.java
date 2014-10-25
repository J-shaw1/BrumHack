package poker;

import java.util.ArrayList;

public class Hand {

	private ArrayList<Card> cards;

	public Hand(){
		cards = new ArrayList<Card>();
	}

	public void addCard(Card c) throws Exception {
		cards.add(c);
		if (cards.size() > 2)
			throw new Exception("Too many cards in the hand");
	}

	public ArrayList<Card> getHand() {
		return cards;
	}

	public String toString() {
		return "Card 1: " + cards.get(0).toString() + " & Card 2:"
				+ cards.get(1).toString();
	}

}
