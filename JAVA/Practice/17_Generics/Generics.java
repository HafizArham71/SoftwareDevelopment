import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generics{

	public static void main(String[] args){


		PrintIntegers myInteger = new PrintIntegers(5);
		PrintDoubles myDouble = new PrintDoubles(3.65);
		PrintStrings myString = new PrintStrings("Arham");
	
		Printer<Integer> myPrinter = new Printer<>(4);

		myInteger.print();
		myDouble.print();
		myString.print();
		myPrinter.print();

		//Object obj = 2.4;

		//System.out.println(obj.getClass().getSimpleName());

		Printer<Cat> myPrinter1 = new Printer<>(new Cat("Cuto", 4, true)); 

		
		// ArrayList Without Generics

		System.out.println();

		ArrayList arrayList = new ArrayList();	// Elements are considered as Objects in ArrayList

		arrayList.add("Arham");
		arrayList.add(7);
		arrayList.add(9);

		//String name1 = (String) arrayList.get(0);
		//int value = (Integer) arrayList.get(1);
		//int value1 = (Integer) arrayList.get(2);

		System.out.println("ARRAY # 01");
		System.out.println("Elem 01: " + arrayList.get(0));
		System.out.println("Elem 02: " + arrayList.get(1));
		System.out.println("Elem 03: " + arrayList.get(2));
		System.out.println("Does the array includes 'Arham'?: " + arrayList.contains("Arham"));
		System.out.println("Size of array: " + arrayList.size());

		arrayList.set(0, "Hamza");
		arrayList.set(1, 8);
		arrayList.remove(2);		

		System.out.println("\nAfter Modifying Array01 Elements");
		System.out.println("Elem 01: " + arrayList.get(0));
		System.out.println("Elem 02: " + arrayList.get(1));
		System.out.println("Does the array includes 'Arham'?: " + arrayList.contains("Arham"));
		System.out.println("Size of array: " + arrayList.size());

		System.out.println();


		// ArrayList With Generics

		ArrayList<String> arrayList1 = new ArrayList<>();

		arrayList1.add("Ahmad");
		arrayList1.add("Ali");	
		arrayList1.add("Adnan");	

		//String name2 = arrayList1.get(0);	
		//String name3 = arrayList1.get(1);	

		System.out.println("ARRAY # 02");
		System.out.println("Elem 01: " + arrayList1.get(0));
		System.out.println("Elem 02: " + arrayList1.get(1));
		System.out.println("Elem 03: " + arrayList1.get(2));
		System.out.println("Does the array includes 'Ali'?: " + arrayList1.contains("Ali"));
		System.out.println("Size of array: " + arrayList1.size());

		arrayList1.set(0, "Abdullah");
		arrayList1.set(1, "Adan");
		arrayList1.remove(2);

		System.out.println("\nAfter Modifing Elements of Array02:");
		System.out.println("Elem 01: " + arrayList1.get(0));
		System.out.println("Elem 02: " + arrayList1.get(1));
		System.out.println("Does the array includes 'Ali'?: " + arrayList1.contains("Ali"));
		System.out.println("Size of array: " + arrayList1.size());



		ArrayList<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(10);
		list.add(15);
		list.remove(1);
		list.add(1, 20);
		list.add(15);

		System.out.println(list);

		

		ArrayList<String> list1 = new ArrayList<>();
		list1.add("A");
		list1.add("B");
		list1.add("C");

		list1.remove("B");
		list1.remove(1);

		System.out.println(list1);


		ArrayList<Integer> list2 = new ArrayList<>();

		for(int i = 1; i <= 5; i++) {
    			list2.add(i * 2);
		}

		list2.removeIf(n -> n % 4 == 0);
		System.out.println(list2);


		ArrayList<String> list3 = new ArrayList<>();
		list3.add("X");
		list3.add("Y");
		list3.add("Z");

		for(int i = 0; i < list3.size(); i++) {
    			list3.remove(i);
		}

		System.out.println(list3);

		ArrayList<String> list4 = new ArrayList<>();

		System.out.println(list4);

		/*
		ArrayList<Integer> list5 = new ArrayList<>();
		list5.add(1);
		list5.add(2);
		list5.add(3);
		list5.add(4);

		for(Integer i : list5) {
    			if(i == 2) list5.remove(i);
		}

		System.out.println(list5);

		*/


		ArrayList<Integer> list6 = new ArrayList<>();
		list6.add(100);
		list6.add(200);
		list6.add(300);

		ArrayList<Integer> list7 = list6;

		list7.add(400);
		list6.remove(0);

		System.out.println(list6);
		System.out.println(list7);

		ArrayList<Integer> list8 = new ArrayList<>(Arrays.asList(1,2,3,4,5));

		System.out.println("List08: " + list8);

		list8.subList(1, 4).clear();

		System.out.println("List08: " + list8);

		ArrayList<Integer> list9 = new ArrayList<>();

		for(int i = 0; i < 4; i++) {
    			list9.add(i);
		}

		list9.add(2, 99);

		System.out.println(list9);	// [0, 1, 99, 2, 3]

		ArrayList<Integer> list10 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

		int x = list10.indexOf(10);
		int y = list10.lastIndexOf(3);

		System.out.println(x + " " + y);

		ArrayList<String> list11 = new ArrayList<>();
		list11.add("A");
		list11.add("B");
		list11.add("C");
		list11.add("D");	// ["A", "B", "C", "D"]

		list11.remove("C");	// ["A", "B", "D"]
		list11.add(2, "C");	// ["A", "B", "C", "D"]
		list11.add(0, list11.get(2));	// ["C", "A", "B", "C", "D"]

		System.out.println(list11);	// ["C", "A", "B", "C", "D"]

		List<?> list12 = List.of(10, 20, 30);
		System.out.println(list12.get(0).getClass().getSimpleName());


		List<String> names = new ArrayList<>();
		names.add("Arham");
		List list13 = names;
		list13.add(20);
		System.out.println(names);

	}

}