package Interfaces;

// Program_01
//class Course {
//
//    String cName;
//
//    Course(String name) {
//        cName = name;
//    }
//}
//
//class Student {
//
//    String sName;
//    Course c;
//
//    Student(String sName, Course c) {
//        this.sName = sName;
//        this.c = c;
//    }
//
//    Student(Student s) {
//        this.sName = s.sName;
//        this.c = new Course(s.c.cName);
//    }
//}
//
//public class Test1 {
//
//    static void main() {
//
//        Course c1 = new Course("OOP");           // cName = OOP
//        Student s1 = new Student("Ali", c1);    // sName = Ali, cName = OOP
//        Student s2 = new Student(s1);                   // sName = Ali, cName = OOP
//
//        s2.c.cName = "AI";                              // sName = Ali, cName = AI
//
//        System.out.println(s1.c.cName);                 //
//    }
//}


// Program_02
//class Product {
//    String name;
//    int id;
//
//    Product(int id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//}
//
//public class Test1 {
//    static void main() {
//        Product[] items = {
//                new Product(1, "Pen"),
//                new Product(2, "Book"),
//                new Product(3, "File"),
//        };
//
//        System.out.println(items[items.length-2].name + " " + items[0].id);
//    }
//}


// Program_03
//public class Test1 {
//    static void main() {
//        try {
//            String[] data = {"10", "20", "abc"};
//            int sum = 0;
//            for(String d: data)
//                sum+=Integer.parseInt(d);
//            System.out.println(sum);
//        } catch(NumberFormatException e) {
//            System.out.println("Conversion Failed");
//        }
//    }
//}

// Program_04
//class Alpha {
//    static {
//        System.out.println("Static");
//    }
//    {
//        System.out.println("Instance Block");
//    }
//    Alpha() {
//        System.out.println("Constructor");
//    }
//}
//
//class Beta extends Alpha {
//    {
//        System.out.println("Beta Block");
//    }
//
//    Beta() {
//        System.out.println("Beta Constructor");
//    }
//}
//
//public class Test1{
//    static void main() {
//        new Beta();
//    }
//}


import java.util.ArrayList;

// Program_05
//class Item {
//
//    String name;
//
//    Item(String name) {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//}
//
//public class Test1 {
//    static void main() {
//        ArrayList<Item> item = new ArrayList<>();
//        item.add(new Item("Keyboard"));
//        item.add(new Item("Mouse"));
//        item.remove(0);
//
//        System.out.println(item.get(0).name.toUpperCase());
//    }
//}


// Program_06
//class Demo {
//    private int x;
//
//    Demo(int x) {
//        this.x = x;
//    }
//
//    public int getX() {
//        return x;
//    }
//}
//
//public class Test1 {
//    static void main() {
//        Demo d = new Demo();
//        System.out.println(d.getX());
//    }
//}

// Program_07
//class Address {
//
//    String address;
//
//    public Address(String address) {
//        this.address = address;
//    }
//}
//
//class Person {
//
//    String name;
//    Address address;
//
//    public Person(String name, Address address) {
//        this.name = name;
//        this.address = new Address(address.address);
//    }
//}
//
//public class Test1 {
//    static void main() {
//        Address a1 = new Address("Lahore");
//        Person p1 = new Person("Ali", a1);
//
//        a1.address = "Karachi";
//
//        System.out.println(p1.address.address.toUpperCase());
//    }
//}

// Program_08
//public class Test1 {
//    static void main() {
//        try {
//            int[] arr = { 5, 10, 15};
//
//            for(int i=0; i<=arr.length; i++)
//                System.out.print(arr[i] + " ");
//        } catch(ArrayIndexOutOfBoundsException e) {
//            System.out.println("Error Caught");
//        }
//    }
//}


// Program_09
//class Book {
//
//    String title;
//
//    Book() {
//        title = "Java OOP";
//    }
//
//    Book(String title) {
//        this();
//        title = title.concat(" - " + title);
//    }
//}
//
//public class Test1 {
//    static void main() {
//        Book b1 = new Book("Advanced");
//
//        System.out.println(b1.title.replace("OOP", "Concepts"));
//    }
//}


// Program_10
//class Shape {
//    void area() {
//        System.out.println("Shape Area");
//    }
//}
//
//class Circle extends Shape {
//    @Override
//    void area() {
//        System.out.println("Circle Area");
//    }
//}
//
//class Square extends Shape {
//    @Override
//    void area() {
//        System.out.println("Square Area");
//    }
//}
//
//public class Test1 {
//    static void main() {
//
//        Shape[] shapes = {
//                new Circle(),
//                new Square(),
//                new Shape()
//        };
//
//        for(int i = shapes.length-1; i>=0; i--)
//            shapes[i].area();
//    }
//}

// Program_11
//class DayOfWeeksExample {
//
//    public enum Day{
//        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
//    }
//
//    public static void main() {
//        Day day = new Day();
//        System.out.println("\nAll day of week:");
//        for(Day day: String)
//            System.out.println(day);
//
//    }
//}

// Program_12
class NegativeNumberException extends Exception {

    public NegativeNumberException(String message) {
        super(message);
    }
}

class NumberProcessor {
    public void NumberProcessor(int number) throws NegativeNumberException {
        if(number < 0)
            throw new NegativeNumberException("Input Number cannot be negative: " + number);
        System.out.println("Processing Positive Number: " + number);
    }
}

class Test1 {
    static void main() throws NegativeNumberException {
        NumberProcessor n = new NumberProcessor();
        n.NumberProcessor(-5);
    }
}