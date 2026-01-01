import java.util.ArrayList;

public class Demo2 {

	public static void main(String[] args) {

		Integers integerPrinter = new Integers(3);
		Doubles doublePrinter = new Doubles(4.56);
		Strings stringPrinter = new Strings("Ahmad");

		System.out.println(integerPrinter.num);
		System.out.println(doublePrinter.num);
		System.out.println(stringPrinter.name);

		// Generics

		//UniversalPrinter<Integer> printer1 = new UniversalPrinter<>(56);
		//UniversalPrinter<Double> printer2 = new UniversalPrinter<>(3.56);
		//UniversalPrinter<String> printer3 = new UniversalPrinter<>("Arham Mujahid");

		//System.out.println(printer1.value);
		//System.out.println(printer2.value);
		//System.out.println(printer3.value);

		System.out.println("\nStart");
		System.out.println("---------------------");

		UniversalPrinter<Rectangle, Square> printer1 = new UniversalPrinter<>(new Rectangle("Rectangle", 23, 45), new Square("Square", 34, 34));
		UniversalPrinter<Square, Rectangle> printer2 = new UniversalPrinter<>(new Square("Square", 23, 23), new Rectangle("Rectangle", 23, 45));
		UniversalPrinter<Rectangle, Square> printer3 = new UniversalPrinter<>(new Rectangle("Rectangle1", 23, 45), new Square("Square", 34, 34));

		printer1.show();
		printer2.show();
		printer3.show();



		ArrayList<Rectangle> rectangle = new ArrayList<>();

		rectangle.add(new Rectangle("Rectangle", 23, 56));
		//myCat.add(new Square("Dummy1", 24, 24));

		Rectangle ract = rectangle.get(0);

		shout("Arham", "Mujahid");
		shout(3.5, 4);
		shout(7, 45.67);

	}


	public static <T, V> V shout(T thingToPrint, V otherThingToPrint) {

		System.out.println(thingToPrint + "!!!");
		System.out.println(otherThingToPrint + "!!!");

		return otherThingToPrint;

	}

}