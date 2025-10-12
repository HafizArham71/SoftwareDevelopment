public class Person{

	// Attributes
	private String name;
	private String gender;
	private String address;

	// Constructors
	public Person(String name, String gender, String address){
		this.name = name;
		this.gender = gender;
		this.address = address;
	}

	public Person(Person person){
		this.name = new String(person.name);
		this.gender = new String("Not Mentioned");
		this.address = new String("NO Address");
	}

	@Override
	public String toString(){
		return "[" + name + ", " + gender + ", " + address + "]";
	}

	@Override
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(this == null || getClass() != obj.getClass())
			return false;
		
		Person other = (Person) obj;
		return this.name.equals(other.name) && gender.equals(other.gender);
	}

}