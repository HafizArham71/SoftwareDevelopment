public class Demo{


	public static void main(String[] args){

		/*Parcel p1 = new Parcel("PKX-2025-00012345", ParcelType.REGULAR);
	
		//p1.setParcelStatus(ParcelStatus.OUT_FOR_DELIVERY);

		Parcel p2 = new Parcel("PKX-2025-00012346", ParcelType.FRAGILE);

		//System.out.println(p1);

		//System.out.println(p2);


		Rack r1 = new Rack("Arham's Rack", new int[]{10, 11, 12, 13, 14});

		System.out.println(r1.storeParcel("R1-S01", p1));
		System.out.println(r1.storeParcel("R1-S02", p2));


		r1.printAllLayouts();

		Parcel[] parcels = r1.getParcelByType(ParcelType.REGULAR);

		System.out.println();

		for(Parcel p: parcels)

			System.out.println(p + " ");

		*/

		Depot lahore = new Depot("Lahore Depot", 4);
		Rack rack1 = new Rack("LR-1", new int[]{3, 4, 3});
		lahore.addRack(rack1); 
		System.out.println("Initial layout:");
		lahore.printAllLayouts();

	}

}