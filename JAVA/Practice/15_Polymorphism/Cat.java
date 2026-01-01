public class Cat extends Animal{

	// Attributes

	String breed;

		
	// Constructor

	public Cat(String name, String color, String breed){

		super(name, color);
		this.breed = breed;

	}

		
	// Methods

	public String getBreed(){

		return breed;

	}

	public void setBreed(String breed){

		this.breed = breed;

	}

	@Override
	public void eat(){

		System.out.println("Cat is eating");

	}

}