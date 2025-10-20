public class Cinema{



	// Attributes

	private String screenName;
	private Screen[] screen;
	private int numScreens;

	public static int defaultNoOfScreens = 4;


	
	// Constructors

	public Cinema(){
		
		this("No Name");
	
	}

		
	public Cinema(String name){

		this(name, defaultNoOfScreens);	

	}

	
	public Cinema(String name, int numScreens){

		this.screenName = name;
		this.screen = new Screen[numScreens];	
		this.numScreens = numScreens;

		screen = new Screen[numScreens];

		for(int i=0; i<numScreens; i++){
			screen[i] = new Screen("Screen " + (i+1));
		}	

	}

	

	// Methods

	public Screen getScreenByName(String screenName){
		for(Screen s: screen){
			if(s.equals(screenName))
				return s;
		}

		return null;
	}


	public Screen getScreenByIndex(int indx){
		if(indx<0 || indx >=screen.length)
			throw new IndexOutOfBoundsException("No Screen Found with the index");
		return screen[indx];
	}

	public void addScreen(String screenName, int index){
		if(index < 0 || index >= screen.length)
			throw new IndexOutOfBoundsException("Out of screen length.");

		screen[index].setScreenName(screenName);
	}

	public int totalSeatsInCinema(){
		int total = 0;

		for(Screen s: screen){
			total += s.getTotalSeatCount();
		}

		return total;
	}

	public int availableSeatsInCinema(){
		int available = 0;

		for(Screen s: screen){
			available += s.getAvailableSeatCount();
		}

		return available;
	}	

    	public void displayAllScreens() {
		
        	System.out.println("=== Cinema: " + screenName + " ===");
        	
		for (Screen s : screen) {
          		System.out.println("- " + s.getScreenName() + 
                	" | Total Seats: " + s.getTotalSeatCount() +
                	" | Available: " + s.getAvailableSeatCount());
        	}
    }	

}