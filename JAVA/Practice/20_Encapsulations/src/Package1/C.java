package Package1;

public class C extends B{
    C(){
        // System.out.println(a);      Can't access private

        System.out.println(getA());
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}