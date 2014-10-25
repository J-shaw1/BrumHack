package poker;

public enum Combinations {
	HighCard(0),
	Pair(1),
	TwoPair(2),
	ThreeOfAKind(3),
	Stright(4),
	Flush(5),
	FullHouse(6),
	FourOfAKind(7),
	StrightFlush(8),
	RoyalFlush(9);
	
	private int value;
	
	Combinations(int value){
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
}