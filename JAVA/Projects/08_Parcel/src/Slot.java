public class Slot{



	// Attributes
	
	private String slotId;
	private Parcel parcel;



	// Constructors

	public Slot(String slotId, Parcel parcel){

		this.slotId = String.format("R%d-S%02d", row, col);
		this.parcel = parcel;

	}

	

	// Methods

	public boolean store(){

		if(parcel.getStatus() == ParcelStatus.IN_STORAGE)

			return false;

		parcel.setStatus(ParcelStatus.IN_STORAGE);

		return true;

	}

	public boolean remove(){

		if(parcel.getStatus() == ParcelStatus.OUT_FOR_DELIVERY)

			return false;

		parcel.setStatus(ParcelStatus.IN_STORAGE);

		return true;

	}

}