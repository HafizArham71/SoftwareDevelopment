package Package1;

public class B {
    private int a = 1;
    int b = 2;
    protected int c = 3;
    public int d = 4;

    public int getA(){ return a;}

    public B(){
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}
