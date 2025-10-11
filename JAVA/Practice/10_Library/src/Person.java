public class Person{

	// Attributes
	private String author;

	public Person(String author){
		this.author = author;
	}

	public Person(Person person){
		this.author = new String(person.author);
	}

	@Override
	public String toString(){
		return author;
	}

}