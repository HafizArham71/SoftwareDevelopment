public abstract class Shape{


	// Attributes

	String name;
	String color;
	boolean isFilled;
	String dateCreated;
	String shapeId;



	// Constructors

	public Shape(String name, String color, String shapeId, boolean isFilled, String dateCreated){
	
		this.name = name;
		this.color = color;
		this.shapeId = shapeId;
		this.isFilled = isFilled;
		this.dateCreated = dateCreated;	

	}


	// Methods 

	abstract double calArea();
	abstract void move();
	abstract void rotate();



}