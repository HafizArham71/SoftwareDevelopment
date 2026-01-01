public abstract class Animal {

	String name;
	int age;

	Byte myByte = Byte.MAX_VALUE;
	Short myShort;
	int myInt;
	long myLong;
	float myFloat;
	double myDouble;
	char myChar;
	Boolean myBoolean;
	
	

	public Animal(String name, int age) {

		this.name = name;
		this.age = age;

	}

	public void makeNoise() {

		System.out.println("Meow");

	}

}