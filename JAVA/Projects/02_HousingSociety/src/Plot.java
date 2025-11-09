public class Plot{



	// Attributes

	private String id;		// like 3-007
	private boolean isAvailable;
	protected Shape shape;
	private PlotType plotType;
	protected ShapeType shapeType;





	// Constructors

	public Plot(){

		this(1);

	}

	public Plot(int row){

		this(row, 1);

	}

	public Plot(int row, int col){

		this(row, col, PlotType.RES_5_MARLA);

	}

	public Plot(int row, int col, PlotType plotType){

		this(row, col, plotType, ShapeType.RECTANGLE);

	}

	public Plot(int row, int col, PlotType plotType, ShapeType shapeType){

		this(row, col, plotType, shapeType, new Shape(10, 20));

	}

	public Plot(int row, int col, PlotType plotType, ShapeType shapeType, Shape shape){

		this(row, col, plotType, shapeType, shape, true);

	}

	public Plot(int row, int col, PlotType plotType, ShapeType shapeType, Shape shape, boolean isAvailable){

		this.id = String.format("%d-%03d", row, col);
		this.plotType = plotType;
		this.shapeType = shapeType;
		this.isAvailable = isAvailable;
		this.shape = shape;

	}




	// Methods

	public String getId(){

		return id;

	}

	public PlotType getPlotType(){

		return plotType;

	}

	public boolean isAvailable(){

		return isAvailable;

	}

	public Shape getShape(){

		return shape;

	}

	public ShapeType getShapeType(){

		return shapeType;

	}



	public void setId(int row, int col){

		this.id = String.format("%d-%03d", row, col);

	}

	public void setPlotType(PlotType plotType){

		this.plotType = plotType;

	}

	public void setAvailable(boolean isAvailable){

		this.isAvailable = isAvailable;

	}

	public void setShape(Shape shape){

		this.shape = shape;

	}

	public void setShapeType(ShapeType shapeType){

		this.shapeType = shapeType;

	}



	public boolean bookPlot(){

		if(isAvailable){

			isAvailable = false;

			return true;

		}

		return false;

	}

	public boolean cancelPlotBooking(){

		if(!isAvailable){

			isAvailable = true;

			return true;

		}

		return false;

	}


	


	@Override
	public String toString(){

		String str = String.format("[ PlotId: %s, PlotType: %s, Shape: %s, Area: %.2f square-unit, Price: %,.2f PKR, Availability: %b ]", id, plotType, shapeType, shape.getArea(), plotType.getPrice(), isAvailable);

		return str;

	}
	

}


/*

The core rentable unit is a Plot, identified by a human-friendly ID street-plot such as 3-007. Each plot carries a PlotType from a fixed enumeration tailored to local real estate—RES_5_MARLA, RES_10_MARLA, RES_1_KANAL, COMM_SHOP, COMM_OFFICE, and PARKING—and a list price that is derived automatically from its type so individual price entry is unnecessary (for example: RES_5_MARLA = 4,000,000 PKR; RES_10_MARLA = 7,500,000 PKR; RES_1_KANAL = 14,000,000 PKR; COMM_SHOP = 3,000,000 PKR; COMM_OFFICE = 5,000,000 PKR; PARKING = 200,000 PKR). A plot tracks availability (booked vs available), starts available by default, and changes state only through safe booking and cancellation methods. Its text summary should concisely show ID, type, area, price, and availability so pricing and state are obvious in the output.


*/