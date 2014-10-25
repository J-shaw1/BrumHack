package poker;

public class Pot {

	private int pot[][];

	public Pot(int numPlayers) {
		pot = new int[4][numPlayers];
	}

	/**
	 * Makes a bet the a player
	 * 
	 * @param bet
	 *            The amount to player can bet
	 * @param round
	 *            The round number, starting at 0 going to 3
	 * @param playerIndex
	 *            the index of a player
	 */
	public void bet(int bet, int round, int playerIndex) {
		pot[round][playerIndex] = bet;
	}

	/**
	 * Gets a bet for a given round of betting
	 * 
	 * @param round
	 *            The round
	 * @param numPlayers
	 *            The player number to get the bet for
	 * @return The bet for the given parameter
	 */
	public int getBet(int round, int numPlayers) {
		return pot[round][numPlayers];
	}

	public int returnPotTotal() {
		int total = 0;
		for (int i = 0; i < pot.length; i++) {
			for (int j = 0; j < pot[0].length; j++) {
				total += pot[i][j];
			}
		}
		return total;
	}

}
