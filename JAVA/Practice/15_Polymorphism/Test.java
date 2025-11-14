public class Test{


	// Primitive types instance variables

	byte myByte;
	short myShort;
	int num;
	long myLong;
	float myFloat;
	double myDouble;
	char myChar;
	boolean isAvailable;

	// Reference type

	String myName;


	void show(){
		
		// Primitive types local variables

		byte myByte;
		short myShort;
		int num;
		long myLong;
		float myFloat;
		double myDouble;
		char myChar;
		boolean isAvailable;

		// Reference type

		String myName;

		
		/*System.out.println("Byte:	" + myByte);
		System.out.println("Short: 	" + myShort);
		System.out.println("Integer: 	" + num);
		System.out.println("Long: 	" + myLong);
		System.out.println("Float: 	" + myFloat);
		System.out.println("Double: 	" + myDouble);
		System.out.println("Char: 	" + myChar);
		System.out.println("Boolean: 	" + isAvailable);
		System.out.println("String: 	" + myName);*/

	}


	public static void main(String[] args){

		Test t1 = new Test();

		System.out.println("Byte:	" + t1.myByte);
		System.out.println("Short: 	" + t1.myShort);
		System.out.println("Integer: 	" + t1.num);
		System.out.println("Long: 	" + t1.myLong);
		System.out.println("Float: 	" + t1.myFloat);
		System.out.println("Double: 	" + t1.myDouble);
		System.out.println("Char: 	" + t1.myChar);
		System.out.println("Boolean: 	" + t1.isAvailable);
		System.out.println("String: 	" + t1.myName);

		t1.show();

		

	}

}