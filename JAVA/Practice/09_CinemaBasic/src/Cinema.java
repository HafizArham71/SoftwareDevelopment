public class Cinema{

	// Attributes
	private String cinemaName;
	private int noOfScreens;
	
	Screen[] screen;

	public Cinema(String cinemaName, int noOfScreens){
		this.cinemaName = cinemaName;
		this.noOfScreens = noOfScreens;

		screen = new Screen[noOfScreens];

		for(int i=0; i<screen.length; i++){
			screen[i] = new Screen("Screen " + (i+1), 50);
		}
	}

	// toString
	@Override
	public String toString(){
		StringBuilder str = new StringBuilder();

		str.append(cinemaName);

		for(int i=0; i<noOfScreens; i++){
			str.append("\n  Screen " + (i+1));
		}

		return str.toString();
	}

}