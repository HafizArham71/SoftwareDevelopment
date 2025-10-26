public class Parcel{

	
	// Attributes

	private TypeChosen type;
	private StatusChosen status;
	private String code;



	// Constructors

	public Parcel(){

		this("PKX-2025-000123");

	}

	public Parcel(String code){

		this(code, TypeChosen.REGULAR);

	}

	public Parcel(String code, TypeChosen type){

		this.code = code;
		this.type = type;
		this.status = StatusChosen.IN_STORAGE;

	}



	// Methods

	public TypeChosen getType(){

		return type;

	}

	public StatusChosen getStatus(){

		return status;

	}

	public String getCode(){

		return code;

	}

	public void setType(TypeChosen type){

		this.type = type;

	}

	public void setStatus(StatusChosen status){

		this.status = status;

	}

	public void setCode(String code){

		this.code = code;

	}


	@Override
	public String toString(){

		String str = String.format("[Code: %s, Type: %s, Status: %s]", code, type, status);

		return str;

	}



}