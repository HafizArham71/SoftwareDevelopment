public class Demo{



	public static void main(String[] args){

		Shape[] shapes = new Shape[40];

		// Initiaizing Array

		for(int i=0; i<shapes.length/4; i++)
			
			shapes[i] = new Circle("Circle", "Blue", String.format("%d", i+1), true, "1-01-2001", 4);	

		for(int i=shapes.length/4; i<shapes.length/2; i++)
			
			shapes[i] = new Rectangle("Rectangle", "Purple", String.format("%d", i+1), true, "2-02-2005", 6, 8);	

		for(int i=shapes.length/2; i<shapes.length*(3/4); i++)
			
			shapes[i] = new Sphere("Sphere", "Red", String.format("%d", i+1), true, "3-03-2003", 6, 7, false, 5);	

		for(int i=shapes.length*(3/4); i<shapes.length; i++)
			
			shapes[i] = new Cylinder("Cylinder", "Green", String.format("%d", i+1), true, "5-03-2001", 4, 8, true, 5, 9);	



		// Displaying Array

		for(int i=0; i<shapes.length; i++)

			System.out.printf("Shape %02d: %2f\n", i+1, shapes[i].calArea());
	}

}