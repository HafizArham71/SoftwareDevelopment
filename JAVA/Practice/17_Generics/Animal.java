public abstract class Animal{

	String name;
	int legs;

	public Animal(String name, int legs){

		this.name = name;
		this.legs = legs;

	}
	

	public abstract void shout();

}