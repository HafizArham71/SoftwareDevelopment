public class Student{
	
	// Attributes
	private String name;
	private int age;
	private char grade;

	// Getters
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	public char getGrade(){
		return grade;
	}

	// Setters
	public void setName(String name){
		this.name = name;
	}
	public void setAge(int age){
		this.age = age;
	}
	public void setGrade(char grade){
		this.grade = grade;
	}

	// 01_Constructor
	public Student(){
		this("No Name");
	}

	// 02_Constructor
	public Student(String name){
		this(name, 0);
	}

	// 03_Constructor
	public Student(String name, int age){
		this(name, age, '!');
	}

	// 04_Constructor
	public Student(String name, int age, char grade){
		this.name = name;
		this.age = age;
		this.grade = grade;
	}

	// Display Information
	public void displayInfo(){
		System.out.println("Name: " + name + ", Age: " + age + ", Grade: " + grade);
	}

	// toString
	@Override 
	public String toString(){
		return String.format("Name: %s, Age: %d, Grade: %c", name, age, grade);
	}
}