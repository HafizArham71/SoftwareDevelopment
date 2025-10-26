public class CityCinema{

	
	
	// Attributes

	private String cityName;
	private Cinema[] cinemas;
	private static final int DEFAULT_NUM_CINEMAS = 5;
	private static final int DEFAULT_NUM_SCREENS = 5;



	
	// Constructors

	public CityCinema(){

		this("Default Cinema");

	}

	public CityCinema(String cityName){

		this(cityName, DEFAULT_NUM_CINEMAS);

	}

	public CityCinema(String cityName, int noOfCinemas){

		this(cityName, noOfCinemas, DEFAULT_NUM_CINEMAS);

	}

	public CityCinema(String cityName, int noOfCinemas, int noOfScreens){

		this.cityName = cityName;
		this.cinemas = new Cinema[noOfCinemas];

		
		// Initialize cinemas

		int index = 1;
		
		for(int i=0; i<cinemas.length; i++)
	
			cinemas[i] = new Cinema("Cinema-" + index++, noOfScreens);

	}


	
	// Methods

	public void addCinema(String cinemaName){

		Cinema updatedCinema[] = new Cinema[cinemas.length+1];

		for(int i=0; i<cinemas.length; i++)
		
			updatedCinema[i] = cinemas[i];

		updatedCinema[cinemas.length] = new Cinema("Arham's Cinema");

		cinemas = updatedCinema;

	}

	public void removeCinema(String cinemaName){

		for(int i=0; i<cinemas.length; i++){

			if(cinemas[i].getCinemaName().equals(cinemaName)){

				for(int j=i; j<cinemas.length-1; j++){

					cinemas[j] = cinemas[j+1];

				}

			}

		}

		Cinema updatedCinema[] = new Cinema[cinemas.length-1];

		for(int i=0; i<updatedCinema.length; i++)
		
			updatedCinema[i] = cinemas[i];

		cinemas = updatedCinema;

	}

	public Cinema findCinemaByName(String cinemaName){

		for(Cinema c: cinemas){

			if(c.getCinemaName().equals(cinemaName) && cinemaName!=null)
				
				return c;

		}

		return null;

	}

	public boolean book(String cinemaName, String screenName, String seatId){

		if(cinemaName!=null && screenName!=null && seatId!=null){

			for(Cinema c: cinemas){

				if(c.getCinemaName().equals(cinemaName) && c.book(screenName, seatId)){
				
					return true;

				}
	
			}

		}

		return false;

	}

	public boolean cancel(String cinemaName, String screenName, String seatId){

		if(cinemaName!=null && screenName!=null && seatId!=null){

			for(Cinema c: cinemas){

				if(c.getCinemaName().equals(cinemaName) && c.cancel(screenName, seatId)){
				
					return true;

				}
	
			}

		}

		return false;

	}


	public void firstAvailableVIPSeat(){

		String arr[];
		int count = 0, index = 0;

		for(int i=0; i<cinemas.length; i++){

			for(int j=0; j<cinemas[i].getNoOfScreens(); j++){

				if(cinemas[i].getScreenByIndex(j).findFirstAvailable(SeatType.VIP)!=null)
			
					count++;
			}
		}

		arr = new String[count];

		for(int k=0; k<cinemas.length; k++){

			for(int l=0; l<cinemas[k].getNoOfScreens(); l++){

				if(cinemas[k].getScreenByIndex(l).findFirstAvailable(SeatType.VIP)!=null){

					arr[index++] = cinemas[k].getCinemaName() + " > " + cinemas[k].getScreenByIndex(l).getScreenName() + " > Seat " 					+ cinemas[k].getScreenByIndex(l).findFirstAvailable(SeatType.VIP).getId() + " (" + 				cinemas[k].getScreenByIndex(l).findFirstAvailable(SeatType.VIP).getSeatType() + ", " 	+ 		cinemas[k].getScreenByIndex(l).findFirstAvailable(SeatType.VIP).getPrice() + " PKR)";

				}

			}

		}

		for(String elem: arr)
			
			System.out.println(elem);

	}

	public void preloadCity() {

		int logicalSize;

       		if (cityName.equalsIgnoreCase("Karachi")) {

        		cinemas = new Cinema[2];   
        		logicalSize = 2;

        		cinemas[0] = new Cinema("Atrium Saddar", 2);
        		cinemas[1] = new Cinema("Nueplex DHA", 2);
    		}

    		else if (cityName.equalsIgnoreCase("Lahore")) {

        		cinemas = new Cinema[2];   
        		logicalSize = 2;

        		cinemas[0] = new Cinema("CineStar Township", 2);
        		cinemas[1] = new Cinema("CineStar Gulberg", 2);
    		}

    		else if (cityName.equalsIgnoreCase("Islamabad")) {

        		cinemas = new Cinema[1];   
        		logicalSize = 1;

        		cinemas[0] = new Cinema("Centaurus Megaplex", 3);
    		}

    		else {
        		cinemas = new Cinema[1];
        		logicalSize = 1;
        		cinemas[0] = new Cinema("Default Cinema", 1);
    		}

	}

	public int getTotalSeats(){

		int totalNumberOfSeats = 0;

		for(Cinema c: cinemas)
		
			totalNumberOfSeats += c.totalSeats();

		return totalNumberOfSeats;

	}

	public int getAvailableSeats(){

		int availableNumberOfSeats = 0;

		for(Cinema c: cinemas)
		
			availableNumberOfSeats += c.availableSeats();

		return availableNumberOfSeats;

	}

	public void displayLayout(){

		System.out.println(cityName.toUpperCase());

		for(Cinema c: cinemas){
				
			System.out.println("\n" + c.getCinemaName());
			c.displayLayout();
		
		}

	}



	@Override
	public String toString(){

		StringBuilder line = new StringBuilder();

		for(int i=0; i<cinemas.length; i++){

			line.append(String.format("[ Cinema: %s, No Of Cinemas: %d, Total Seats: %d, Available Seats: %d ]\n", cinemas[i].getCinemaName(), cinemas.length, cinemas[i].totalSeats(), cinemas[i].availableSeats()));

		}

		line.append(String.format("\nOverall Status: Total Seats %d, Available Seats %d", getTotalSeats(), getAvailableSeats()));


		return line.toString();
		
			

	}

}

