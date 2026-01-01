public class Demo3 {
    public static void main(String[] args) {
        System.out.println("main -> start");

        System.out.println("\n-- P ref to new R() --");
        P p = new R();

        System.out.println("\n-- p.call() --");
        p.call();

        System.out.println("\n-- static call via p --");
        p.staticCall();

        System.out.println("\n-- Downcast to Q and call hidden field + method --");
        Q q = (Q)p;
        System.out.println("q.val = " + q.val);
        q.call();

        System.out.println("\n-- Anonymous Inner Class using P reference --");
        P anon = new R() {
            int val = 999;

            @Override
            void run() {
                System.out.println("Anon.run() -> val=" + val);
            }

            @Override
            void show() {
                System.out.println("Anon.show()");
            }
        };

        anon.call();
        anon.show();
        anon.staticCall();

        System.out.println("\n-- Interface default and static methods --");
        I iref = new R();
        iref.def();
        I.sta();

        System.out.println("\n-- Constructor chain check --");
        R r2 = new R(50);

        System.out.println("\nmain -> end");
    }
}

/* ------------ Interface -------------- */
interface I {
    default void def() {
        System.out.println("I.defaultMethod");
    }
    static void sta() {
        System.out.println("I.staticMethod");
    }
}

/* ------------ Class P -------------- */
class P implements I {

    static String sp = initSP();		// P-static
    static { System.out.println("P -> static block"); }

    int val = initValP();		// 1
    final int finalP = initFinalP();	// 100

    { System.out.println("P -> instance block"); }

    P() {
        System.out.println("P() -> start");
        run();     // overridable
        System.out.println("P() -> end");
    }

    static String initSP() {
        System.out.println("P -> static field init");
        return "P-static";
    }

    int initValP() {
        System.out.println("P -> instance field val init");
        return 1;
    }

    int initFinalP() {
        System.out.println("P -> final field init");
        return 100;
    }

    void run() {
        System.out.println("P.run() -> val=" + val);
    }

    void show() {
        System.out.println("P.show()");
    }

    void call() {
        System.out.println("P.call()");
        show();
    }

    static void staticCall() {
        System.out.println("P.staticCall()");
    }
}

/* ------------ Class Q -------------- */
class Q extends P {

    static String sq = initSQ();			// Q-static
    static { System.out.println("Q -> static block"); }

    int val = initValQ();		// 2
    final int finalQ = initFinalQ();	// 200

    { System.out.println("Q -> instance block"); }

    Q() {
        super();
        System.out.println("Q() -> start");
        run();
        System.out.println("Q() -> end");
    }

    Q(int x) {
        this();
        System.out.println("Q(int) -> " + x);
    }

    static String initSQ() {
        System.out.println("Q -> static field init");
        return "Q-static";
    }

    int initValQ() {
        System.out.println("Q -> instance field val init");
        return 2;
    }

    int initFinalQ() {
        System.out.println("Q -> final field init");
        return 200;
    }

    @Override
    void run() {
        System.out.println("Q.run() -> val=" + val);
    }

    @Override
    void show() {
        System.out.println("Q.show()");
    }

    @Override
    void call() {
        System.out.println("Q.call()");
        super.call();
    }

    static void staticCall() {
        System.out.println("Q.staticCall()");
    }
}

/* ------------ Class R -------------- */
class R extends Q {

    static String sr = initSR();			// R-static
    static { System.out.println("R -> static block"); }

    int val = initValR();		// 3

    { System.out.println("R -> instance block"); }

    R() {
        super();
        System.out.println("R() -> start");
        run();
        System.out.println("R() -> end");
    }

    R(int x) {
        this();
        System.out.println("R(int) -> " + x);
    }

    static String initSR() {
        System.out.println("R -> static field init");
        return "R-static";
    }

    int initValR() {
        System.out.println("R -> instance field val init");
        return 3;
    }

    @Override
    void run() {
        System.out.println("R.run() -> val=" + val);
    }

    @Override
    void show() {
        System.out.println("R.show()");
    }

    @Override
    void call() {
        System.out.println("R.call()");
        super.call();
    }

    static void staticCall() {
        System.out.println("R.staticCall()");
    }
}
