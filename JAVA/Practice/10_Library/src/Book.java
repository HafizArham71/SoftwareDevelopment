public class Book{

	// ============================
	// Attributes
	// ============================
	private String bookId;
	private String title;
	private Person author;
	private Date publicationDate;
	private String genre;

	private static int count = 101;
	public final String prefix = "LB25-BK-";

	// My Constructors
	public Book(){
		this.bookId = generateId();
		this.title = "No Title";
		this.author = new Person("No Name", "N/A", "No Address");
		this.publicationDate = new Date(1, "Jan", 2025);
		this.genre = "No genre";
		
	}

	public Book(String bookId, String title, Person author, Date publicationDate, String genre){
		this.bookId = bookId;
		this.title = title;
		this.author = new Person(author);
		this.publicationDate = new Date(publicationDate);
		this.genre = genre;	
	}


	public Book(String title, Person author, Date publicationDate, String genre){
		this.bookId = generateId();
		this.title = title;
		this.author = new Person(author);
		this.publicationDate = new Date(publicationDate);
		this.genre = genre;	
	}


	public Book(Book other){
		this.bookId = other.bookId;
		this.title = new String(other.title);
		this.author = new Person(other.author);
		this.publicationDate = new Date(other.publicationDate);
		this.genre = new String(other.genre);
	}

	// Getters
	public String getBookId(){
		return bookId;
	}
	public String getTitle(){
		return title;
	}
	public Person getAuthor(){
		return author;
	}
	public Date getPublicationDate(){
		return publicationDate;
	}
	public String getGenre(){
		return genre;
	}

	// Setters
	public void setBookId(String bookId){
		this.bookId = bookId;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public void setAuthor(Person author){
		this.author = author;
	}
	public void setPublicationDate(Date publicationDate){
		this.publicationDate = publicationDate;
	}
	public void setGenre(String genre){
		this.genre = genre;
	}

	// Methods
	public String generateId(){
		return prefix + count++;
	}

	@Override
	public boolean equals(Object obj){

		if(this == obj)
			return true;
		if(obj == null || obj.getClass() != this.getClass())
			return false;
	
		Book other = (Book) obj;
		return title.equals(other.title) && author.equals(other.author) && publicationDate.equals(other.publicationDate);
	}
		
	@Override
	public String toString(){
		return String.format("[ %s: %s: %s: %s: %s]", bookId, title, author, publicationDate, genre);
	}

}