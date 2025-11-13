public class Circle extends Shape2D{

	// Attributes
	
	double radius;


	// Constructors

	public Circle(String name, String color, String shapeId, boolean isFilled, String dateCreated, double radius){

		super(name, color, shapeId, isFilled, dateCreated);

		this.radius = radius;

	}

	// Methods
	
	public double circumference(){

		return 2 * Math.PI * radius;

	}

	double calArea(){

		return Math.PI * Math.pow(radius, 2);

	}

	void move(){

		System.out.println("Object is moving");

	}

	void rotate(){

		System.out.println("Object is rotating");

	}
	

}