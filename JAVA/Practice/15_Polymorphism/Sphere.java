public class Sphere extends Shape3D{

	// Attributes
	
	double radius;

	// Constructors

	public Sphere(String name, String color, String shapeId, boolean isFilled, String dateCreated, double density, double mass, boolean isSolid, double radius){

		super(name, color, shapeId, isFilled, dateCreated, density, mass, isSolid);

		this.radius = radius;

	}

	// Methods
	
	double calVolume(){

		return (4/3) * Math.PI * Math.pow(radius, 3);

	}

	double calArea(){

		return 4 * Math.PI * Math.pow(radius, 2);

	}

	void move(){

		System.out.println("Object is moving");

	}

	void rotate(){

		System.out.println("Object is rotating");

	}
	

}