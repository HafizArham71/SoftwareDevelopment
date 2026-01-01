class X {
    int v = 5;		// v=5

    X get() {
        return this;
    }

    void show() {
        System.out.println("X-show: v=" + v);
    }

    static void check() {
        System.out.println("X-check");
    }
}

class Y extends X {
    int v = 10;		// v=10

    @Override
    Y get() {
        return this;
    }

    void show() {
        System.out.println("Y-show: v=" + v);
    }

    static void check() {
        System.out.println("Y-check");
    }
}

public class Demo3 {
    public static void main(String[] args) {

        X x = new Y();

        System.out.println(x.v);
        x.show();
        x.get().show();
        x.check();

        Y y = new Y();
        y.check();
    }
}

/*
5
Y-show: v=10
Y-show: v=10
X-check
Y-check
*/

