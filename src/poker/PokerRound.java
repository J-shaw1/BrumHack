package poker;

import java.util.ArrayList;

public class PokerRound {

	private static final int LOOP_TWO_TIMES = 2;
	private static final int MAX_AMOUNT_AI = 4;

	private ArrayList<PlayerInterface> players;
	private Deck deck = new Deck();
	private int roundNumber;
	private Pot pot;
	private int decision;

	public PokerRound(ArrayList<PlayerInterface> players2, int roundNumber) {
		this.players = players2;
		this.roundNumber = roundNumber;
	}

	public ArrayList<PlayerInterface> start(int sizeOfBBlind) throws Exception {
		int currentHighBet = 0;
		pot = new Pot(players.size());
		int x = 0;
		int decision = 0;
		int bettingRoundNumber;

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

		players.get(0).setBlind(Blind.Small);
		players.get(1).setBlind(Blind.Big);
		pot.bet(1, bettingRoundNumber, 0);
		pot.bet(2, bettingRoundNumber, 1);
		players.get(0).decreaseChips(1);
		players.get(1).decreaseChips(2);
		currentHighBet = sizeOfBBlind;
		System.out.println(pot.returnPotTotal());

		// first round of betting
		System.out.println("The current bet is " + currentHighBet
				+ ".\nBig blind is " + sizeOfBBlind + ".");

		currentHighBet = bettingLol(sizeOfBBlind, currentHighBet,
				bettingRoundNumber);
		System.out.println("Total in pot: " + pot.returnPotTotal());
		bettingRoundNumber++;
		// flop
		System.out.println("FLop:");
		ArrayList<Card> flop = flop(new ArrayList<Card>(),3);
		for (Card c : flop) {
			System.out.println(c);
		}
		// Betting 2
		currentHighBet = bettingLol(sizeOfBBlind, currentHighBet,
				bettingRoundNumber);
		System.out.println("Total in pot: " + pot.returnPotTotal());
		bettingRoundNumber++;
		// flop2
		flop = flop(flop,1);
		for (Card c : flop) {
			System.out.println(c);
		}
		// Betting 3
		currentHighBet = bettingLol(sizeOfBBlind, currentHighBet,
				bettingRoundNumber);
		System.out.println("Total in pot: " + pot.returnPotTotal());
		bettingRoundNumber++;
		// Last flop
		flop = flop(flop,1);
		for (Card c : flop) {
			System.out.println(c);
		}
		// Last bet
		currentHighBet = bettingLol(sizeOfBBlind, currentHighBet,
				bettingRoundNumber);
		System.out.println("Total in pot: " + pot.returnPotTotal());

		Combinations winning = Combinations.HighCard;
		int player = 0;
		for (int i = 0; i < players.size(); i++) {
			Combinations[] combs = new Combinations[players.size()];
			CheckForHand chk = new CheckForHand(players.get(i).getHand(), flop);
			combs[i] = chk.check();
			System.out.println(combs[i]);
			if (winning.getValue() < combs[i].getValue()){
				player = i;
				winning = combs[i];
			}
		}
		
		players.get(player).increaseChips(pot.returnPotTotal());
		System.out.println("The winner is " + players.get(player).getName() + ".");
		
		return players;
	}// end of start()


	private int bettingLol(int sizeOfBBlind, int currentHighBet,
			int bettingRoundNumber) throws Exception {
		int decision;
		int startingPerson = roundNumber + 1; // -1 for place in array +2 for SB
												// BB
		int currentPerson = startingPerson;
		int count = 0;
		do {
			//if (bettingRoundNumber == 1) {
				//decision = players.get(currentPerson).getDecision(2);
			//} else {
				decision = players.get(currentPerson).getDecision(
						currentHighBet);
			//}

			if (decision < 0) {
				// fold
			} else if (decision == 0) {
				// check
			} else if (decision > 0) {
				if (decision == currentHighBet) {
					// call
					pot.bet(decision, bettingRoundNumber - 1, currentPerson);
					players.get(currentPerson).decreaseChips(decision);
					System.out.println("Player: "
							+ players.get(currentPerson).getName()
							+ " called with: " + decision);
				} else {
					// raise
					pot.bet(decision, bettingRoundNumber - 1, currentPerson);
					players.get(currentPerson).decreaseChips(decision);
					System.out.println("Player: "
							+ players.get(currentPerson).getName()
							+ " raised with: " + decision);
				}
			}

			currentPerson++;
			if (currentPerson == players.size()) {
				currentPerson = 0;
			}
			count++;
			if (decision > currentHighBet) {
				currentHighBet = decision;
			}
		} while (count != players.size());
		return currentHighBet;
	}

	private ArrayList<Card> flop(ArrayList<Card> flop, int loop) {

		for (int i = 0; i < loop; i++) {
			flop.add(deck.getCard());
		}
		return flop;
	}

}
