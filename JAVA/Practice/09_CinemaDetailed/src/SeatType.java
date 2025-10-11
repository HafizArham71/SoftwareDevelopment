public enum SeatType{
	REGULAR(500), PREMIUM(750), VIP(1000), RECLINER(1200);

	private double price;

	SeatType(double price){
		this.price = price;
	}
		
	public double getPrice(){
		return price;
	}

	@Override
	public String toString(){
		if(price==500)
			return "REGULAR";
		else if(price == 750)
			return "PREMIUM";
		else if(price == 1000)
			return "VIP";
		else
			return "RECLINER";
	}
}