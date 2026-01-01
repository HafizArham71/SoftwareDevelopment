import java.time.LocalDate;

public class RegularEmployee extends Employee{

	// Attributes

	double basicSalary;
	



	// Constructor

	public RegularEmployee(String name, String ssn, LocalDate date, double basicSalary){

		super(name, ssn, date);

		if(basicSalary<=0)

			throw new IllegalArgumentException("Salary can't be zero or negative.");


		this.basicSalary = basicSalary;

	}



	// Methods

	@Override
	public double calSalary(){
	
		double salary = basicSalary - (basicSalary*0.2);
		return salary;

	}

	double applyAnualIncrement(){

		return basicSalary + (basicSalary*0.1);

	}

	public double calPayableAmount(){

		return calSalary();

	}

}