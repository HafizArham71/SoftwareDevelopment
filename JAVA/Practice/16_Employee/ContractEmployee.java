import java.time.LocalDate;

public class ContractEmployee extends Employee{

	// Attributes

	double fixedSalary;
	String name;
	LocalDate date;
	String ssn;
	



	// Constructor

	public ContractEmployee(String name, String ssn, LocalDate date, double fixedSalary){
		
		super(name, ssn, date);

		if(fixedSalary<=0)

			throw new IllegalArgumentException("Salary can't be zero or negative.");

		this.fixedSalary = fixedSalary;

	}



	// Methods

	@Override
	public double calSalary(){

		double salary = fixedSalary - (fixedSalary*0.2);
		return salary;

	}

	double increaseFixedSalary(){

		return fixedSalary + (fixedSalary*0.1);

	}

	public double calPayableAmount(){

		return calSalary();

	}

}