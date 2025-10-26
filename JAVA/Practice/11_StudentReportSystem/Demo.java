import java.util.Scanner;

public class Demo{

	public static void main(String[] args){
	
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter your name: ");
		String name = scanner.nextLine();
		

		// Student s1 = new Student();
		Student s2 = new Student(name, 17, new double[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100});

		//System.out.println(s1);
		System.out.println(s2);

		scanner.close();
	}
}