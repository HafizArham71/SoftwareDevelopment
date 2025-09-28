public class Date{

	// Attributes
	private int month;
	private int date;
	private int year;

	public Date(int month, int date, int year){
		this.month = month;
		this.date = date;
		this.year = year;
	}

	@Override
	public String toString(){
		return String.format("%02d-%02d-%02d", month, date, year);
	}
}