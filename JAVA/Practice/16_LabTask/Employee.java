import java.time.LocalDate;

public abstract class Employee implements Payable{

	// Attributes
	
	String employeeName;
	String ssn;
	LocalDate date;


	// Constructors

	public Employee(String name, String ssn, LocalDate date){


		// Exception Handling

		if(name.isEmpty() || name == null)

			throw new IllegalArgumentException("Name can't be empty or null.");

		else if(ssn.isEmpty() || ssn == null)

			throw new IllegalArgumentException("SSN can't be empty or null.");

		else if(date == null || date.isAfter(LocalDate.now()))

			throw new IllegalArgumentException("Date can't be of future or null.");


		this.employeeName = name;
		this.ssn = ssn;
		this.date = date;
		
			

	}


	// Methods

	public abstract double calSalary();

	public abstract double calPayableAmount();



}