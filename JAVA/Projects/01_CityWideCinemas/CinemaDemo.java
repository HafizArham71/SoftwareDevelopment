public class CinemaDemo{

	public static void main(String[] args){
		
		Cinema cinema1 = new Cinema();


		cinema1.addScreen("Arham's Screen");

		cinema1.printReport();

		System.out.println(cinema1);

		cinema1.removeScreen("Arham's Screen");

		cinema1.printReport();

		System.out.println(cinema1);

		System.out.println(cinema1.getScreenByName("Screen-3"));

		System.out.println(cinema1.getScreenByIndex(3));

		System.out.println(cinema1.book("Screen-1", "2-003"));

		System.out.println(cinema1.book("Screen-2", "2-003"));

		System.out.println(cinema1.book("Screen-3", "2-003"));

		System.out.println(cinema1.book("Screen-4", "2-003"));

		System.out.println(cinema1.book("Screen-5", "2-003"));

		System.out.println(cinema1.cancel("Screen-1", "2-003"));

		System.out.println(cinema1.cancel("Screen-1", "2-003"));



		cinema1.printReport();

		
		System.out.println("Total Seats: " + cinema1.totalSeats());

		System.out.println("Available Seats: " + cinema1.availableSeats());

		System.out.println("Total REGULAR Seats: " + cinema1.totalSeatsBySeatType(SeatType.REGULAR));

		System.out.println("Available REGULAR Seats: " + cinema1.availableSeatsBySeatType(SeatType.REGULAR));


		
	}
}