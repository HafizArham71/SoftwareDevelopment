public class Demo{

	public static void main(String[] args){

		Plot p1 = new Plot(2, 3, PlotType.COMM_OFFICE, ShapeType.RECTANGLE, new Shape(12, 45), true);

		Plot p2 = new Plot();

		CornerPlot p3 = new CornerPlot(5, 1, PlotType.RES_10_MARLA, ShapeType.L_SHAPE, new Shape(12, 45), true, 50);


		//System.out.println(p1);

		//System.out.println(p2);

		//System.out.println(p3);




		Block myBlock = new Block();

		System.out.println(myBlock);


	}

}