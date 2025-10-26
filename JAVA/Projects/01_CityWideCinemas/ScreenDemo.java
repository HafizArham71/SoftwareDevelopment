public class ScreenDemo{

	public static void main(String[] args){

		Screen screen = new Screen();

		for(int i=0; i<screen.listAvailable(SeatType.VIP).length; i++)
			
			System.out.println(screen.listAvailable(SeatType.VIP)[i]);

		screen.displayLayout();

		System.out.println(screen.getRowCount());

		System.out.println(screen.priceFor(SeatType.PREMIUM));

		System.out.println(screen.seatTypeFor(1, 3));

		System.out.println(screen.getRowLength(3));

		System.out.println(screen.cancel("3-004"));

		System.out.println(screen.findFirstAvailable(SeatType.REGULAR));

		System.out.println(screen.getAvailableSeatCount(SeatType.REGULAR));

		screen.displayVerbose();

		System.out.println(screen.getTotalSeatCount());

		System.out.println(screen.book(2, 5));

		System.out.println(screen.getSeat(3, 3));

		screen.setRowType(1, SeatType.PREMIUM, 750);

		System.out.println(screen.getAvailableSeatCount());

		System.out.println(screen.getSeat("3-005"));

		System.out.println(screen.getScreenName());

		System.out.println(screen.cancel(2, 4));

		System.out.println(screen.book(2, 4));


	}
}