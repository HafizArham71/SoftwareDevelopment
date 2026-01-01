public class Cat extends Animal{

	Boolean canDrinkMilk;

	public Cat(String name, int legs, Boolean canDrinkMilk){

		super(name, legs);
		this.canDrinkMilk = canDrinkMilk;
	}

	public void shout(){

		System.out.println("Meow Meow");

	}

}