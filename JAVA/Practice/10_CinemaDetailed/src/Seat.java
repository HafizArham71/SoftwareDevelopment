public class Seat{

	// Attributes
	String seatType;
	double price;
	String id;
	boolean isAvailable;

	// Constructor
	public Seat(){
		this.id = "0-000";
		this.price = 0.0;
		this.seatType = SeatType.REGULAR;
		this.isAvailable = true;
	}

	public Seat(int row, int col, SeatType type, double price){
		this.id = String.format("%d-%03d", row, col);
		this.seatType = type;
		this.price = price;
		this.isAvailable = true;
	}
	
}