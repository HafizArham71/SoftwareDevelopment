public class Book{
	
	// Attributes
	private String title;
	private String author;

	// Constructor
	public Book(){
		this.title = "48 LAWS OF POWER";
		this.author = "Hafiz Arham";
	}

	// Constructor Overloading
	public Book(String title, String author){
		this.title = title;
		this.author = author;
	}

	// String Overriding 
	@Override
	public String toString(){
		return String.format("Title: %s, Author: %s", title, author);
	}

	// Equals Overriding
	@Override
	public boolean equals(Object Obj){
		Book book = (Book)Obj;
		return this.title.equals(book.title) && this.author.equals(book.author);
	}
}