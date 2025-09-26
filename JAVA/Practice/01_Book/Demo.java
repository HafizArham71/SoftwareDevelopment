public class Demo{
	public static void main(String args[]){
		Book b1 = new Book();
		Book b2 = new Book("RICH DAD, POOR DAD", "Ahmad Ali");
		Book b3 = new Book("HOW TO WIN FRIENDS AND INFLUENCE PEOPLE", "Asadullah");
		
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b2.equals(b3));
	}
}