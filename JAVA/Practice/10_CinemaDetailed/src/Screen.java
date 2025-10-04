public class Screen{

	// Attributes
	private final double PRICE_PREMIUM;
	private final int DEFAULT_NUM_ROWS;
	private final double PRICE_RECLINER;
	private final double PRICE_VIP;
	private final double PRICE_REGULAR;

	private Seat[][] seats;
	private String screenName;

	// Constructors
	public Screen(){
		this.PRICE_REGULAR = 500;
		this.PRICE_PREMIUM = 750;
		this.PRICE_VIP = 1000;
		this.PRICE_RECLINER = 1200;
		this.DEFAULT_NUM_ROWS = 5;
		this.screenName = "No Name";

		seats = new Seat[DEFAULT_NUM_ROWS][];

		for(int i=0; i<seats.length; i++){
			seats[i] = new Seat[10+i];
		}
	}

	public Screen(String screenName, int noOfRows){
		this.PRICE_REGULAR = 500;
		this.PRICE_PREMIUM = 750;
		this.PRICE_VIP = 1000;
		this.PRICE_RECLINER = 1200;
		this.DEFAULT_NUM_ROWS = noOfRows;
		this.screenName = screenName;
		seats = new Seat[DEFAULT_NUM_ROWS][];
	}
	
}