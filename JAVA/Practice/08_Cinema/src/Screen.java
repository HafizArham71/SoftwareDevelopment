public class Screen{

	// Attributes
	private String screenName;
	private int noOfRows;

	Seat seat[][];

	// Constructor
	public Screen(String screenName, int noOfRows){
		this.screenName = screenName;
		this.noOfRows = noOfRows;

		seat = new Seat[noOfRows][];

		for(int i=0; i<noOfRows; i++)
			seat[i] = new Seat[noOfRows+i];

		for(int j=0; j<seat.length; j++){
			for(int k=0; k<seat[j].length; k++){
				seat[j][k]=new Seat(j, k, 500);
			}
		}
	}


}