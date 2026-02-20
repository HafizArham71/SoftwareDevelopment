package com.example._3_pingponggame.Class01;

import javafx.application.Application;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.image.Image;

public class Stages extends Application {

    public void start(Stage stage) {

        // NODES


        // BRANCH NODES


        // ROOT NODES
        Group group = new Group();

        // SCENE
        Scene scene = new Scene(group);

        // STAGE
        stage.setTitle("Javafx Practice");
        Image icon = new Image("Icon.png");
        stage.getIcons().add(icon);
//        stage.setWidth(500);
//        stage.setHeight(500);
//        stage.setResizable(false);
//        stage.setX(10);
//        stage.setY(10);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("You can't escape unless you press Q.");
        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));
        stage.setScene(scene);
        stage.show();

    }

    static void main(String[] args) {
        launch(args);
    }

}
