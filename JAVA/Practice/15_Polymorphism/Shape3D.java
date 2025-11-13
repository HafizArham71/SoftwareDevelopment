public abstract class Shape3D extends Shape{

	// Attributes

	double density;
	double mass;
	boolean isSolid;



	// Constructor

	public Shape3D(String name, String color, String shapeId, boolean isFilled, String dateCreated, double density, double mass, boolean isSolid){

		super(name, color, shapeId, isFilled, dateCreated);

		this.density = density;
		this.mass = mass;
		this.isSolid = isSolid;

	}

	// Methods
	
	abstract double calVolume();

}