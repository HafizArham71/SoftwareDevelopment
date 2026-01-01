import java.time.LocalDate;

public class Demo{

	public static void main(String[] args){
	
		Employee[] employee = new Employee[100];

		// Initializing Array

		int index = 0;

		for(int i=0; i<employee.length; i++){

			if(i<employee.length/2){

				employee[i] = new RegularEmployee("Arham", "Yea", LocalDate.of(2025, 11, 15), i+100000);

			}

			else if(i<employee.length){

				employee[i] = new ContractEmployee("Arham", "Yea", LocalDate.of(2005, 3, 14), i+100000);

			}

		}

		// Displaying Results

		for(Employee e: employee){

			System.out.println(e.calPayableAmount());

		}


	}

}