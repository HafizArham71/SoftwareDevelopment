public enum SeatType{
	REGULAR(500), PREMIUM(750), VIP(1000), RECLINER(1200);

	private double price;

	SeatType(double price){
		this.price = price;
	}
		
	public double getPrice(){
		return price;
	}
}