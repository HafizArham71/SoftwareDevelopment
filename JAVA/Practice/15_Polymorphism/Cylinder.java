public class Cylinder extends Shape3D{

	// Attributes
	
	double radius;
	double height;

	// Constructors

	public Cylinder(String name, String color, String shapeId, boolean isFilled, String dateCreated, double density, double mass, boolean isSolid, double radius, double height){

		super(name, color, shapeId, isFilled, dateCreated, density, mass, isSolid);

		this.radius = radius;
		this.height = height;

	}

	// Methods
	
	double calVolume(){

		return Math.PI * Math.pow(radius, 2) * height;

	}

	double calArea(){

		return (2 * Math.PI * radius * height) + (2 * Math.PI * Math.pow(radius, 2));

	}

	void move(){

		System.out.println("Object is moving");

	}

	void rotate(){

		System.out.println("Object is rotating");

	}
	

}