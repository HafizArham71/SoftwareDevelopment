public class CityCinema{


	// Attributes

	private String name;
	private Cinema[] cinema;
	private int numCinemas;
	public static int defaultLength = 10;

	
	// Constructors

	public CityCinema(){
		this("Cinema 1");
	}

	public CityCinema(String cinemaName){
		this(cinemaName, Cinema[] cinema);
	}

	public CityCinema(String cinemaName, Cinema[] cinema){
		this(cinemaName, cinema, defaultLength);
	}

	public CityCinema(String cinemaName, Cinema[] cinema, int length){

		this.name = cinemaName;
		this.cinema = cinema;
		this.numCinemas = length;

		cinema = new Cinema[length]

		for(int i=0; i<numCinemas; i++){
			cinema[i] = new Cinema();
		}
	
	}

}