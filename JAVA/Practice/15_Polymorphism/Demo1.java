public class Demo1{

	public static void main(String[] args){

		Animal myAnimal = new Animal("Animal", "Blue");
		myAnimal.eat();

		Dog myDog = new Dog("Dog", "Black", "German");
		myDog.eat();

		Cat myCat = new Cat("Cat", "White", "Russsian");
		myCat.eat();

		Animal myDog1 = new Dog("Dog", "Black", "German");
		myDog1.eat();

		Animal myCat1 = new Cat("Cat", "White", "Russian");
		myCat1.eat();

	}

}