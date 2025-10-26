public class Cinema{

	

	// Attributes
	
	private String cinemaName;
	private Screen[] screens;
	private static int DEFAULT_NUM_SCREENS = 5;


	

	// Constructors

	public Cinema(){

		this("Default Cinema");

	}

	public Cinema(String cinemaName){

		this(cinemaName, DEFAULT_NUM_SCREENS);

	}

	public Cinema(String cinemaName, int noOfScreens){

		this(cinemaName, noOfScreens, new int[]{10, 11, 12, 13, 14});
	}

	public Cinema(String cinemaName, int noOfScreens, int[] rowLengths){

		this.cinemaName = cinemaName;
		this.screens = new Screen[noOfScreens];

		for(int i=0; i<screens.length; i++)
			screens[i] = new Screen("Screen-" + (i+1), rowLengths);
	}



	
	// Methods

	public void addScreen(String screenName){

		Screen[] updatedScreens = new Screen[screens.length+1];

		for(int i=0; i<screens.length; i++)

			updatedScreens[i] = screens[i];

		updatedScreens[updatedScreens.length-1] = new Screen(screenName); 

		screens = updatedScreens;

	}

	public String getCinemaName(){

		return cinemaName;

	}

	public void removeScreen(String screenName){

		Screen[] updatedScreens = new Screen[screens.length-1];

		for(int i=0; i<screens.length; i++){

			if(screens[i].getScreenName().equals(screenName) && screenName!=null){

				for(int j=i; j<screens.length-1; j++){

					screens[i] = screens[i+1];

				}

				for(int k=0; k<updatedScreens.length; k++)
				
					updatedScreens[k] = screens[k];

			}

		}

		screens = updatedScreens;

	}

	public Screen getScreenByName(String screenName){

		if(screenName == null)

			return null;


		for(Screen s: screens){

			if(s.getScreenName().equals(screenName))

				return s;

		}

		return null;

	}

	public Screen getScreenByIndex(int index){

		if(index < 0 || index >= screens.length)

			return null;

		return screens[index];

	}

	public boolean book(String screenName, String seatId){

		if(screenName!=null && seatId!=null){

			for(Screen s: screens){

				if(s.getScreenName().equals(screenName) && s.book(seatId))
				
					return true;
			}

		}

		return false;

	}

	public boolean cancel(String screenName, String seatId){

		if(screenName!=null && seatId!=null){

			for(Screen s: screens){

				if(s.getScreenName().equals(screenName) && s.cancel(seatId))
				
					return true;
			}

		}

		return false;

	}

	public int totalSeats(){

		int totalSeats = 0;

		for(Screen s: screens)

			totalSeats += s.getTotalSeatCount();

		
		return totalSeats;
	}

	public int totalSeatsBySeatType(SeatType seatType){

		int totalSeats = 0;

		for(Screen s: screens)

			totalSeats += s.getTotalSeatCount(seatType);

		
		return totalSeats;
	}

	public int availableSeatsBySeatType(SeatType seatType){

		int availableSeats = 0;

		for(Screen s: screens)

			availableSeats += s.getAvailableSeatCount(seatType);

		
		return availableSeats;
	}

	public int availableSeats(){

		int availableSeatsCount = 0;

		for(Screen s: screens)

			availableSeatsCount += s.getAvailableSeatCount();

		
		return availableSeatsCount;
	}

	public void printReport(){

		for(Screen s: screens){

			s.displayLayout();

			System.out.println();

		}

			

	}

	public int getNoOfScreens(){

		return screens.length;

	}

	public void displayLayout(){

		for(Screen s: screens)
		
			s.displayLayout();
	
	}



	@Override
	public String toString(){

		String str = "Cinema Name: " + cinemaName + ", No Of Screens: " + screens.length + ", Total Seats: " + totalSeats() + ", Available Seats: " + availableSeats();

		return str;

	}
	
}
