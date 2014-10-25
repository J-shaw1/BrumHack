package poker;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	private ArrayList<Card> deck;

	public Deck() {
		deck = new ArrayList<Card>();

		for (int i = 0; i < 13; i++) {
			deck.add(new Card(i + 1, Suit.Spades));
		}
		for (int i = 0; i < 13; i++) {
			deck.add(new Card(i + 1, Suit.Clubs));
		}
		for (int i = 0; i < 13; i++) {
			deck.add(new Card(i + 1, Suit.Hearts));
		}
		for (int i = 0; i < 13; i++) {
			deck.add(new Card(i + 1, Suit.Diamonds));
		}

		this.shuffle();

	}

	/**
	 * Gets the first card from the deck and the removes it from the deck
	 * @return A card
	 */
	public Card getCard(){
		Card c = deck.get(0);
		deck.remove(0);
		return c;
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}

	@Override
	public String toString() {
		return deck.toString();
	}

	public static void main(String[] args) {
		Deck d = new Deck();
		System.out.println(d);
		System.out.println(d.getCard());
		System.out.println(d);
	}

}
