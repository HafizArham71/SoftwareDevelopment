public class Deck{

	Cards card[];
	public Deck(){
		card = new Cards[52];
		Suit suit[] = Suit.values();
		Rank rank[] = Rank.values();

		for(Suit s: suit)
			for(Rank r: rank)
				card = new Cards(suit[s], rank[r]);
	}
	
	public void display(){
		for(int i=0; i<52; i++){
			System.out.println(card[i]);
		}
	}
}