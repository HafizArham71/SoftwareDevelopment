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
		this.gender = new String(person.gender);
		this.address = new String(person.address);
	}

	public String getName(){
		return name;
	}
	public String getGender(){
		return gender;
	}
	public String getAddress(){
		return address;
	}

	public void setName(String name){
		this.name = name;
	}
	public void setGender(String gender){
		this.gender = gender;
	}
	public void setAddress(String address){
		this.address = address;
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