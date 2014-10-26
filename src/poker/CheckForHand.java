package poker;

import java.util.ArrayList;
import java.util.Collections;

public class CheckForHand {

	ArrayList<Card> downCards = new ArrayList<Card>();
	
	
	public CheckForHand(Hand h, ArrayList<Card> downCards){
		this.downCards.add(h.getHand().get(0));
		this.downCards.add(h.getHand().get(1));
		this.downCards.addAll(downCards);
		Collections.sort(downCards);
	}
	
	public Combinations check() {

		System.out.println(downCards);

		Combinations al = Combinations.HighCard;
		Combinations ah = Combinations.HighCard;

		while (true) {
			if (checkStrightFlush(downCards)) {
				al = Combinations.StrightFlush;
				break;
			}
			if (checkFourOfAKind(downCards)) {
				al = Combinations.FourOfAKind;
				break;
			}
			if (checkFullHouse(downCards)) {
				al = Combinations.FullHouse;
				break;
			}
			if (checkFlush(downCards)) {
				al = Combinations.Flush;
				break;
			}
			if (checkStright(downCards)) {
				al = Combinations.Stright;
				break;
			}
			if (checkThreeOfAKind(downCards)) {
				al = Combinations.ThreeOfAKind;
				break;
			}
			if (checkTwoPair(downCards)) {
				al = Combinations.TwoPair;
				break;
			}
			if (checkPair(downCards)) {
				al = Combinations.Pair;
				break;
			}
			al = Combinations.HighCard;
			break;
		}

		for (int i = 0; i < downCards.size(); i++) {
			if (downCards.get(i).getNumber() == 1) {
				downCards.add(new Card(14, downCards.get(i).getSuit()));
				downCards.remove(i);
			}
		}

		while (true) {
			if (checkRoyalFlush(downCards)) {
				ah = Combinations.RoyalFlush;
				break;
			}
			if (checkStrightFlush(downCards)) {
				ah = Combinations.StrightFlush;
				break;
			}
			if (checkFourOfAKind(downCards)) {
				ah = Combinations.FourOfAKind;
				break;
			}
			if (checkFullHouse(downCards)) {
				ah = Combinations.FullHouse;
				break;
			}
			if (checkFlush(downCards)) {
				ah = Combinations.Flush;
				break;
			}
			if (checkStright(downCards)) {
				ah = Combinations.Stright;
				break;
			}
			if (checkThreeOfAKind(downCards)) {
				ah = Combinations.ThreeOfAKind;
				break;
			}
			if (checkTwoPair(downCards)) {
				ah = Combinations.TwoPair;
				break;
			}
			if (checkPair(downCards)) {
				ah = Combinations.Pair;
				break;
			}
			ah = Combinations.HighCard;
			break;
		}

		System.out.println(downCards);

		if (ah.getValue() < al.getValue())
			return al;
		else
			return ah;
	}

	private boolean checkRoyalFlush(ArrayList<Card> cards) {
		int count[] = new int[15];

		int spades = 0;
		int clubs = 0;
		int hearts = 0;
		int diamonds = 0;

		for (Card c : cards) {
			switch (c.getSuit()) {
			case Spades:
				spades++;
				break;
			case Clubs:
				clubs++;
				break;
			case Hearts:
				hearts++;
				break;
			case Diamonds:
				diamonds++;
				break;
			}
		}

		for (Card c : cards) {
			count[c.getNumber()]++;
		}

		for (int i = 10; i < count.length; i++) {
			if (count[i] < 1)
				return false;
		}
		return true && (spades >= 5 || clubs >= 5 || hearts >= 5 || diamonds >= 5);
	}

	private boolean checkStrightFlush(ArrayList<Card> cards) {

		int cardCount = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 5; j++) {
				if ((cards.get(i + j).getSuit() == cards.get(i + j + 1).getSuit()) && (cards.get(i + j).getNumber() == cards.get(i + j + 1).getNumber() - 1))
					cardCount++;
			}

			if (cardCount == 4)
				return true;
			cardCount = 0;
		}
		return false;
	}

	private boolean checkFourOfAKind(ArrayList<Card> cards) {
		int count[] = new int[15];

		for (Card c : cards) {
			count[c.getNumber()]++;
			if (count[c.getNumber()] == 4)
				return true;
		}
		return false;
	}

	private boolean checkFullHouse(ArrayList<Card> cards) {
		ArrayList<Card> cards2 = new ArrayList<Card>();
		cards2.addAll(cards);
		return checkThreeOfAKind(cards) && checkPair(removeThreeOfAKind(cards2));
	}

	private boolean checkFlush(ArrayList<Card> cards) {

		int spades = 0;
		int clubs = 0;
		int hearts = 0;
		int diamonds = 0;

		for (Card c : cards) {
			switch (c.getSuit()) {
			case Spades:
				spades++;
			case Clubs:
				clubs++;
			case Hearts:
				hearts++;
			case Diamonds:
				diamonds++;
			}
		}

		return (spades == 5 || clubs == 5 || hearts == 5 || diamonds == 5);
	}

	private boolean checkStright(ArrayList<Card> cards) {
		int cardCount = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 5; j++) {
				if (cards.get(i + j).getNumber() == cards.get(i + j + 1).getNumber() - 1)
					cardCount++;
			}

			if (cardCount == 4)
				return true;
			cardCount = 0;
		}
		return false;
	}

	private boolean checkThreeOfAKind(ArrayList<Card> cards) {
		int count[] = new int[15];

		for (Card c : cards) {
			count[c.getNumber()]++;
			if (count[c.getNumber()] == 3)
				return true;
		}
		return false;

	}

	private boolean checkTwoPair(ArrayList<Card> cards) {
		ArrayList<Card> cards2 = new ArrayList<Card>();
		cards2.addAll(cards);
		return checkPair(cards) && checkPair(removePair(cards2));
	}

	private boolean checkPair(ArrayList<Card> cards) {
		int count[] = new int[15];

		for (Card c : cards) {
			count[c.getNumber()]++;
			if (count[c.getNumber()] == 2)
				return true;
		}
		return false;
	}

	private ArrayList<Card> removePair(ArrayList<Card> cards) {
		for (int i = 0; i < cards.size() - 1; i++) {
			if (cards.get(i).getNumber() == cards.get(i + 1).getNumber()) {
				cards.remove(i);
				cards.remove(i);
				return cards;
			}
		}
		// This should never happen as two cards should be removed
		return null;
	}

	private ArrayList<Card> removeThreeOfAKind(ArrayList<Card> cards) {
		int cardCount = 0;
		int threeIndex = 0;

		for (int i = 0; i < cards.size() - 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (cards.get(i + j).getNumber() == cards.get(i + j + 1).getNumber())
					cardCount++;
				threeIndex = (i + j) - 3;
			}
			if (cardCount == 2) {
				cards.remove(threeIndex + 1);
				cards.remove(threeIndex + 1);
				cards.remove(threeIndex + 1);
				return cards;
			}
			cardCount = 0;

		}
		// This should never happen as three cards should be removed
		System.out.println("returning null for three cards removed");
		return null;
	}

}
