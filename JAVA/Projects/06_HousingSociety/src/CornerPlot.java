public class CornerPlot extends Plot{


	
	// Attributes
	
	private double secondFrontWidth;



	// Constructor

	public CornerPlot(int row, int col, PlotType plotType, ShapeType shapeType, Shape shape, boolean isAvailable, double secondFrontWidth){

		super(row, col, plotType, shapeType, shape, isAvailable);

		this.secondFrontWidth = secondFrontWidth;

	}


	
	// Methods

	public double getSecondFrontWidth(){

		return secondFrontWidth;

	}

	public void setSecondFrontWidth(double secondFrontWidth){

		this.secondFrontWidth = secondFrontWidth;

	}



	@Override
	public String toString(){

	
		double basePrice = getPlotType().getPrice();
		double premiumPrice = basePrice + basePrice*0.08;	
	
		String str = String.format("[ PlotId: %s, PlotType: %s, Shape: %s, SecondFrontWidth: %.2f, Area: %.2f square-unit, Price: %,.2f PKR, Availability: %b ]", getId(), getPlotType(), shapeType, secondFrontWidth, shape.getArea(), premiumPrice, isAvailable());

		return str;
	}

}



/*

To demonstrate inheritance without abstract classes, include a concrete CornerPlot as a subclass of Plot that adds a second road frontage (two widths) and applies a corner premium—for example, +8% over the base price. Preload each block with a mix of regular and corner plots so the premium naturally appears in printed results.

*/