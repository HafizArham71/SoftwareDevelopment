public class CityCinema{

	
	// Attributes
	
	private String cityName;
	private int noOfScreens;
	public static final int DEFAULT_NUM_CINEMAS = 10;
	public static final int DEFAULT_NUM_SCREENS = 10;
	private Cinema[] cinemas;


	public CityCinema(){

		this("Karachi");

	}

	public CityCinema(String cityName){

		this(cityName, DEFAULT_NUM_CINEMAS);

	}

	public CityCinema(String cityName, int noOfCinemas){

		this(cityName, noOfCinemas, DEFAULT_NUM_SCREENS);

	}

	public CityCinema(String cityName, int noOfCinemas, int noOfScreens){

		this.cityName = cityName;
		this.noOfScreens = noOfScreens;
		this.cinemas = new Cinema[noOfCinemas];

		// Initializing Cinema

		for(int i=0; i<cinemas.length; i++)
			
			cinemas[i] = new Cinema("Cinema-" + (i+1), noOfScreens);

	}



	// Methods

	public String findFirstAvailableVIPSeat(){

		StringBuilder str = new StringBuilder();

		for(int i=0; i<cinemas.length; i++){

			str.append(cinemas[i].getCinemaName() + "\n ");

			for(int j=0; j<cinemas[i].getScreensCount(); j++){

				str.append(cinemas[i].getScreens()[j].getScreenName() + "\n ");

				if(cinemas[i].findScreenByIndex(j).findFirstAvailableSeat(SeatType.VIP)!=null){

					str.append(cinemas[i].findScreenByIndex(j).findFirstAvailableSeat(SeatType.VIP) + "\n\n");

				}else
					str.append("No VIP Seat Available in the screen");
			}
		}

		return str.toString();

	}

	public int getTotalSeats(){

		int totalSeats = 0;

		for(Cinema c: cinemas)
			totalSeats+=c.getTotalSeats();

		return totalSeats;

	}

	public int getAvailableSeats(){

		int availableSeats = 0;

		for(Cinema c: cinemas)
			availableSeats+=c.getAvailableSeats();

		return availableSeats;

	}

	public void addCinema(String cinemaName){
	
		Cinema[] updatedCinema = new Cinema[cinemas.length+1];

		for(int i=0; i<cinemas.length; i++)
			updatedCinema[i] = cinemas[i];

		updatedCinema[cinemas.length] = new Cinema(cinemaName);

		cinemas = updatedCinema;
			
	}

	public Cinema findCinemaByName(String cinemaName){

		for(Cinema c: cinemas){
			if(c.getCinemaName().equals(cinemaName))
				return c;
		}
	
		return null;
	
	}

	public void removeCinema(String cinemaName){
	
		for(int i=0; i<cinemas.length; i++){

			if(cinemas[i].getCinemaName().equals(cinemaName)){

				for(int j=i; j<cinemas.length-1; j++){

					cinemas[j] = cinemas[j+1];
				}

			}	
		}

		Cinema[] updatedCinemas = new Cinema[cinemas.length-1];

		for(int k=0; k<updatedCinemas.length; k++)
			updatedCinemas[k] = cinemas[k];

		cinemas = updatedCinemas;

			
	}

	public boolean bookSeat(String cinemaName, String screenName, String seatId){

		for(Cinema c: cinemas){

			if(c.getCinemaName().equals(cinemaName) && c!=null)
				return c.bookSeat(screenName, seatId);

		}

		return false;

	}

	public boolean cancelSeat(String cinemaName, String screenName, String seatId){

		for(Cinema c: cinemas){

			if(c.getCinemaName().equals(cinemaName) && c!=null)
				return c.cancelSeat(screenName, seatId);

		}

		return false;

	}


	@Override
	public String toString(){
		
		StringBuilder str = new StringBuilder();

		for(Cinema c: cinemas)
			str.append(c + "\n");

		return str.toString();
	}


}