public class Seat{

	
	// Attributes

	private SeatType seatType;
	private double price;
	private String id;
	private boolean isAvailable;

	

	
	// Constructors

	public Seat(){

		this(1);

	}

	public Seat(int row){

		this(row, 2);

	}

	public Seat(int row, int col){

		this(row, col, SeatType.REGULAR);

	}

	public Seat(int row, int col, SeatType seatType){

		this(row, col, seatType, 500);

	}

	public Seat(int row, int col, SeatType seatType, double price){

		this.id = String.format("%d-%03d", row, col);
		this.seatType = seatType;
		this.price = price;
		this.isAvailable = true;

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

		String str = String.format("[%s, %s, %.2f, %b]", id, seatType, price, isAvailable);

		return str;

	}

	
}


enum SeatType{

	REGULAR, PREMIUM, VIP, RECLINER;

}
