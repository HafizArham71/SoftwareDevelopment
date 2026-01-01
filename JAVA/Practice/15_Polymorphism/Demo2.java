public class Demo2 {
    public static void main(String[] args) {
        System.out.println("main -> start");

        System.out.println("\n-- create A ref to new C() --");
        A a = new C(); // triggers class loading + init + constructors
        System.out.println("-- created A a = new C() --");

        System.out.println("\n-- call a.show() --");
        a.show(); // dynamic dispatch

        System.out.println("\n-- static method called via reference a.staticMethod() --");
        a.staticMethod(); // static binding (resolved by reference type A)

        System.out.println("\n-- cast to B and call staticMethod --");
        B b = (B) a; // safe downcast because object is C which extends B
        b.staticMethod(); // resolved by reference type B

        System.out.println("\n-- call ((C)a).show(\"hello\") overload --");
        ((C) a).show("hello"); // overload defined in C

        System.out.println("\n-- field hiding demonstration --");
        System.out.println("a.val = " + a.val);        // field access uses reference type
        System.out.println("((B)a).val = " + ((B)a).val); // field using B reference

        System.out.println("\n-- create new C(\"ctor\") --");
        C c = new C("ctor");
        System.out.println("-- created C c = new C(\"ctor\") --");

        System.out.println("\nmain -> end");
    }
}

/* --------- Class A (base) --------- */
class A {
    static String staticA = initStaticA();						// A-static
    static { System.out.println("A -> static block"); }

    int val = initValA();	
    String name = initNameA();	

    { System.out.println("A -> instance block"); }

    A() {
        System.out.println("A() -> start");
        // calling an overridable method from constructor (dangerous/test)
        show();
        System.out.println("A() -> end");
    }

    A(String tag) {
        this();
        System.out.println("A(String) -> " + tag);
    }

    static String initStaticA() {
        System.out.println("A -> static field init");
        return "A-static";
    }

    int initValA() {
        System.out.println("A -> instance field val init");
        return 10;
    }

    String initNameA() {
        System.out.println("A -> instance field name init");
        return "A-name";
    }

    void show() {
        System.out.println("A.show() -> name = " + name + ", val = " + val);
    }

    static void staticMethod() {
        System.out.println("A.staticMethod()");
    }
}

/* --------- Class B (middle) --------- */
class B extends A {
    static String staticB = initStaticB();				// B-static
    static { System.out.println("B -> static block"); }

    int val = initValB();
    String name = initNameB();

    { System.out.println("B -> instance block"); }

    B() {
        super("fromB");
        System.out.println("B() -> start");
        show();
        System.out.println("B() -> end");
    }

    B(int x) {
        this();
        System.out.println("B(int) -> " + x);
    }

    static String initStaticB() {
        System.out.println("B -> static field init");
        return "B-static";
    }

    int initValB() {
        System.out.println("B -> instance field val init");
        return 20;
    }

    String initNameB() {
        System.out.println("B -> instance field name init");
        return "B-name";
    }

    @Override
    void show() {
        System.out.println("B.show() -> name = " + name + ", val = " + val);
    }

    static void staticMethod() {
        System.out.println("B.staticMethod()");
    }
}

/* --------- Class C (leaf) --------- */
class C extends B {
    static { System.out.println("C -> static block"); }

    int val = initValC();
    String name = initNameC();

    { System.out.println("C -> instance block"); }

    C() {
        System.out.println("C() -> start");
        show();
        System.out.println("C() -> end");
    }

    C(String tag) {
        this();
        System.out.println("C(String) -> " + tag);
    }

    int initValC() {
        System.out.println("C -> instance field val init");
        return 30;
    }

    String initNameC() {
        System.out.println("C -> instance field name init");
        return "C-name";
    }

    @Override
    void show() {
        System.out.println("C.show() -> name = " + name + ", val = " + val);
    }

    // overload of show
    void show(String msg) {
        System.out.println("C.show(String) -> " + msg + " | name = " + name);
    }

    static void staticMethod() {
        System.out.println("C.staticMethod()");
    }
}
