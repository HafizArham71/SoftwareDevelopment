public class Parcel{



	// Attributes

	protected String identity;
	protected ParcelType parcelType;
	protected ParcelStatus parcelStatus;



	
	// Constructors

	public Parcel(){

		this("PKX-2025-000123");

	}

	public Parcel(String identity){

		this(identity, ParcelType.REGULAR);

	}

	public Parcel(String identity, ParcelType parcelType){

		this.identity = identity;
		this.parcelType = parcelType;
		this.parcelStatus = ParcelStatus.IN_STORAGE;

	}




	
	// Methods

	public String getIdentity(){

		return identity;

	}

	public ParcelType getParcelType(){

		return parcelType;

	}

	public ParcelStatus getParcelStatus(){

		return parcelStatus;

	}

	public void setIdentity(String identity){

		this.identity = identity;

	}

	public void setParcelType(ParcelType parcelType){

		this.parcelType = parcelType;

	}

	public void setParcelStatus(ParcelStatus parcelStatus){

		this.parcelStatus = parcelStatus;

	}



	@Override
	public String toString(){

		String str = String.format("%s | %s | %s", identity, parcelType, parcelStatus);

		return str;

	}

}