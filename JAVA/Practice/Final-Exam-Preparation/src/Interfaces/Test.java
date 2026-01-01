package Interfaces;

import java.util.ArrayList;
import java.util.List;

class Tool {}
class Hammer extends Tool {}
class ElectricHammer extends Hammer {}

public class Test {
    public static void process(List<? extends Hammer> list) {
        list.get(0);
        list.add(new Hammer());
        list.add(new ElectricHammer());
    }

    public static void main(String[] args) {
        List<Tool> l1 = new ArrayList<>();
        List<Hammer> l2 = new ArrayList<>();
        List<ElectricHammer> l3 = new ArrayList<>();

        process(l2);
        process(l3);
//        process(l1);
    }
}
