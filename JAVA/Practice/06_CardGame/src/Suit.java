public enum Suit{
	SPADES("S"), DIAMONDS("D"), HEART("H"), CLUB("C");

	private String name;

	public Suit(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
}

