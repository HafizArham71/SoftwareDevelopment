public class Date{

	// Attributes
	private int date;
	private String month;
	private int year;

	// Constructors
	public Date(Date date){
		this.date = date.date;
		this.month = date.month;
		this.year = date.year;
	}	

	public Date(int date, String month, int year){
		this.date = date;
		this.month = month;
		this.year = year;
	}

	@Override
	public String toString(){
		String str = date + "-" + month + "-" + year;
		return str;
	}

}