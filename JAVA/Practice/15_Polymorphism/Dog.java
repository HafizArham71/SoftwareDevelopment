public class Dog extends Animal{

	// Attributes

	String breed;

		
	// Constructor

	public Dog(String name, String color, String breed){

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

		System.out.println("Dog is eating");

	}

}