package poker;

public class Card {

	final private int number;
	final private Suit suit;
	
	public Card(int number, Suit suit){
		this.number = number;
		this.suit = suit;
	}

	public int getNumber() {
		return number;
	}

	public Suit getSuit() {
		return suit;
	}
	
	public String toString(){
		return number + " of " + suit;
	}
		
}
