public class Slot{



	// Attributes

	private String slotId;
	private Parcel parcel;



	// Constructors

	public Slot(){

		this("R3-S07");

	}

	public Slot(String slotId){

		this.slotId = slotId;
		this.parcel = new Parcel();

	}

		
	
	// Methods

	public String getSlotId(){

		return slotId;

	}

	public Parcel getParcel(){

		return parcel;

	}

	public void setSlotId(String slotId){

		this.slotId = slotId;

	}

	public boolean isEmpty(){

		
	
	}
	

}