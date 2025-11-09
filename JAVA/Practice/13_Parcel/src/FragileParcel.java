public class FragileParcel extends Parcel{



	// Attributes

	private boolean isInsured;



	

	// Constructor

	public FragileParcel(String id, ParcelType type, boolean isInsured){

		super(id, type);

		this.isInsured = isInsured;

	}


	
	// Methods

	public boolean isInsured(){

		return isInsured;

	}

	public void setIsInsured(boolean isInsured){

		this.isInsured = isInsured;

	}
	

}