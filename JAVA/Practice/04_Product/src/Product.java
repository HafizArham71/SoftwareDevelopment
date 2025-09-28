public class Product{
	// Attributes
	private String productName;
	private int productId;
	private double price;
	private boolean availability;

	// Default Constructor
	public Product(){
		this.productName = "No Name";
		this.productId = 0;
		this.price = 0.0;
		this.availability = false;
	}

	// Parameterized Constructor
	public Product(String name, int id, double price, boolean availability){
		productName = name;
		productId = id;
		this.price = price;
		this.availability = availability;
	}
	
	// Getters
	public String getName(){
		return productName;
	}
	public int getId(){
		return productId;
	}
	public double getPrice(){
		return price;
	}
	public boolean getAvailability(){
		return availability;
	}

	// Setters
	public void setProductName(String name){
		productName = name;
	}
	public void setProductId(int id){
		productId = id;
	}
	public void setPrice(double price){
		this.price = price;
	}
	public void setAvailability(boolean availability){
		this.availability = availability;
	}

	// Method
	public void display(){
		System.out.println("Id: " + productId + ", Name: " + productName + ", Price: " + price + ", Availability: " + availability);
	}
}