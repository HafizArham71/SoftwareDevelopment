import java.util.Scanner;

public class Demo{

	public static void main(String[] args){

		// Attributes

		int num1;
		int num2;



		try{

			Scanner scanner = new Scanner(System.in);

	
			System.out.print("Enter first number: ");
			num1 = scanner.nextInt();

			System.out.print("Enter second number: ");
			num2 = scanner.nextInt();

			double division = num1/num2;


			System.out.println(division);

		}catch(ArithmeticException e){

			System.out.println(e.getMessage());

		}finally{

			System.out.println("Execution finished successfully");
	
		}
		

	}

}