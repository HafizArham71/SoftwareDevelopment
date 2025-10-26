public class Seat{

	
	// Attributes

	private SeatType seatType;
	private double price;
	private String id;
	private boolean isAvailable;


	// Constructors

	public Seat(int row, int col, SeatType seatType, double price){
	
		this.seatType = seatType;
		this.id = String.format("%d-%03d", row, col);
		this.price = price;
		this.isAvailable = true;
	
	}

	public Seat(){

		this.id = "0-001";
		this.price = price;
		this.isAvailable = isAvailable;
		this.seatType = SeatType.REGULAR;
	}

	
	// Methods

	public String getId(){
		
		return id;
		
	}

	public void setId(int row, int col){

		this.id = String.format("%d-%03d", row, col);
	
	}

	public SeatType getSeatType(){

		return seatType;

	}

	public void setSeatType(SeatType seatType){

		this.seatType = seatType;	

	}

	public boolean isAvailable(){

		return isAvailable;

	}

	public void setAvailable(boolean isAvailable){

		this.isAvailable = isAvailable;

	}

	public double getPrice(){

		return price;
	
	}

	public void setPrice(double price){

		this.price = price;
	
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

		return String.format("[%s, %.2f, %s, %b]", id, price, seatType, isAvailable);

	}
}


enum SeatType{
	
	REGULAR, PREMIUM, VIP, RECLINER;

}