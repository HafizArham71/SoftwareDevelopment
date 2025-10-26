public class CityCinemaDemo{

	public static void main(String[] args){

		/*CityCinema city1 = new CityCinema();

		System.out.println(city1);

		city1.addCinema("Arham's Cinema");

		System.out.println(city1);

		city1.removeCinema("Arham's Cinema");

		System.out.println(city1);

		System.out.println(city1.findCinemaByName("Cinema-3"));

		System.out.println(city1.book("Cinema-1", "Screen-1", "1-001"));

		System.out.println(city1.book("Cinema-2", "Screen-1", "1-001"));

		System.out.println(city1.book("Cinema-3", "Screen-1", "1-001"));

		System.out.println(city1.cancel("Cinema-2", "Screen-1", "1-001"));

		city1.firstAvailableVIPSeat();



		//System.out.println(city1);*/


		CityCinema Lahore = new CityCinema("Lahore");

		CityCinema Karachi = new CityCinema("Karachi");

		CityCinema Islamabad = new CityCinema("Islamabad");


		Lahore.preloadCity();

		Karachi.preloadCity();

		Islamabad.preloadCity();


		CityCinema Multan = new CityCinema("Multan", 10, 5);


		System.out.println("\n");

		Lahore.displayLayout();

		System.out.println("\n" + Lahore);

		Multan.displayLayout();

		System.out.println("\n" + Multan);

		Islamabad.displayLayout();

		System.out.println("\n" + Islamabad);

		Multan.displayLayout();

		System.out.println("\n" + Multan);



	}

}