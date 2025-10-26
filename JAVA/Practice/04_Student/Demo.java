public class Demo{
	public static void main(String args[]){
		Student s1 = new Student();
		Student s2 = new Student("Ahmad");
		Student s3 = new Student("Ali", 17);
		Student s4 = new Student("Irfan", 20, 'B');		
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s1.getName());
		s1.setName("Abdullah");
		s1.displayInfo();
	}
}