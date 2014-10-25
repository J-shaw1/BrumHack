package poker;

public class Main {

	public static void main(String[] args) {
		
		System.out.print("What is your name? ");
		String userName = Input.readString();
		Player player1 = new Player(userName, 100);
		
		PokerGame poker = new PokerGame(player1);
		poker.start();
	}

}
