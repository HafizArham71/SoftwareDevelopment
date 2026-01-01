package com.example.Stages;

import javafx.application.Application;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.Group;

public class Stages extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Group group = new Group();

        Scene scene = new Scene(group, Color.web("#cccccc"));

        Image icon = new Image("Logo.png");
        stage.getIcons().add(icon);
        stage.setTitle("Learning Stages in JavaFX");
        stage.setWidth(1500);
        stage.setHeight(800);
        stage.setResizable(false);
        stage.setX(-8);
        stage.setY(0);
//        System.out.println("X: " + stage.getX());
//        System.out.println("Y: " + stage.getY());
        stage.setFullScreen(true);
        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("Q"));
        stage.setFullScreenExitHint("You can't escape unless u press Q");
        stage.setScene(scene);
        stage.show();
    }
}