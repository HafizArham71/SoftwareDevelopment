public abstract class Shape2D extends Shape{

	// Attributes
	

	// Constructor

	public Shape2D(String name, String color, String shapeId, boolean isFilled, String dateCreated){

		super(name, color, shapeId, isFilled, dateCreated);

	}


	// Methods

	abstract double circumference();

	

}