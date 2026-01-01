package Interfaces.SmartPhones;

public interface Camera {

    void takePhoto();
    void deletePhoto();
    void on();
    void off();

    public static void staticMethod() {
        System.out.println("Static method of Camera Interface");
    }

    default void show() {
        System.out.println("Default method of camera is called");
    }
}
