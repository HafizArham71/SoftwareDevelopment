public class Deck{

	private static int counter = 0;

	Cards card[];
	public Deck(){
		card = new Cards[52];
		Suit suit[] = Suit.values();
		Rank rank[] = Rank.values();

		for(int i=0; i<suit.length; i++)
			for(int j=0; j<rank.length; j++)
				card[counter++] = new Cards(suit[i].getName(), rank[j].getName());
	}
	
	public void display(){
		for(int i=0; i<52; i++){
			System.out.println(card[i]);
			if(i==12 || i==25 || i==38)
				System.out.print("\n");
		}
	}
}