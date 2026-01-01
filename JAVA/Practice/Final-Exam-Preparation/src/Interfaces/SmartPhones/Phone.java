package Interfaces.SmartPhones;

public interface Phone {

    void makeACall(long num);
    void endCall();
    void on();
    void off();

    public static void staticMethod() {
        System.out.println("Static method of Phone Interface");
    }

    default void show() {
        System.out.println("Default method of phone is called");
    }
}
