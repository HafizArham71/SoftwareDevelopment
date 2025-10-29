public class Shape{


	
	// Attributes

	private double area;



	// Constructors

	public Shape(){

		this(10, 20);

	}

	public Shape(double width, double depth){

		this.area = width*depth;

	}

	public Shape(double front, double back, double depth){

		this.area = ((front + back)/2) * depth;

	}

	public Shape(double width, double depth, double width1, double depth1){

		this.area = (width * depth) + (width1 * depth1);

	}



	
	// Methods

	public double getArea(){

		return area;

	}	

}


/*

/*

To make the system more realistic and to introduce geometric reasoning without heavy math, each plot must also have a shape with dimensions, and its area must be computed from that shape. Use a small shape set such as RECTANGLE (area = width × depth), TRAPEZOID (area = ((front + back) ÷ 2) × depth), and L_SHAPE (area = (w₁ × d₁) + (w₂ × d₂)). Store the minimal dimensions needed per shape ( widths and depth), compute the area in a helper, and keep all values in a simple “square-unit” system so you don’t have to worry about real-world conversions. To demonstrate inheritance without abstract classes, include a concrete CornerPlot as a subclass of Plot that adds a second road frontage (two widths) and applies a corner premium—for example, +8% over the base price. Preload each block with a mix of regular and corner plots so the premium naturally appears in printed results.

*/
