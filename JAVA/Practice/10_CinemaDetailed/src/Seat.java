public class Seat {
    
	// Attributes
	private SeatType seatType;
	private double price;
	private String id;
	private boolean isAvailable;

	// Constructor
	public Seat(){
		this.seatType = SeatType.REGULAR;
		this.price = 0.0;
		this.id = "0-000";
		this.isAvailable = true;
	}

	public Seat(int row, int column, SeatType seatType, double price){
		this.seatType = seatType;
		this.price = price;
		this.id = String.format("%d-%03d", row, column);
		this.isAvailable = true;
	}

	// Methods
	public boolean bookSeat(){
		if(!isAvailable) return false;
		isAvailable = true;
		return true;
	}

	public String getId(){
		return id;
	}

	public SeatType getSeatType(){
		return seatType;
	}

	public boolean isAvailable(){
		return isAvailable;
	}

	public double getPrice(){
		return price;
	}

	public boolean cancelBooking(){
		if(!isAvailable){
			isAvailable = true;
			return true;
		}
		return false;
	}

	public void setSeatType(SeatType seatType){
		this.seatType = seatType;
	}

	public void setPrice(double price){
		this.price = price;
	}
	
	@Override 
	public String toString(){
		String str = String.format("%s %s %.2f %b", id, seatType, price, isAvailable);
		return str;
	}			
}
