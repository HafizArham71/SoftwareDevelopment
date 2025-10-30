public class CommercialMarket{

	

	
	// Attributes

	private String marketName;
	public static final int DEFAULT_NUM_SHOPS = 20;
	private Shop[] shops;
	private PlotType plotType;
	private Shape shape;
	private ShapeType shapeType;

	




	// Constructor

	public CommercialMarket(){

		this("Default Market");

	}

	public CommercialMarket(String marketName){

		this(marketName, DEFAULT_NUM_SHOPS);

	}

	public CommercialMarket(String marketName, int noOfShops){

		this(marketName, noOfShops, PlotType.COMM_SHOP);

	}

	public CommercialMarket(String marketName, int noOfShops, PlotType plotType){

		this(marketName, noOfShops, PlotType.COMM_SHOP, ShapeType.RECTANGLE);


	}

	public CommercialMarket(String marketName, int noOfShops, PlotType plotType, ShapeType shapeType){

		this(marketName, noOfShops, PlotType.COMM_SHOP, shapeType, new Shape(10, 20));


	}

	public CommercialMarket(String marketName, int noOfShops, PlotType plotType, ShapeType shapeType, Shape shape){

		this.marketName = marketName;
		this.shops = new Shop[noOfShops];
		this.plotType = plotType;
		this.shape = shape;
		this.shapeType = shapeType;

		//int index = 0;
	
		//for(Shop s: shops)
		
		//	s = new Shop(index++, index+1, plotType, shapeType, shape);

		for(int i=0; i<shops.length; i++)
		
			shops[i] = new Shop((i+1), plotType, shapeType, shape);

	}



	@Override
	public String toString(){

		StringBuilder str = new StringBuilder();

		for(Shop s: shops)

			str.append("   " + s + "\n");

		return str.toString();

	}

	

}