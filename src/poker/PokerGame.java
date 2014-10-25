package poker;

import java.util.ArrayList;
import java.util.Collections;

public class PokerGame {
	private static final int LOOP_TWO_TIMES = 2;
	private static final int START_CHIPS_AI = 100;
	private static final int MAX_AMOUNT_AI = 4;
	private static Player player1;

	public PokerGame(Player player1) {
		this.player1 = player1;
	}

	public static void start() {
		int roundNumber = 1;
		int aopbr = 0; // amount of players before round
		int aobar = 0; // amount of players after round
		ArrayList<Player> players_hold = new ArrayList<Player>();

		// Create AI
		ArrayList<Player> players = new ArrayList<Player>();
		for (int i = 0; i < MAX_AMOUNT_AI; i++) {
			players.add(new Player("ai" + i, START_CHIPS_AI));
		}
		// user is last player in list
		players.add(player1);

		// Assign S/B blind
		do {
			aopbr = players.size();
			PokerRound round = new PokerRound(players, roundNumber);
			players_hold = round.start();
			if (players.size() > players_hold.size()){
				//Player knocked out
			} else {
				//No player knocked out
			}
			players = players_hold;
		} while (players.size() != 0);

	}

	// final bet

}
