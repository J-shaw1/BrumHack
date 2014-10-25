package poker;

import java.util.ArrayList;
import java.util.Collections;

public class PokerGame {
	private static final int START_CHIPS_AI = 100;
	private static final int MAX_AMOUNT_AI = 4;
	private Player player1;
	private static Deck deck1;

	public Player getPlayer1() {
		return player1;

	}

	public PokerGame(Player player1, Deck deck1) {
		this.player1 = player1;
		this.deck1 = deck1;
	}

	private static void start() {
		// Create AI
		ArrayList<Player> ai = new ArrayList<Player>();
		for (int i = 0; i < MAX_AMOUNT_AI; i++) {
			ai.add(new Player("ai" + i, START_CHIPS_AI));
		}

		// Give all players 2 cards
		deck1.getCard();

		// Small/Big blind

		// 1st bet, start left of BB

		// flop if 2 players still in (3 cards)

		// best

		// flop 1 card

		// bet

		// last flop
	}

	// final bet

}
