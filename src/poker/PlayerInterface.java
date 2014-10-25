package poker;

public interface PlayerInterface {
	public void increaseChips(int amount);
	public void decreaseChips(int amount) throws Exception;
	public void addCardToHand(Card c);
	public void setBlind(Blind blind);
	public Blind getBlind();
	public Hand getHand();
	public int getDecision(int currentBet);
	public String getName();
}
