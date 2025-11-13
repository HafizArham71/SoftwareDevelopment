import java.lang.*;

public class Demo{


	public static void main(String[] args){

		Parcel p1 = new Parcel(12, ParcelType.REGULAR);
		Parcel p2 = new FragileParcel(12, ParcelType.REGULAR, true);

		System.out.println(p1);
		System.out.println(p2);

		String name = null;

		System.out.println(name);
		System.out.println(name.length());

	}

}