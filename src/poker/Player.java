package poker;

/**
 * Represents a player
 */
public class Player implements PlayerInterface{

	private String name;
	private int chips;
	private Hand hand;
	private Blind blind;

	/**
	 * Constructor for creating a player
	 * 
	 * @param name
	 *            Name of the player
	 * @param startingAmount
	 *            Starting amount of chips
	 */
	public Player(String name, int startingAmount) {
		this.setChips(startingAmount);
		this.name = name;
		this.blind = Blind.None;
	}

	public void addCardToHand(Card c) {
		try {
			hand.addCard(c);
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	public Blind getBlind() {
		return blind;
	}

	public void setBlind(Blind blind) {
		this.blind = blind;
	}
	
	/**
	 * Increases a players chips
	 * 
	 * @param amount
	 *            Amount to increase by
	 */
	public void increaseChips(int amount) {
		chips += amount;
	}

	/**
	 * Decreases a players chips
	 * 
	 * @param amount
	 *            Amount to decrease by
	 * @throws Exception Throw if chips amount is below zero
	 */
	public void decreaseChips(int amount) throws Exception {
		chips -= amount;
		if(chips < 0) throw new Exception("Chips amount is below zero");
	}

	private void setChips(int c) {
		chips = c;
	}

	@Override
	public String toString() {
		return "Player name: " + name + " Amount of chips: " + chips;
	}

	@Override
	public Hand getHand() {
		return hand;
	}

	@Override
	public int getDecision(int currentBet) {
		return Input.readInt();
	}

}
