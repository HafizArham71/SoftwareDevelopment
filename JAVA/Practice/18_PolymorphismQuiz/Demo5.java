public class Demo5 {
    public static void main(String[] args) {
        System.out.println("main-start");

        X x = new Z(5);
        Y y = new Z(10);

        System.out.println("\n-- calls --");
        x.show();
        y.show();

        System.out.println("\n-- fields --");
        System.out.println(x.v);
        System.out.println(y.v);

        System.out.println("\n-- static --");
        x.print();
        y.print();

        System.out.println("\n-- cast madness --");
        ((X) y).show();
        ((Y) x).test();
        ((Z) x).extra();
        ((X) (Y) (Z) x).show();

        System.out.println("\n-- overloaded trap --");
        x.call(null);
        y.call(null);
        ((Z) y).call(5);

        System.out.println("\nmain-end");
    }
}

class X {
    int v = initV();		// 1

    int initV() {
        System.out.println("X.v-init");
        return 1;
    }

    X(int a) {		// 11, 21
        System.out.println("X(int): " + a);
        show();
    }

    void show() {
        System.out.println("X.show: " + v);
    }

    static void print() {
        System.out.println("X.print");
    }

    void test() {
        System.out.println("X.test");
    }

    void call(Integer x) {
        System.out.println("X.call(Integer): " + x);
    }

    void call(String x) {
        System.out.println("X.call(String): " + x);
    }
}

class Y extends X {
    int v = initVy();		// 2

    int initVy() {
        System.out.println("Y.v-init");
        return 2;
    }

    Y(int a) {		// 10, 20
        super(a + 1);
        System.out.println("Y(int): " + a);
        show();
    }

    @Override
    void show() {
        System.out.println("Y.show: " + v);
    }

    static void print() {
        System.out.println("Y.print");
    }

    void test() {
        System.out.println("Y.test");
    }

    void call(Object x) {
        System.out.println("Y.call(Object): " + x);
    }
}

class Z extends Y {
    int v = initVz();		// 3

    Z(int a) {			// 5, 10
        super(a * 2);
        System.out.println("Z(int): " + a);
        show();
    }

    int initVz() {
        System.out.println("Z.v-init");
        return 3;
    }

    @Override
    void show() {
        System.out.println("Z.show: " + v);
    }

    void extra() {
        System.out.println("Z.extra");
    }

    void call(Number x) {
        System.out.println("Z.call(Number): " + x);
    }
}
