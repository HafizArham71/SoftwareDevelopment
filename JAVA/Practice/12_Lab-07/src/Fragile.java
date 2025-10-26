public class Fragile extends Parcel{


	
	// Atributes

	private boolean isInsured;


	
	// Constructors

	public Fragile(){
	
		this("PKX-2025-000123");

	}

	public Fragile(String code){
	
		this(code, false);

	}

	public Fragile(String code, boolean insured){

		super(code);	
		this.isInsured = insured;

	}


	
	// Methods
	
	public boolean isInsured(){

		return isInsured;
		
	}

	public void setInsured(boolean isInsured){

		this.isInsured = isInsured;
		
	}

	@Override
	public String toString(){

		return super.toString() + ", isInsured: " + isInsured;

	}

	

}