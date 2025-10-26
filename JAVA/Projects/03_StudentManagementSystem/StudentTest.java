public class StudentTest{

	public static void main(String args[]){
		Student s1 = new Student();
		Student s2 = new Student(17, "Arham", "Male", new Date(30, 8, 2005), new Address("House 6 Street 1 Pakistan Mint", "Lahore", "Pakistan"));
		Student s3 = new Student("Rania", "Female", new Date(12, 2, 2015), new Address("House 3 Street 15 Narowale", "Lahore", "Pakistan"));
		Student s4 = new Student(s3);

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s3.equals(s4));
	}
}