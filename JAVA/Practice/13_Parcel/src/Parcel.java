public class Parcel{





	// Attributes

	protected String id;
	protected ParcelType type;
	protected ParcelStatus status;



	// Constructors

	public Parcel(String id, ParcelType type){

		this.id = id;
		this.type = type;
		this.status = ParcelStatus.OUT_FOR_DELIEVERY;

	}



	// methods

	public String getId(){

		return id;

	}

	public ParcelType getType(){

		return type;

	}

	public ParcelStatus getStatus(){

		return status;

	}

	public void setId(String id){

		this.id = id;

	}

	public void setParcelType(ParcelType type){

		this.type = type;

	}
	public void setParcelStatus(ParcelStatus status){

		this.status = status;

	}

	public boolean store(){

		if(this.status == ParcelStatus.IN_STORAGE){

			status = ParcelStatus.OUT_FOR_DELIEVERY;

			return true;

		}

		return false;

	}

	public boolean remove(){

		if(this.status == ParcelStatus.OUT_FOR_DELIEVERY){

			status = ParcelStatus.IN_STORAGE;

			return true;

		}

		return false;

	}


	@Override
	public String toString(){

		return String.format("%s | %s | %s", id, type, status);

	}

}