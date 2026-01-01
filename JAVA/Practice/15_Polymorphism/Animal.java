public class Animal{

	// Attributes

	String name;
	String color;


	// Constructor

	public Animal(String name, String color){

		this.name = name;
		this.color = color;

	}


	// Methods

	public String getName(){

		return name;

	}

	public String getColor(){

		return color;

	}

	public void setName(String name){

		this.name = name;

	}

	public void setColor(String color){

		this.color = color;

	}




	public void eat(){

		System.out.println("Animal is eating");

	}

}