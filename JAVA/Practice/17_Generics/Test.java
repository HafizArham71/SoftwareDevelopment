/*
class A {}
class B extends A {}

class X {
    void show(A a){ System.out.println("A version"); }
}
class Y extends X {
    void show(B b){ System.out.println("B version"); }
}

public class Test {
    public static void main(String[] args) {
        X obj = new Y();
        obj.show(new B());
    }
}*/

/*class A {
    void m(A a){ System.out.println("A-A"); }
}
class B extends A {
    void m(B b){ System.out.println("B-B"); }
}


public class Test {
    public static void main(String[] args) {
        A obj = new B();
	obj.m(new B());

    }
}*/

/*
@FunctionalInterface
interface Calculator{

	int add(int a, int b);

}

class Test {

	public static void main(String[] args){

		//Calculator addition = (a, b) -> a+b;

		Calculator addition = new Calculator(){

			@Override
			public int add(int a, int b){

				return a+b;

			}

		};
		

		System.out.println(addition.add(2, 9));

	}

}*/

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Person implements Comparable<Person>{

	String name;
	
	public Person(String name){

		this.name = name;

	}

	public int compareTo(Person person){

		return this.name.compareTo(person.name);

	}

	public String toString(){

		return name;
	
	}

}

public class Test{

	public static void main(String[] args){

		List<Person> l1 = Arrays.asList(new Person("Zaeem"), new Person("Arham"), new Person("Hamza"));
		
		Collections.sort(l1);

		System.out.println(l1);
	}

}

