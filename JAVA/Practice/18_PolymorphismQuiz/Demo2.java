class P {
    P() {
        call(5);
    }

    void call(int x) {
        System.out.println("P-int: " + x);
    }

    void call(Integer x) {
        System.out.println("P-Integer: " + x);
    }
}

class Q extends P {

    Q() {
        call(10);
    }

    void call(int x) {
        System.out.println("Q-int: " + x);
    }

    void call(Integer x) {
        System.out.println("Q-Integer: " + x);
    }
}

public class Demo2 {
    public static void main(String[] args) {
        P p = new Q();
        p.call(null);
    }
}

/*
Q-int: 5
Q-int: 10
Q-Integer: null
*/
