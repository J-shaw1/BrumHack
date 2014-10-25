package poker;

import java.util.ArrayList;

public class PokerRound {

	private static final int LOOP_TWO_TIMES = 2;
	private static final int MAX_AMOUNT_AI = 4;

	private ArrayList<PlayerInterface> players;
	private Deck deck = new Deck();
	private int roundNumber;
	private Pot pot;

	public PokerRound(ArrayList<PlayerInterface> players2, int roundNumber) {
		this.players = players2;
		this.roundNumber = roundNumber;
	}

	public ArrayList<PlayerInterface> start(int sizeOfBBlind) throws Exception {
		int currentBet = 0;
		pot = new Pot(players.size());
		int x = 0;
		int decision = 0;
		int bettingRoundNumber;

		// Assign Blind
		if (roundNumber <= players.size()) {
			players.get(roundNumber).setBlind(Blind.Small);
			if (roundNumber + 1 <= players.size()) {
				players.get(roundNumber + 1).setBlind(Blind.Big);
			} else {
				x = roundNumber % players.size();
				players.get(x).setBlind(Blind.Big);
			}
		} else {
			x = roundNumber % players.size();
			players.get(x).setBlind(Blind.Small);
			players.get(x + 1).setBlind(Blind.Big);
		}

		// set some vars to make it easier later
		int iSB = roundNumber % players.size();

		// Give 2 cards each
		for (int j = 0; j < LOOP_TWO_TIMES; j++) {
			for (int i = 0; i < MAX_AMOUNT_AI + 1; i++) {
				(players.get(i)).addCardToHand(deck.getCard());
			}
		}

		for (int i = 0; i < players.size(); i++) {
			System.out.println(players.get(i).getHand());
		}
		bettingRoundNumber = 1;
		// small blind + big blind
		for (int i = 0; i < MAX_AMOUNT_AI + 1; i++) {
			if ((players.get(i)).getBlind() == Blind.Small) {

				pot.bet(sizeOfBBlind / 2, bettingRoundNumber, i);
				pot.bet(sizeOfBBlind, bettingRoundNumber, i + 1);
				
				//remove chips from players
				players.get(iSB).decreaseChips(sizeOfBBlind / 2);
				players.get(iSB + 1).decreaseChips(sizeOfBBlind / 2);
			}
		}

		x = roundNumber % players.size();

		// first round of betting
		System.out.println("The current bet is " + currentBet
				+ ".\nBig blind is " + sizeOfBBlind + ".");

		int startingPerson = roundNumber + 1; // -1 for place in array +2 for SB BB
		int currentPerson = startingPerson;
		int count = 0;
		int decisionAmount = sizeOfBBlind;
		do {
			decision = players.get(currentPerson).getDecision(decisionAmount);
			if (decision < 0) {
				// fold
				System.out.println(players.get(currentPerson).getName() + " folded.");
			} else if (decision == 0 && currentBet == 0) {
				// check
				System.out.println(players.get(currentPerson).getName() + " checked.");
			} else if (decision == sizeOfBBlind) {
				// call
				currentBet += decision;
				System.out.println(players.get(currentPerson).getName() + " called amount " + decision +".");
				pot.bet(decision, bettingRoundNumber, currentPerson);
			} else {
				// raise
				currentBet += decision;
				System.out.println(players.get(currentPerson).getName() + " rose amount " + decision +".");
				pot.bet(decision, bettingRoundNumber, currentPerson);
				// call new raised val
				decisionAmount = decision;
				
			}
			
			currentPerson++;
			if (currentPerson == players.size()){
				currentPerson = 0;
			}
			count++;
		} while (count != players.size());
		currentBet = currentBet + sizeOfBBlind + (sizeOfBBlind/2);
		
		
		System.out.println("The current pot is " + currentBet);

		return players;
	}// end of start()

}
