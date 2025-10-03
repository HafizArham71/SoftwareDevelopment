public class Screen{
	
	// Attributes
	String screenName;
	int rows;
	String seat[][];

	public Screen(String screenName, int rows){
		this.screenName = screenName;
		this.rows = rows;
		seat = new String[rows][];

		for(int i=0; i<seat.length; i++)
			seat[i] = new seat[rows + i];

		for(int j=0; j<seat.length; j++){
			for(int k=0; k<seat[j].length; j++)
			{
				seat[j][k] = new seat(j, k, 500);
			}
		}
	}
}