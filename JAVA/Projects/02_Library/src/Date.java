import java.time.*;

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
		String str = String.format("%02d-%s-%d", date, month, year);
		return str; 
	}

	@Override
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(obj == null || obj.getClass() != this.getClass())
			return false;

		Date other = (Date) obj;
		
		return other.date == this.date && other.month.equals(this.month) && other.year == this.year;
	}

}