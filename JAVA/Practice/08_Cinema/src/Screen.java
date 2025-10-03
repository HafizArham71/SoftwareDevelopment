public class Screen{
	
	// Attributes
	String screenName;
	int rows;
	String seat[][];

	public Screen(String screenName, int rows){
		this.screenName = screenName;
		this.rows = rows;
		seat = new String[rows][];
	}
}