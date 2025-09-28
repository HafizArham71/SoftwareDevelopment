public class Deck{

	Card card[];
	private static int counter = 0;

	public Deck(){
		card = new Card[52];
		Suit suit[] = Suit.values();
		Rank rank[] = Rank.values();

		for(int i=0; i<suit.length; i++)
			for(int j=0; j<rank.length; j++)
				card[counter++] = new Card(suit[i].getSuitName(), rank[j].getCardName());
	}

	public void displayCards(){
		for(int i=0; i<52; i++){
			System.out.println(card[i]);
			if(i==12 || i==25 || i==38){
				System.out.print("\n");
			}
		}
			
	}
}