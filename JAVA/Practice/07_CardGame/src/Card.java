public class Card{

	private String suitName;
	private String cardRank;

	public Card(String suitName, String cardRank){
		this.suitName = suitName;
		this.cardRank = cardRank;
	}

	@Override
	public String toString(){
		return String.format("%s of %s", cardRank, suitName);
	}
}