package Interfaces;

import Interfaces.SmartPhones.SmartPhone;
import Interfaces.Summation.Sum;

import java.util.ArrayList;

public class Testing {
    static void main() {

        // Method # 01
//        Dog dog = new Dog();
//        Cat cat = new Cat();

        // Method # 02
//        Animal dog = new Dog();
//        Animal cat = new Cat();
//
//        dog.eating();
//        dog.sleeping();
//        cat.eating();
//        cat.sleeping();

//        SmartPhone smartPhone = new SmartPhone();
//
//        smartPhone.takePhoto();
//        smartPhone.deletePhoto();
//        smartPhone.playMusic();
//        smartPhone.stopMusic();
//        smartPhone.makeACall(1234567890);
//        smartPhone.endCall();
//        smartPhone.on();
//        smartPhone.off();
//
//        smartPhone.show();
//        ArrayList list = new ArrayList();
//        list.add("Arham");
//        list.add(123);
//        list.add(3.6);
//
//        String str = (String) list.get(0);
//        Integer myInt = (Integer) list.get(1);

//        Box box = new Box("Square");

        Box<String> b1 = new Box<>("Rectangle");

        MyClass<Integer> myClass = new MyClass<>();
        myClass.start();
        myClass.stop();

    }
}


class Box<T> {
    T name;

    Box(T name) {
        this.name = name;
    }

    public T getName() {
        return name;
    }
}

interface myInterface<T> {
    void start();
    void stop();
}

class MyClass<T extends Number> implements myInterface<T> {

    @Override
    public void start() {
        System.out.println("Have Started");
    }

    @Override
    public void stop() {
        System.out.println("Have Stopped");
    }
}