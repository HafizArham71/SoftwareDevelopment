public class Screen{

	// Attributes
	private final double PRICE_REGULAR;
	private final double PRICE_PREMIUM;
	private final double PRICE_VIP;
	private final double PRICE_RECLINER;
	private final int DEFAULT_NO_ROWS;

	private String screenName;
	private Seat seat[][];
	private SeatType seatType;

	// Constructors
	public Screen(){
		this.PRICE_REGULAR = SeatType.REGULAR.getPrice();
		this.PRICE_PREMIUM = SeatType.PREMIUM.getPrice();
		this.PRICE_VIP = SeatType.VIP.getPrice();
		this.PRICE_RECLINER = SeatType.RECLINER.getPrice();
	
		this.DEFAULT_NO_ROWS = 5;
		this.seatType = SeatType.REGULAR;
		seat = new Seat[DEFAULT_NO_ROWS][];

		for(int i=0; i<DEFAULT_NO_ROWS; i++){
			seat[i] = new Seat[10+i];
		}

		for(int j=0; j<seat.length; j++){
			for(int k=0; k<seat[j].length; k++){
				seat[j][k] = new Seat(j, k, seatType, seatType.getPrice());
			}
		}

		this.screenName = "No Name";
	}

	public Screen(String screenName){
		this.PRICE_REGULAR = SeatType.REGULAR.getPrice();
		this.PRICE_PREMIUM = SeatType.PREMIUM.getPrice();
		this.PRICE_VIP = SeatType.VIP.getPrice();
		this.PRICE_RECLINER = SeatType.RECLINER.getPrice();
	
		this.DEFAULT_NO_ROWS = 5;
		this.seatType = SeatType.REGULAR;
		seat = new Seat[DEFAULT_NO_ROWS][];

		for(int i=0; i<DEFAULT_NO_ROWS; i++){
			seat[i] = new Seat[10+i];
		}

		for(int j=0; j<seat.length; j++){
			for(int k=0; k<seat[j].length; k++){
				seat[j][k] = new Seat(j, k, seatType, seatType.getPrice());
			}
		}

		this.screenName = "No Name";
	}

	// Method
	@Override
	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append(screenName);

		for(int i=0; i<seat.length; i++){
			for(int j=0; j<seat[i].length; j++){

			}
		}
		return "0";
	}

}