/*public class ScreenTest{

	public static void main(String[] args){

		int[] rowLengths = {1, 3, 5, 7, 9};
		Screen screen = new Screen("Screen 1", rowLengths);
		System.out.println(screen);
	}
}*/

public class ScreenTest {
    public static void main(String[] args) {

        // Step 1: Create a new screen with default setup
        Screen screen = new Screen("Cineplex Hall 1");
        System.out.println("Screen Created: " + screen.getScreenName());
        System.out.println("Total Seats: " + screen.getTotalSeatCount());
        System.out.println("Available Seats: " + screen.getAvailableSeatCount());
        System.out.println();

        // Step 2: Display initial detailed seat info
        System.out.println("Initial Seat Layout:");
        screen.displayVerbose();

        // Step 3: Book some seats
        System.out.println("Booking Seats...");
        screen.book(0, 0);   // Book first seat
        screen.book(0, 1);   // Book another seat
        screen.book("2-005"); // Book seat using ID

        // Step 4: Display updated availability
        System.out.println("\nAfter Booking Some Seats:");
        System.out.println("Available Seats: " + screen.getAvailableSeatCount());
        System.out.println("First Available VIP Seat: " + screen.getFirstAvailable(SeatType.VIP));
        System.out.println();

        // Step 5: Try booking an already booked seat
        System.out.println("Trying to Book Already Booked Seat 0,0:");
        boolean booked = screen.book(0, 0);
        System.out.println("Booking Success? " + booked);
        System.out.println();

        // Step 6: Cancel a booking
        System.out.println("Cancelling Booking for Seat 0,0:");
        boolean cancelled = screen.cancel(0, 0);
        System.out.println("Cancelled? " + cancelled);
        System.out.println("Available Seats after cancellation: " + screen.getAvailableSeatCount());
        System.out.println();

        // Step 7: Display final layout
        System.out.println("Final Seat Layout:");
        screen.displayVerbose();
    }
}
