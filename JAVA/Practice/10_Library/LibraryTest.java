public class LibraryTest{

	public static void main(String[] args){
		Book book = new Book();
		Book book1 = new Book();
		Book book2 = new Book("Think and Grow Rich", "Ahmad Hassan", 30, "Jan", 2022, "A way to get rich in life");
		Book book3 = new Book(110, "38 Laws Of Power", "Hafiz Arham", 12, "March", 2024, "A way to become hero in life");
		Book book4 = new Book(book3);

		System.out.println(book);
		System.out.println(book1);
		System.out.println(book2);
		System.out.println(book3);
		System.out.println(book4);
	}
}