public class SeatDemo{

	public static void main(String[] args){
		Seat seat1 = new Seat(1, 4, SeatType.REGULAR, 500);
		System.out.println(seat1);
		System.out.printf("Book Seat: %b\n", seat1.bookSeat());
		System.out.println(seat1);
		System.out.println("Id: " + seat1.getId());	
		System.out.println("SeatType: " + seat1.getSeatType());
		System.out.println("isAvailable: " + seat1.isAvailable());
		System.out.println("Price: " + seat1.getPrice());
		seat1.cancelBooking();
		System.out.println("After cancel Booking: " + seat1.isAvailable());
		seat1.setSeatType(SeatType.PREMIUM);	
		seat1.setPrice(750);	
		System.out.println(seat1);
		seat1.setId(5, 1);
		System.out.println(seat1);
	}
}