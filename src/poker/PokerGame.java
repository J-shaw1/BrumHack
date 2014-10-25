package poker;

public class PokerGame {
	private Player player1;
	private Deck deck1;
	
	public Player getPlayer1() {
		return player1;
		
	}

	public PokerGame(Player player1, deck1){
		this.player1 = player1;
		this.deck1 = deck1;
	}
	
	//Create AI
	Player ai1 = new Player("ai1",100);
	Player ai2 = new Player("ai2",100);
	Player ai3 = new Player("ai3",100);
	Player ai4 = new Player("ai4",100);
	
	Player[] playersArray = new Player[10];
	playersArray[0] = ai1;
	//Give all players 2 cards
	deck1.getCard();
	
	//Small/Big blind
	
	//1st bet, start left of BB
	
	//flop if 2 players still in (3 cards)
	
	//best
	
	//flop 1 card
	
	//bet
	
	//last flop
	
	//final bet
	
}
