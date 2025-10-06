public class SeatDemo {
    public static void main(String[] args) {

        Seat defaultSeat = new Seat();
	Seat premiumSeat = new Seat(3, 7, SeatType.PREMIUM, SeatType.PREMIUM.getPrice());
	Seat vipSeat = new Seat(1, 5, SeatType.VIP, SeatType.VIP.getPrice());
	Seat reclinerSeat = new Seat(4, 2, SeatType.RECLINER, SeatType.RECLINER.getPrice());

	System.out.println(defaultSeat);
	System.out.println(premiumSeat);
	System.out.println(vipSeat);
	System.out.println(reclinerSeat);

	
    }
}
