public class Student{

	

	// Attributes

	private String name;
	private int rollNo;
	private double[] marks;
	private double average;

	public final int totalMarks = 100;



	// Constructors

	public Student(){
		this("John Smith");
	}

	public Student(String name){
		this(name, 17);
	}

	public Student(String name, int rollNo){
		this(name, rollNo, new double[]{50, 86, 89, 78});
	}

	public Student(String name, int rollNo, double[] marks){
		this.name = name;
		this.rollNo = rollNo;
		this.marks = marks;

		this.average = calculateAverage();
	}


	
	// Methods

	public String getName(){
		return name;
	}

	public int getRollNo(){
		return rollNo;
	}

	public double[] getMarks(){
		return marks;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setRollNo(int rollNo){
		this.rollNo = rollNo;
	}

	public void setMarks(double[] marks){
		this.marks = marks;
	}

	public double calculateAverage(){
		double sum = 0, average;

		for(double m: marks)
			sum += m;
		average = sum/marks.length;

		return average;
	}	

	public char calGrade(){
		double sum = 0;
		double percentage;

		for(double m: marks)
			sum += m;

		percentage = (sum/(marks.length*totalMarks))*100;

		if(percentage>=90) return 'A';
		else if(percentage>=80) return 'B';
		else if(percentage>=70) return 'C';
		else if(percentage>=60) return 'D';
		else if(percentage>=50) return 'E';
		else return 'F';

	}

	@Override
	public String toString(){
		return String.format("[Student Name: %s, Roll No: %03d, Obtained Marks: %.2f, Total Marks: %02d,  Average Marks: %.2f, Grade: %c]", name, rollNo, calculateAverage()*marks.length, marks.length*totalMarks, calculateAverage(), calGrade());
	} 

}