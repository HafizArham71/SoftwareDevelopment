public class Cinema{

	
	// Attributes

	private String cinemaName;
	static final int DEFAULT_NUM_SCREENS = 10;
	private Screen screens[];

	
	
	// Constructors

	public Cinema(){

		this("Untitled Cinema");

	}

	public Cinema(String cinemaName){

		this(cinemaName, DEFAULT_NUM_SCREENS);

	}

	public Cinema(String cinemaName, int noOfScreens){

		this.cinemaName = cinemaName;


		screens = new Screen[noOfScreens];


		for(int i=0; i<screens.length; i++){
		
			screens[i] = new Screen("Screen-" + (i+1));
		}

	}



	// Method

	public int getScreensCount(){

		return screens.length;

	}

	public Screen[] getScreens(){

		return screens;

	}


	public void addScreen(String screenName){

		Screen updatedScreens[] = new Screen[screens.length+1];
		
		for(int i=0; i<screens.length; i++){

			updatedScreens[i] = screens[i];

		}

		updatedScreens[screens.length] = new Screen(screenName);

		screens = updatedScreens;

	}

	public Screen findScreenByName(String screenName){

		for(Screen s: screens){

			if(s.getScreenName().equals(screenName))
				return s;

		}

		return null;

	}


	public Screen findScreenByIndex(int index){

		return screens[index];

	}

	
	public boolean bookSeat(String screenName, String seatId){

		for(Screen s: screens){

			if(screenName!=null && s.getScreenName().equals(screenName) && seatId!=null)
				return s.book(seatId);

		}

		return false;

	}

	public boolean cancelSeat(String screenName, String seatId){

		for(Screen s: screens){

			if(screenName!=null && s.getScreenName().equals(screenName) && seatId!=null)
				return s.cancel(seatId);

		}

		return false;

	}

	public int getTotalSeats(){

		int total = 0;

		for(Screen s: screens){

			total+=s.getTotalSeatsCount();

		}

		return total;

	}

	public int getAvailableSeats(){

		int available = 0;

		for(Screen s: screens){

			available+=s.getAvailableSeatCount();

		}

		return available;

	}

	public void printReport(){

		for(Screen s: screens){

			s.displayVerbose();

		}

	}

	public String getCinemaName(){

		return cinemaName;
	}

	
		

	@Override 
	public String toString(){

		return String.format("Cinema Name: %s, No Of Screens: %d, Total Seats: %d, Available Seats: %d", cinemaName, screens.length, getTotalSeats(), getAvailableSeats());
	}
}