public enum Suit{
	SPADES("Spade"), DIAMONDS("Diamond"), HEART("Heart"), CLUB("Club");

	private String name;

	Suit(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
}

