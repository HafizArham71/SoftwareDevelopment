interface I {
    default void run() {
        System.out.println("I-default");
    }
}

class M implements I {

    M() {
        run();
    }

    public void run() {
        System.out.println("M-run");
    }
}

public class Demo4 {
    public static void main(String[] args) {

        M m = new M();

        M anon = new M() {
            int val = 99;

            public void run() {
                System.out.println("Anon-run: val=" + val);
            }
        };

        anon.run();
    }
}

/*
M-run
Anon-run: val=0
Anon-run: val=99
*/