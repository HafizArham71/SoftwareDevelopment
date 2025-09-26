public class Deck{
	
	Card cards[];	
	public Deck(){
		cards=new Card[52];
	}

	public void display(){
		for(int i=0;i<52;i++)
			System.out.println(cards[i]);

	}
}