package Interfaces.SmartPhones;

public interface MusicPlayer {

    void playMusic();
    void stopMusic();
    void on();
    void off();

    public static void staticMethod() {
        System.out.println("Static method of MusicPlayer Interface");
    }

    default void show() {
        System.out.println("Default method of music player is called");
    }
}
