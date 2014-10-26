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

	public static void start() throws Exception {
		int roundNumber = 1;
		int sizeOfBBlind = 2; 
		ArrayList<PlayerInterface> players_hold = new ArrayList<PlayerInterface>();

		// Create AI
		ArrayList<PlayerInterface> players = new ArrayList<PlayerInterface>();
		for (int i = 0; i < MAX_AMOUNT_AI; i++) {
			players.add(new AIPlayer("ai" + i, START_CHIPS_AI));
		}
		// user is last player in list
		players.add(player1);

		// Assign S/B blind
		PokerRound round;
		do {
			round = new PokerRound(players, roundNumber);
			players_hold = round.start(sizeOfBBlind);
			if (players.size() > players_hold.size()){
				//Player knocked out
			} else {
				//No player knocked out
			}
			players = players_hold;
			
			for(PlayerInterface p: players){
				p.destroyHand();
			}
		} while (players.size() != 0);

	}

	// final bet

}
