public class Depot{



	// Attributes

	private Rack[] racks;
	public static final int DEFAULT_NUM_RACKS = 5;
	private String depotName;
	private Slot slot;



	// Constructor

	public Depot(){

		this("Depot Name");

	}

	public Depot(String depotName){

		this(depotName, DEFAULT_NUM_RACKS);

	}

	public Depot(String depotName, int noOfRacks){

		this.depotName = depotName;
		this.racks = new Rack[noOfRacks];

		for(int i=0; i<racks.length; i++){

			racks[i] = new Rack("Rack-" + (i+1), new int[]{10, 12, 14, 16, 18});

		}

	}


	
	
	// Methods

	public void addRack(String rackName, int[] rowLengths){

		Rack[] updatedRack = new Rack[racks.length+1];

		for(int i=0; i<racks.length; i++)

			updatedRack[i] = racks[i];

		updatedRack[racks.length] = new Rack(rackName, rowLengths);

		racks = updatedRack;

	}

	public void addRack(Rack rack){

		Rack[] updatedRack = new Rack[racks.length+1];

		for(int i=0; i<racks.length; i++)

			updatedRack[i] = racks[i];

		updatedRack[racks.length] = rack;

		racks = updatedRack;

	}

	public boolean store(String rackName, String slotId, Parcel parcel){

		if(rackName != null && slotId != null && parcel != null){

			for(Rack r: racks){

				if(rackName.equals(r.getName()) && r.storeParcel(slotId, parcel))

					return true;

			}

		}

		return false;
	
	}

	public boolean store(String slotId, Parcel parcel){

		if(slotId != null && parcel != null){

			for(Rack r: racks){

				if(r.storeParcel(slotId, parcel))

					return true;

			}

		}

		return false;
	
	}

	public boolean removeParcel(String rackName, String slotId){

		if(rackName != null && slotId != null){

			for(Rack r: racks){

				if(rackName.equals(r.getName()) && r.removeParcel(slotId))

					return true;

			}

		}

		return false;
	
	}

	public int availableSlots(){

		int available = 0;

		for(Rack r: racks){

			available += r.availableSlots();

		}

		return available;

	}

	public int totalSlots(){

		int total = 0;

		for(Rack r: racks){

			total += r.totalSlots();

		}

		return total;

	}

	public Slot findFirstAvailableEmptySlot(){

		for(Rack r: racks){

			if(r.findFirstAvailableEmptySlot() != null)

				return r.findFirstAvailableEmptySlot();

		}

		return null;

	}

	public void printAllLayouts(){

		System.out.println("==== Depot: " + depotName + " Depot\n");

		int index = 1;

		for(Rack r: racks){

			System.out.println("\nRack LR-" + (index++) + " layout");

			r.printAllLayouts();

		}

		System.out.println("\nTotals for " + depotName + " Depot: Capacity=" + totalSlots() + ", Occupied=" + availableSlots());

	}

}