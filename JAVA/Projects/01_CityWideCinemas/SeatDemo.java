public class SeatDemo{

	public static void main(String[] args){
		
		Seat s = new Seat();

		System.out.println("Before Modify");

		System.out.println("Id: " + s.getId());
		System.out.println("Price: " + s.getPrice());
		System.out.println("SeatType: " + s.getSeatType());
		System.out.println("Availability: " + s.isAvailable());

		System.out.println("\n" + s);



		s.setId(3, 7);
		s.setPrice(750);
		s.setSeatType(SeatType.PREMIUM);
		s.bookSeat();

		System.out.println("\nAfter Modify");

		System.out.println("Id: " + s.getId());
		System.out.println("Price: " + s.getPrice());
		System.out.println("SeatType: " + s.getSeatType());
		System.out.println("Availability: " + s.isAvailable());

		System.out.println("\n" + s);


		s.cancelBooking();

		System.out.println("\nAfter CancelBooking");

		System.out.println("Id: " + s.getId());
		System.out.println("Price: " + s.getPrice());
		System.out.println("SeatType: " + s.getSeatType());
		System.out.println("Availability: " + s.isAvailable());

		System.out.println("\n" + s);


	}
}