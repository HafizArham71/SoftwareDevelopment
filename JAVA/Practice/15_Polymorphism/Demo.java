public class Demo{



	public static void main(String[] args){

		Shape[] shapes = new Shape[100];

		// Initiaizing Array

		for(int i=0; i<shapes.length/4; i++)
			
			shapes[i] = new Circle("Circle", "Blue", String.format("%d", i+1), true, "1-01-2001", i+1);	

		for(int i=shapes.length/4; i<shapes.length/2; i++)
			
			shapes[i] = new Rectangle("Rectangle", "Purple", String.format("%d", i+1), true, "2-02-2005", i+1, i+2);	

		for(int i=shapes.length/2; i<(shapes.length*3)/4; i++)
			
			shapes[i] = new Sphere("Sphere", "Red", String.format("%d", i+1), true, "3-03-2003", i+3, i+4, false, i+5);	

		for(int i=(shapes.length*3)/4; i<shapes.length; i++)
			
			shapes[i] = new Cylinder("Cylinder", "Green", String.format("%d", i+1), true, "5-03-2001", i+6, i+7, true, i+8, i+9);	



		// Displaying Array

		int index = 0;

		for(Shape s: shapes){

			if(s instanceof Circle){

				Circle temp = (Circle)s;
	
				System.out.printf("CIRCLE_%02d\n", index+1);

				System.out.printf("Area of circle: %.2f\n", temp.calArea());

				System.out.printf("Circumference of circle: %.2f\n", temp.circumference());
				temp.move();

				temp.rotate();

				System.out.println();

			}

			else if(s instanceof Rectangle){

				Rectangle temp = (Rectangle)s;
	
				System.out.printf("RECTANGLE_%02d\n", index+1);

				System.out.printf("Area of rectangle: %.2f\n", temp.calArea());

				System.out.printf("Circumference of rectangle: %.2f\n", temp.circumference());
				temp.move();

				temp.rotate();

				System.out.println();

			}

			else if(s instanceof Sphere){

				Sphere temp = (Sphere)s;
	
				System.out.printf("SPHERE_%02d\n", index+1);

				System.out.printf("Area of sphere: %.2f\n", temp.calArea());

				System.out.printf("Volume of sphere: %.2f\n", temp.calVolume());
				
				temp.move();

				temp.rotate();

				System.out.println();

			}

			else{

				Cylinder temp = (Cylinder)s;
	
				System.out.printf("CYLINDER_%02d\n", index+1);

				System.out.printf("Area of cylinder: %.2f\n", temp.calArea());

				System.out.printf("Volume of cylinder: %.2f\n", temp.calVolume());
				temp.move();

				temp.rotate();

				System.out.println();

			}


			index++;

		}
	}

}