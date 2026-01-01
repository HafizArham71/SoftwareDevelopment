package Interfaces.SmartPhones;

public class SmartPhone implements Camera, MusicPlayer, Phone {

    @Override
    public void takePhoto() {
        System.out.println("Photo has captured");
    }

    @Override
    public void deletePhoto() {
        System.out.println("Photo has deleted");
    }

    @Override
    public void on() {
        System.out.println("Device is ON");
    }

    @Override
    public void off() {
        System.out.println("Device is OFF");
    }

    @Override
    public void playMusic() {
        System.out.println("Music is Playing");
    }

    @Override
    public void stopMusic() {
        System.out.println("Music has stopped");
    }

    @Override
    public void makeACall(long num) {
        System.out.println("Calling to " + num);
    }

    @Override
    public void endCall() {
        System.out.println("Call has ended");
    }

    @Override
    public void show() {
//        Camera.super.show();
//        Phone.super.show();
//        MusicPlayer.super.show();
        System.out.println("My own smartphone method implementations");

    }

}
