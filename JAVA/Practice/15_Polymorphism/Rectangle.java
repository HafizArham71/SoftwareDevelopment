public class Rectangle extends Shape2D{

	// Attributes
	
	double length;
	double width;

	// Constructors

	public Rectangle(String name, String color, String shapeId, boolean isFilled, String dateCreated, double length, double width){

		super(name, color, shapeId, isFilled, dateCreated);

		this.length = length;
		this.width = width;

	}

	// Methods
	
	public double circumference(){

		return (2 * length) + (2 * width);

	}

	double calArea(){

		return length * width;

	}

	void move(){

		System.out.println("Object is moving");

	}

	void rotate(){

		System.out.println("Object is rotating");

	}
	

}