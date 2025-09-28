public enum Rank{

	ACE("Ace", 1), TWO("Two", 2), THREE("Three", 3), FOUR("Four", 4), FIVE("Five", 5), SIX("Six", 6), SEVEN("Seven", 7), EIGHT("Eight", 8), NINE("Nine", 9), TEN("Ten", 10), JACK("Jack", 11), QUEEN("Queen", 12), KING("King", 13); 

	private String cardName;
	private int cardNumber;
	
	Rank(String name, int cardNumber){
		cardName = name;
		this.cardNumber = cardNumber;
	}

	public String getCardName(){
		return cardName;
	}
}