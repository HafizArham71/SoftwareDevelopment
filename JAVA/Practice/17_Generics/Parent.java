public class Parent{

	protected int i = 10;

	public Parent(){
	
		System.out.println("!");
		display();

	}

	public void display(){

		System.out.println("Parent: value = " + i);

	}

}