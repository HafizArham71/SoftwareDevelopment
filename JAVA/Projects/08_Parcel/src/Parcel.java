public class Parcel{



	// Attributes

	protected String trackingCode;
	protected ParcelType type;
	protected ParcelStatus status;



	// Constructors

	public Parcel(int id, ParcelType type){

		this.type = type;
		this.trackingCode = String.format("PKX-2025-%06d", id);
		this.status = ParcelStatus.IN_STORAGE;

	}



	// Methods

	public boolean setStatus(ParcelStatus status){

		if(this.status != status){

			this.status = status;

			return true;

		}

		return false;

	}

	public ParcelStatus getStatus(){

		
		return status;

	}



	@Override
	public String toString(){

		String str = String.format("Id: %s | ParcelType: %s | ParcelStatus: %s", trackingCode, type, status);

		return str;

	}

}