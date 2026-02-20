package com.example._3_pingponggame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.util.Objects;

public class Window extends Application {

    public void start(Stage stage) {

        // 1_ NODES

        Text pingPongGame = new Text("PING PONG GAME");

        // --> Button
        Button myButton = new Button();
        myButton.setText("Hello World!");

        // 2_ BRANCH NODES
        VBox verticalBox = new VBox();

        // 3_ ROOT NODES

        // --> Group
//        Group group = new Group(myButton);
        StackPane myStackPane = new StackPane();
        myStackPane.getChildren().addAll(myButton, pingPongGame);

        // 4_ SCENE
        Scene scene = new Scene(myStackPane);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/style.css")).toExternalForm());

        // 5_ STAGE
        stage.setScene(scene);
        stage.setWidth(1000);
        stage.setHeight(700);
        stage.show();

    }

    static void main(String[] args) {
        launch(args);
    }

}