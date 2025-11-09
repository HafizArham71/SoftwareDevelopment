public class Shop{

	

	// Attributes

	private String id;		// like 3-007
	private boolean isAvailable;

	private PlotType plotType;
	private Shape shape;
	private ShapeType shapeType;





	// Constructors

	public Shop(){

		this(1);

	}

	public Shop(int id){

		this(id, PlotType.COMM_SHOP);

	}

	public Shop(int id, PlotType plotType){

		this(id, plotType, ShapeType.RECTANGLE);

	}

	public Shop(int id, PlotType plotType, ShapeType shapeType){

		this(id, plotType, shapeType, new Shape(10, 20));

	}

	public Shop(int id, PlotType plotType, ShapeType shapeType, Shape shape){

		this.id = String.format("%03d", id);
		this.plotType = plotType;
		this.shapeType = shapeType;
		this.isAvailable = true;
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

	public void setId(int id){

		this.id = String.format("%03d", id);

	}

	public void setPlotType(PlotType plotType){

		this.plotType = plotType;

	}

	public void setAvailable(boolean isAvailable){

		this.isAvailable = isAvailable;

	}

	public boolean book(){

		if(isAvailable){

			isAvailable = false;

			return true;

		}

		return false;

	}

	public boolean cancel(){

		if(!isAvailable){

			isAvailable = true;

			return true;

		}

		return false;

	}


	@Override
	public String toString(){

		String str = String.format("[ ShopId: %s, PlotType: %s, Shape: %s, Area: %.2f square-unit, Price: %,.2f PKR, Availability: %b ]", id, plotType, shapeType, shape.getArea(), plotType.getPrice(), isAvailable);

		return str;

	}


}