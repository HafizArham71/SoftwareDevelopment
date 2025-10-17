public class Seat{

	// Attributes
	
	private double price;
	private String id;
	private SeatType seatType;
	private boolean isAvailable;

	
	
	// Constructors

	public Seat(int row, int col, SeatType seatType, double price){
		this.price = price;
		this.id = String.format("%d-%03d", row, col);
		this.seatType = seatType;
		this.isAvailable = true;
	}

	public Seat(){
		this.price = 300;
		this.id = "0-001";
		this.seatType = SeatType.REGULAR; // Method 1
		this.isAvailable = true;
		//this.seatType = SeatType.values()[0];  // Method 2
	}



	// Methods
	
	public String getId(){
		return id;
	}

	public double getPrice(){
		return price;
	}

	public SeatType getSeatType(){
		return seatType;
	}

	public boolean isAvailable(){
		return isAvailable;
	}


	public void setId(int row, int col){
		this.id = String.format("%d-%03d", row, col);
	}

	public void setPrice(double price){
		this.price = price;
	}

	public void setSeatType(SeatType seatType){
		this.seatType = seatType;
	}

	public void setAvailable(boolean isAvailable){
		this.isAvailable = isAvailable;
	}

	
	public boolean bookSeat(){
		if(!isAvailable)
			return false;
		isAvailable = false;
		return true;
	}

	public boolean cancelBooking(){
		if(isAvailable)
			return false;
		isAvailable = true;
		return true;
	}


	@Override 
	public String toString(){
		String output = String.format("[%s : %.2f : %s : %b]", id, price, seatType, isAvailable);
		return output;
	}
}