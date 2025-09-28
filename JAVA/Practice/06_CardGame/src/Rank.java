public enum Rank{
	ACE("Ace", 1), TWO("Two", 2), THREE("Three", 3), FOUR("Four", 4), FIVE("Five", 5), SIX("Six", 6), SEVEN("Seven", 7), EIGHT("Eight", 8), NINE("Nine", 9), TEN("Ten", 10), JACK("Jack", 11), QUEEN("Queen", 12), KING("King", 13);

	private String name;
	private int number;

	public Rank(String cardName, int cardNumber){
		name = cardName;
		number = cardNumber;
	}

	public int getNumber(){
		return number;
	}
}
