public class Rack{



	// Attributes

	private Slot[][] slots;
	private String rackName;
	private String rackId;

	private Parcel[] parcel;


	
	// Constructor

	public Rack(){
	
		this("Rack Name");

	}

	public Rack(String rackName){
	
		this("Rack Name", defaultRowLength());

	}

	public Rack(String rackName, int[] rowLengths){
	
		this.rackName = rackName;
		this.slots = new Slot[rowLengths.length][];


		for(int i=0; i<slots.length; i++)

			slots[i] = new Slot[rowLengths[i]];



		for(int j=0; j<slots.length; j++){

			for(int k=0; k<slots[j].length; k++){

				slots[j][k] = new Slot(String.format("R%d-S%02d", (j+1), (k+1)));

			}

		}


	}



	// Methods


	public String getName(){

		return rackName;

	}

	public static int[] defaultRowLength(){

		int arr[] = new int[10]; 

		for(int i=0; i<arr.length; i++){

			arr[i] = 10 + i;

		}

		return arr;

	}

	
	public Slot getSlotById(String id){

		if(id!=null){

			for(Slot[] row: slots){

				for(Slot col: row){

					if(col.getSlotId().equals(id))

						return col;

				}
	
			}

		}

		return null;

	}

	public void printAllLayouts(){

		int capacity = 0, occupied = 0;

		for(int i=0; i<slots.length; i++){

			System.out.print("R" + (i+1) + ": ");

			for(int j=0; j<slots[i].length; j++){

				System.out.print(slots[i][j] + " ");

			}

			System.out.println();

		}

		System.out.println("Capacity: " + totalSlots() + ", Occupied: " + availableSlots());

	}

	public int totalSlots(){

		int totalSlots = 0;

		for(Slot[] row: slots){

			for(Slot col: row){

				totalSlots++;	

			}

		}

		return totalSlots;

	}

	public int availableSlots(){

		int availableSlots = 0;

		for(Slot[] row: slots){

			for(Slot col: row){

				if(col.getParcel() != null)

					availableSlots++;	

			}

		}

		return availableSlots;

	}

	public boolean storeParcel(String slotId, Parcel parcel){

		if(slotId != null && parcel != null){

			for(Slot[] row: slots){

				for(Slot col: row){

					if(col.getSlotId().equals(slotId) && col.store(parcel)){

						return true;

					}
	

				}

			}

		}

		return false;

	}

	public boolean removeParcel(String slotId){

		if(slotId != null){

			for(Slot[] row: slots){

				for(Slot col: row){

					if(col.getSlotId().equals(slotId) && col.remove()){

						return true;

					}
	

				}

			}

		}

		return false;

	}

	public Parcel[] getParcelByType(ParcelType parcelType){

		int count = 0;

		for(Slot[] row: slots){

			for(Slot col: row){

				if(col.getParcelType() != null && col.getParcelType().equals(parcelType))

					count++;

			}

		}

		parcel = new Parcel[count];

		int index = 0;

		for(Slot[] row: slots){

			for(Slot col: row){

				if(col.getParcelType() != null && col.getParcelType().equals(parcelType))

					parcel[index++] = col.getParcel();

			}

		}

		return parcel;

	}


	public Slot findFirstAvailableEmptySlot(){

		for(Slot[] row: slots){

			for(Slot col: row){

				if(col.getParcel() != null)

					return col;
	
			}

		}

		return null;

	}

	
}