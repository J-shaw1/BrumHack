package poker;

import java.util.ArrayList;
import java.util.Collections;

public class Test {
	public static void main(String[] args) {
		ArrayList<Card> c = new ArrayList<Card>();
		
		//c.add(new Card(12,Suit.Clubs));
		//c.add(new Card(2,Suit.Clubs));
		c.add(new Card(4,Suit.Hearts));
		c.add(new Card(4,Suit.Spades));
		c.add(new Card(7,Suit.Diamonds));
		c.add(new Card(2,Suit.Diamonds));
		c.add(new Card(13,Suit.Clubs));
		
		Hand h = new Hand();
		try {
			h.addCard(new Card(2,Suit.Clubs));
			h.addCard(new Card(12,Suit.Clubs));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(c);
		
		Collections.sort(c);
		
		System.out.println(c);
		
		System.out.println(CheckForHand.check(h, c));
		
	}
}
