public class FragileParcel extends Parcel{



	// Attributes
	
	protected boolean isInsured;



	// Constructors

	public FragileParcel(int id, ParcelType type, boolean isInsured){

		super(id, type);

		this.isInsured = isInsured;

	}

		

	// Methods
	
	@Override
	public String toString(){

		String str = super.toString() + " | Insured?: " + isInsured;

		return str;

	}

}