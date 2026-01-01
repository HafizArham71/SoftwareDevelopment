public class Demo {

	static b;

	public static void main(String[] args) {

		Cat cat = new Cat("Cutoo", 23);

		//Animal myAnimal = new Animal("Cutoo1", 45);

		Animal myAnimal = new Animal("Cutoo1", 45){

			public void makeNoise() {

				System.out.println("Woof Woof");
				
			}

		};

		System.out.println(cat.name);
		
		System.out.println("Byte:	" + cat.myByte);
		System.out.println("Short: 	" + cat.myShort);
		System.out.println("Int:	" + cat.myInt);
		System.out.println("Long: 	" + cat.myLong);
		System.out.println("Float: 	" + cat.myFloat);
		System.out.println("Double: 	" + cat.myDouble);
		System.out.println("Char:	" + cat.myChar);
		System.out.println("Boolean:	" + cat.myBoolean);

		cat.makeNoise();
		myAnimal.makeNoise();

		System.out.println(A.a);

		System.out.println(new Demo().b);

	}

}