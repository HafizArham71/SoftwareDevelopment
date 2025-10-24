/*public class CinemaDemo{

	public static void main(String[] args){
		
		Cinema cinema = new Cinema("Cinema-1");

		System.out.println(cinema);
		
	}
}*/


public class CinemaDemo {
    public static void main(String[] args) {

        // 1. Create default cinema (auto-loads default 5 screens)
        Cinema c1 = new Cinema("Galaxy Cineplex");
        System.out.println(c1);  // should print summary line

        // 2. Print initial report (preloaded screens)
        System.out.println("\n--- Initial Report ---");
        c1.printReport();

        // 3. Add a new custom screen
        System.out.println("\n--- Adding a new Screen ---");
        c1.addScreen("VIP-Screen");
        System.out.println(c1);

        // 4. Find a screen by name
        System.out.println("\n--- Finding a Screen ---");
        Screen found = c1.findScreenByName("Screen-2");
        if (found != null)
            System.out.println("Found: " + found.getScreenName());
        else
            System.out.println("Screen not found!");

        // 5. Book a few seats
        System.out.println("\n--- Booking Seats ---");
        boolean b1 = c1.bookSeat("Screen-1", "A1");
        boolean b2 = c1.bookSeat("Screen-1", "A2");
        boolean b3 = c1.bookSeat("VIP-Screen", "B1");
        System.out.println("Booking A1: " + b1);
        System.out.println("Booking A2: " + b2);
        System.out.println("Booking B1 (VIP): " + b3);

        // 6. Try cancelling one
        System.out.println("\n--- Cancel a Seat ---");
        boolean c = c1.cancelSeat("Screen-1", "A2");
        System.out.println("Cancelled A2: " + c);

        // 7. Print report again (should show seat status updated)
        System.out.println("\n--- Updated Report ---");
        c1.printReport();

        // 8. Show summary again
        System.out.println("\n--- Final Summary ---");
        System.out.println(c1);
    }
}
