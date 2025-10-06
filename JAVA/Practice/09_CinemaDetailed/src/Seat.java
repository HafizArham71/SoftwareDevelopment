public class Seat {
    
	// Attributes
	private SeatType seatType;
	private double price;
	private String id;
	private boolean isAvailable;

	private int row;
	private int col;

	// Constructors
	public Seat(){
		this.seatType = seatType.REGULAR;
		this.price = 500.0;
		this.id = "8-001";
		this.isAvailable = true;
	}
	
	public Seat(int row, int col, SeatType seatType, double price){
		this.row = row;
		this.col = col;
		this.id = String.format("%d-%03d", row, col);
		this.seatType = seatType;
		this.price = price;
		this.isAvailable = true;
	}	

	// Getters
	public String getId(){
		return id;
	}	

	public SeatType getSeatType(){
		return seatType;
	}		

	public double getPrice(){
		return price;
	}

	// Setters
	public void setSeatType(SeatType seatType){
		this.seatType = seatType;
	}

	public void setPrice(double price){
		this.price = price;
	}

	// Methods
	public boolean bookSeat(){
		if(!isAvailable)
			return false;
		isAvailable = true;
		return true;
	}

	public boolean isAvailable(){
		if(isAvailable)
			return true;
		return false;
	}

	public boolean cancelBooking(){
		if(isAvailable)
			return false;
		isAvailable = true;
		return true;
	}

	@Override
	public String toString(){
		return String.format("%s %s %.2f %b", id, seatType, price, isAvailable);
	}
}
