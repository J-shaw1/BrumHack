package poker;

public class Player {
	
	private String name;
	private int chips;
	
	public Player(String name, int startingAmmount){
		this.chips = startingAmmount;
		this.name = name;
	}
	
	public void increaseChips(int ammount){
		chips+=ammount;
	}
	
	public void decreaseChips(int ammount){
		chips-=ammount;
	}
	
	private void setChips(int c){
		chips = c;
	}
	
}
