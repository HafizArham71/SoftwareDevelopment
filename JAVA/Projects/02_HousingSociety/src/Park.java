public class Park{

	

	// Attributes

	private String parkName;
	private int id;
	private Shape shape;
	private ShapeType shapeType;
	private PlotType plotType;
	private boolean isAvailable;




	// Constructor

	public Park(){

		this(1);

	}

	public Park(int id){

		this(id, "Default Park");

	}

	public Park(int id, String parkName){

		this(id, parkName, ShapeType.RECTANGLE);

	}

	public Park(int id, String parkName, ShapeType shapeType){

		this(id, parkName, shapeType, new Shape(10, 20));

	}

	public Park(int id, String parkName, ShapeType shapeType, Shape shape){

		this(id, parkName, shapeType, new Shape(10, 20), PlotType.PARKING);
	}

	public Park(int id, String parkName, ShapeType shapeType, Shape shape, PlotType plotType){

		this.parkName = parkName;
		this.id = id;
		this.shapeType = shapeType;
		this.shape = shape;
		this.plotType = plotType;
		this.isAvailable = true;

	}



		
	// Methods

	public int getId(){

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



	public void setId(int id){

		this.id = id;

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


	


	@Override
	public String toString(){

		return String.format("[ Park-%03d, %s, %s, %.2f square units, %s]", id, parkName, shapeType, shape.getArea(), plotType);

	}
	

}