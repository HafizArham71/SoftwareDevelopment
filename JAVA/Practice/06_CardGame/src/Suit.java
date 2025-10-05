public enum Suit{
	SPADES("Spades"), DIAMONDS("Diamonds"), HEARTS("Hearts"), CLUB("Club");

	private String name;
	Suit(String suitName){
		name = suitName;
	} 

	public String getSuitName(){
		return name;
	}
}