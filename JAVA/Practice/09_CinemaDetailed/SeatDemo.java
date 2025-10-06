public class SeatDemo {
    public static void main(String[] args) {

        Seat defaultSeat = new Seat();
	Seat premiumSeat = new Seat(3, 7, SeatType.PREMIUM, SeatType.PREMIUM.getPrice());

	System.out.println(defaultSeat);
	System.out.println(premiumSeat);

	
    }
}
