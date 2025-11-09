public enum PlotType{

	RES_5_MARLA("5 Marla Residential", 4000000), RES_10_MARLA("10 Marla Residential", 7500000), RES_1_KANAL("1 Kanal Residential", 14000000), COMM_SHOP("Comercial Shop", 3000000), COMM_OFFICE("Comercial Office", 5000000), PARKING("Parking", 200000);
	

	
	// Attributes
	
	private double price;
	private String title;


	
	// Constructor

	PlotType(String title, double price){

		this.title = title;
		this.price = price;

	}



	// Methods

	public String getTitle(){

		return title;

	}

	public double getPrice(){

		return price;

	}

	public void setTitle(String title){

		this.title = title;

	}

	public void setPrice(double price){

		this.price = price;

	}

	
}