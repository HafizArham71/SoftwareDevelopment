package Encapsulations;

//public class A {
//
//    public int publicAge = 15;
//    int defaultAge = 16;
//    protected int protectedAge = 17;
//    private int privateAge = 18;
//
//}

//class A {
//    protected int x = 10;
//}
//
//class B {
//    public static void main(String[] args) {
//        A a = new A();
//        System.out.println(a.x);
//    }
//}

//class B {
//    protected int x = 10;
//}
//
//class A extends B {
//    public static void main(String[] args) {
//        B b = new B();
//        System.out.println(b.x);
//    }
//}

//class A {
//    static int x = 10;
//}
//
//class B extends A {
//    static int x = 20;
//}
//
//public class Test {
//    public static void main(String[] args) {
//        System.out.println(A.x);
//        System.out.println(B.x);
//    }
//}

//class A {
//    final static int x;
//
//    static {
//        x = 10;
//    }
//}

//class A12 {
//    final int x;
//
//    A12() {
//        x = 10;
//    }
//
//    A12(int a) {
//
//    }
//}
//
//public class Test {
//    public static void main(String[] args) {
//        A12 a = new A12();
//    }
//}

class A12 {
    private void show() {
        System.out.println("A");
    }
}

class B12 extends A12 {
    private void show() {
        System.out.println("B");
    }
}

class Test {
    static void main() {

    }
}
