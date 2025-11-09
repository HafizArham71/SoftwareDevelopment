public class FragileParcel extends Parcel{

	

	// Attributes

	private boolean isInsured;



	
	// Constructors

	public FragileParcel(String identity, ParcelType parcelType, boolean isInsured){

		super(identity, parcelType);

		this.isInsured = isInsured;

	}

}