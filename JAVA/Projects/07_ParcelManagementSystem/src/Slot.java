public class Slot{

	

	// Attributes

	private String slotId;    //  R3-S07
	private Parcel parcel;
	



	// Constructor

	public Slot(){

		this("R3-S07");

	}

	public Slot(String slotId){

		this(slotId, null);

	}

	public Slot(String slotId, Parcel parcel){

		this.slotId = slotId;
		this.parcel = parcel;

	}



	// Methods

	public String getSlotId(){

		return slotId;

	}

	public Parcel getParcel(){

		return parcel;

	}

	public ParcelType getParcelType(){

		if(parcel != null)

			return parcel.getParcelType();

		return null;

	}

	public void setSlotId(String slotId){

		this.slotId = slotId;

	}

	public boolean store(Parcel parcel){

		if(this.parcel == null){

			this.parcel = parcel;
			
			return true;

		}

		return false;

	}

	public boolean remove(){

		if(this.parcel != null){

			this.parcel = null;
			
			return true;

		}

		return false;

	}



	@Override
	public String toString(){

		String str = String.format("%s", this.parcel==null? "[--]": (parcel.getParcelType() == ParcelType.FRAGILE? "[F]" : "[R]")); 

		return str;

	}

}