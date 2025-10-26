public class App{

	public static void main(String args[]){
		Product p1 = new Product();
		Product p2 = new Product("Shampoo", 12, 450.6, true);

		p1.display();
		p2.display();

		System.out.println("\nBefore Changing Product 2 Details!");
		p2.display();
		System.out.println("\nAfter Changing Product 2 Details!");
		p2.setProductName("Watch");
		p2.setPrice(700);
		p2.display();
		
	}
}