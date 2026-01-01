class A {
    int x = 1;			// x=1
    static int y = 10;		// y=10

    A() {
        show();
    }

    void show() {
        System.out.println("A-show: x=" + x);
    }

    static void test() {
        System.out.println("A-test");
    }
}

class B extends A {
    int x = 2;			// x=2
    static int y = 20;		// y=20

    B() {
        show();
    }

    void show() {
        System.out.println("B-show: x=" + x);
    }

    static void test() {
        System.out.println("B-test");
    }
}

public class Demo1 {
    public static void main(String[] args) {

        A a = new B();

        System.out.println(a.x);
        System.out.println(a.y);

        a.show();
        a.test();

        B.test();
    }
}

/*
B-show: x=0
B-show: x=2
1
10
B-show: x=2
A-test
B-test
*/
