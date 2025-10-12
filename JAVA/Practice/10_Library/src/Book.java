public class Book{

	// Attributes
	private int bookId;
	private String title;
	private Person author;
	private Date publicationDate;
	private String genre;

	private static int count = 101;

	// My Constructors
	public Book(){
		this.bookId = generateId();
		this.title = "No Title";
		this.author = new Person("No Name");
		this.publicationDate = new Date(1, "Jan", 2025);
		this.genre = "No genre";
		
	}

	public Book(int bookId, String title, String author, int date, String month, int year, String genre){
		this.bookId = bookId;
		this.title = title;
		this.author = new Person(author);
		this.publicationDate = new Date(date, month, year);
		this.genre = genre;	
	}


	public Book(String title, String author, int date, String month, int year, String genre){
		this.bookId = generateId();
		this.title = title;
		this.author = new Person(author);
		this.publicationDate = new Date(date, month, year);
		this.genre = genre;	
	}


	public Book(Book book){
		this.bookId = book.bookId;
		this.title = book.title;
		this.author = new Person(book.author);
		this.publicationDate = new Date(book.publicationDate);
		this.genre = book.genre;
	}

	// Methods
	public int generateId(){
		return count++;
	}
	
	@Override
	public String toString(){
		String id = "LB25-BK-" + this.bookId;
		return "[" + id + ": " + title + ": " + author + ": " + publicationDate + ": " + genre + "]";
	}

}