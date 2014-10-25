package poker;

public class AIPlayer extends Player implements PlayerInterface {

	private float riskFactor;

	public AIPlayer(String name, int startingAmount) {
		super(name, startingAmount);
	}

	public int getDecision(int currentBet) {
		return currentBet;
	}

	@Override
	public void increaseChips(int amount) {
		super.increaseChips(amount);
	}

	@Override
	public void decreaseChips(int amount) throws Exception {
		super.decreaseChips(amount);
	}

	@Override
	public void addCardToHand(Card c) {
		super.addCardToHand(c);

	}

	@Override
	public void setBlind(Blind blind) {
		super.setBlind(blind);
	}

	@Override
	public Blind getBlind() {
		return super.getBlind();
	}
	
	@Override
	public Hand getHand() {
		return super.getHand();
	}
	
}
