package poker;

import java.util.ArrayList;
import java.util.Collections;

public class Test {
	public static void main(String[] args) {
		ArrayList<Card> c = new ArrayList<Card>();
		
		//Test comment
		
		//c.add(new Card(12,Suit.Clubs));
		//c.add(new Card(2,Suit.Clubs));
		c.add(new Card(1,Suit.Clubs));
		c.add(new Card(2,Suit.Clubs));
		c.add(new Card(3,Suit.Clubs));
		c.add(new Card(4,Suit.Clubs));
		c.add(new Card(5,Suit.Clubs));
		
		Hand h = new Hand();
		try {
			h.addCard(new Card(7,Suit.Diamonds));
			h.addCard(new Card(8,Suit.Clubs));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CheckForHand ch = new CheckForHand(h, c);
		
		System.out.println(ch.check());
		
	}
}
