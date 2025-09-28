public class Cards{

	// Attributes
	private String suitName;
	private int cardNumber;

	public Cards(String suitName, int cardNumber){
		this.suitName = suitName;
		this.cardNumber = cardNumber;
	}

	// getters
	public String getSuitName(){
		return suitName;
	}
	public int getCardNumber(){
		return cardNumber;
	}

}