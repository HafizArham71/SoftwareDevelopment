public class CityHousing{

	
		
	// Attributes

	private String cityName;
	private HousingSociety[] housingSociety;
	private static final int DEFAULT_NUM_SOCIETIES = 5;



	// Constructors

	public CityHousing(){

		this("City Name");

	}

	public CityHousing(String cityName){

		this(cityName, DEFAULT_NUM_SOCIETIES);

	}

	public CityHousing(String cityName, int noOfSocieties){

		this.cityName = cityName;
		this.housingSociety = new HousingSociety[noOfSocieties];

		// initialize Societies

		int societyNum = 1;

		for(int i=0; i<housingSociety.length; i++)
	
			housingSociety[i] = new HousingSociety("Society-" + (societyNum++), 5);

	}



	@Override
	public String toString(){

		StringBuilder str = new StringBuilder();

		int societyNum = 1;

		for(HousingSociety h: housingSociety){

			str.append("Society-" + (societyNum++) + "\n");
				
			str.append(h + "\n");

		}
			
		return str.toString();
	}

}