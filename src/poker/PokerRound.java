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

	public ArrayList<PlayerInterface> start(int sizeOfBBlind) {
		int currentBet = 0;
		pot = new Pot(players.size());
		int x = 0;
		int descision = 0;

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
		// small blind + big blind
		for (int i = 0; i < MAX_AMOUNT_AI + 1; i++) {
			if ((players.get(i)).getBlind() == Blind.Small) {
				pot.bet(sizeOfBBlind / 2, roundNumber, i);
				pot.bet(sizeOfBBlind, roundNumber, i + 1);
			}
		}

		// first round of betting
		System.out.println("The current bet is " + currentBet + ".");
		for (int i = 0; i < players.size(); i++) {
			descision = players.get(i).getDecision(currentBet);
			if (descision < 0) {
				// fold
			} else if (descision == 0 && currentBet == 0) {
				// check
			} else if (descision == sizeOfBBlind) {
				// call
			} else {
				// raise
			}
		}

		return players;
	}// end of start()

}
