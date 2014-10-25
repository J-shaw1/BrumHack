package poker;

import java.util.ArrayList;
import java.util.Collections;

public class CheckForHand {

	public static Combinations check(Hand h, ArrayList<Card> downCards) {

		downCards.add(h.getHand().get(0));
		downCards.add(h.getHand().get(1));

		Collections.sort(downCards);
		System.out.println(downCards);

		if (checkRoyalFlush(downCards))
			return Combinations.RoyalFlush;
		if (checkStrightFlush(downCards))
			return Combinations.StrightFlush;
		if (checkFourOfAKind(downCards))
			return Combinations.FourOfAKind;
		if (checkFullHouse(downCards))
			return Combinations.FullHouse;
		if (checkFlush(downCards))
			return Combinations.Flush;
		if (checkStright(downCards))
			return Combinations.Stright;
		if (checkThreeOfAKind(downCards))
			return Combinations.ThreeOfAKind;
		if (checkTwoPair(downCards))
			return Combinations.TwoPair;
		if (checkPair(downCards))
			return Combinations.Pair;

		return Combinations.HighCard;
	}

	private static boolean checkRoyalFlush(ArrayList<Card> cards) {
		return false;
	}

	private static boolean checkStrightFlush(ArrayList<Card> cards) {

		int cardCount = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j < 5; j++) {
				if ((cards.get((i + j) - 1).getSuit() == cards.get(i + j).getSuit())
						&& (cards.get((i + j) - 1).getNumber() == cards.get(i + j).getNumber() - 1))
					cardCount++;
				else
					break;
			}

			if (cardCount == 4)
				return true;
			cardCount = 0;
		}
		return false;
	}

	private static boolean checkFourOfAKind(ArrayList<Card> cards) {
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean checkFullHouse(ArrayList<Card> cards) {
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean checkFlush(ArrayList<Card> cards) {
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean checkStright(ArrayList<Card> cards) {
		int cardCount = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j < 5; j++) {
				if (cards.get((i + j) - 1).getNumber() == cards.get(i + j).getNumber() - 1)
					cardCount++;
				else
					break;
			}

			if (cardCount == 4)
				return true;
			cardCount = 0;
		}
		return false;
	}

	private static boolean checkThreeOfAKind(ArrayList<Card> cards) {
		int cardCount = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 1; j < 4; j++) {
				if (cards.get((i + j) - 1).getNumber() == cards.get(i + j).getNumber())
					cardCount++;
				else
					break;
			}
			if (cardCount == 2)
				return true;
			cardCount = 0;

		}
		return false;
	}

	private static boolean checkTwoPair(ArrayList<Card> cards) {
		ArrayList<Card> cards2 = new ArrayList<Card>();
		cards2.addAll(cards);
		return checkPair(cards) && checkPair(removePair(cards2));
	}

	private static boolean checkPair(ArrayList<Card> cards) {
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).getNumber() == cards.get(i + 1).getNumber())
				return true;
		}
		return false;
	}

	private static ArrayList<Card> removePair(ArrayList<Card> cards) {
		for (int i = 0; i < 6; i++) {
			if (cards.get(i).getNumber() == cards.get(i + 1).getNumber()) {
				cards.remove(i);
				cards.remove(i);
				return cards;
			}
		}
		//This should never happen as two cards should be removed
		return null;
	}
}
