package poker;

/**
 * Represents a player
 */
public class Player {
	
	private String name;
	private int chips;
	//TODO add Hand object
	
	/**
	 * Constructor for creating a player
	 * @param name Name of the player
	 * @param startingAmount Starting amount of chips
	 */
	public Player(String name, int startingAmount){
		this.chips = startingAmount;
		this.name = name;
	}
	
	/**
	 * Increases a players chips
	 * @param amount Amount to increase by
	 */
	public void increaseChips(int amount){
		chips+=amount;
	}
	
	/**
	 * Decreases a players chips
	 * @param amount Amount to decrease by
	 */
	public void decreaseChips(int amount){
		chips-=amount;
	}
	
	private void setChips(int c){
		chips = c;
	}
	
	@Override
	public String toString() {
		return "Player name: " + name + " Amount of chips: " + chips;
	}
	
}
