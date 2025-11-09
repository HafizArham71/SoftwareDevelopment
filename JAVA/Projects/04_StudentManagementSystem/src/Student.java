public class Student{
	
	// Attributes
	private String studentId;
	private String name;
	private String gender;
	private Date dob;
	private Address address;

	private static int counter = 0;

	// Constructor
	public Student(){
		studentId = generateId();
		name = "No Name";
		this.gender = "Not Mentioned";
		dob = new Date(2, 11, 2007);
		address = new Address("Fake Street", "Fake City", "Fake Country");
	} 
	public Student(int id, String name, String gender, Date dob, Address address){
		studentId = generateId(id);
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
	}
	public Student(String name, String gender, Date dob, Address address){
		studentId = generateId();
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
	}
	public Student(Student std){
		this.studentId = std.studentId;
		this.name = std.name;
		this.gender = std.gender;
		this.dob = std.dob;
		this.address = std.address;
	}

	// Generate Id
	public String generateId(){
		return String.format("SP25-BCS-%03d", counter++);
	}
	public String generateId(int id){
		return String.format("SP25-BCS-%03d", id);
	}

	// toString
	@Override
	public String toString(){
		return String.format("%s	%s	%s	%s	%s", studentId, name, gender, dob, address);
	}

	// @Override
	public boolean equals(Object obj){
		Student other = (Student) obj;
		return this.studentId.equals(other.studentId) && this.name.equals(other.name);
	}
}

