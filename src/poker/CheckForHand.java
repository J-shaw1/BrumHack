package poker;

import java.util.ArrayList;
import java.util.Collections;

public class CheckForHand {

	public static Combinations check(Hand h, ArrayList<Card> downCards){
		
		downCards.add(h.getHand().get(0));
		downCards.add(h.getHand().get(1));
		
		Collections.sort(downCards);
		
		if (checkRoyalFlush(downCards)) return Combinations.RoyalFlush;
		if (checkStrightFlush(downCards)) return Combinations.StrightFlush;
		if (checkFourOfAKind(downCards)) return Combinations.FourOfAKind;
		if (checkFullHouse(downCards)) return Combinations.FullHouse;
		if (checkFlush(downCards)) return Combinations.Flush;
		if (checkStright(downCards)) return Combinations.Stright;
		if (checkThreeOfAKind(downCards)) return Combinations.TwoPair;
		if (checkPair(downCards)) return Combinations.Pair;
		
		return Combinations.HighCard;
	}

	private static boolean checkRoyalFlush(ArrayList<Card> cards) {
		return false;
	}

	private static boolean checkStrightFlush(ArrayList<Card> cards) {
		for(int i = 0; i < 2; i++){
			for(int j = 1; j < 5; j++){
				if(!(cards.get(i).getSuit() == cards.get(i+j).getSuit())
				|| !(cards.get(i).getNumber() == cards.get(i+j).getNumber()-1))
					return false;
			}
		}
		return true;
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
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean checkThreeOfAKind(ArrayList<Card> cards) {
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean checkPair(ArrayList<Card> cards) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
