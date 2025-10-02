public class CityCinema{

	String cityName;
	int noOfCinemas;
	Cinema[] cinema;

	public CityCinema(String cityName, int noOfCinemas){
		this.cityName = cityName;
		this.noOfCinemas = noOfCinemas;
		cinema = new Cinema[noOfCinemas];

		for(int i=0; i<cinema.length; i++){
			cinema[i] = new Cinema("Cinema " + (i+1), 4);
		}
	}

	@Override 
	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append(cityName);
		
		for(int i=0; i<cinema.length; i++){
			str.append("\n " + cinema[i]);
		}

		return str.toString();
	}
}