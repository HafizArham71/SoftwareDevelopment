public class Cards{

	// Attributes
	private String suitName;
	private String cardNumber;

	public Cards(String suitName, String cardNumber){
		this.suitName = suitName;
		this.cardNumber = cardNumber;
	}

	// getters
	public String getSuitName(){
		return suitName;
	}
	public String getCardNumber(){
		return cardNumber;
	}

	// toString
	@Override
	public String toString(){
		return String.format("%s of %s", cardNumber, suitName);
	}

}