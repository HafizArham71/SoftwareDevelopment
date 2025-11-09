public class Student{

	// Attribute
	private int rollNo;
	private String name;
	private double marks[];
	private int noOfSubjects;

	private double totalMarks = 0;
	private double average;

	// Constructor
	public Student(){
		this(123);
	}

	public Student(int rollNo){
		this(rollNo, "No Name");
	}

	public Student(int rollNo, String name){
		this(rollNo, name, 5);
	}

	public Student(int rollNo, String name, int noOfSubjects){
		this.rollNo = rollNo;
		this.name = name;
		this.noOfSubjects = noOfSubjects;
		this.marks = new double[noOfSubjects];

		for(int i=0; i<marks.length; i++){
			marks[i] = 70+(i+3);
			totalMarks+=marks[i];
		}
	}

	// Methods
	public double calculateAverage(){

		average = totalMarks/noOfSubjects;

		return average;
	}

	public char calculateGrade(){
		if(average>=90)
			return 'A';
		else if(average>=80)
			return 'B';
		else if(average>=70)
			return 'C';
		else if(average>=60)
			return 'D';
		else if(average>=50)
			return 'E';
		else 
			return 'F';
	}

	@Override
	public String toString(){
		String str = String.format("\nStudent Name: %s\nRoll No: %02d\nNo Of Subjects: %d\nTotal Marks: %.2f\nAverage Marks: %.2f\nGrade: %c\n", name, rollNo, noOfSubjects, this.totalMarks, calculateAverage(), calculateGrade());
		return str;
	}
}