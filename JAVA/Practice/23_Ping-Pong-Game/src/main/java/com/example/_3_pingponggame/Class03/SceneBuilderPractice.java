package com.example._3_pingponggame.Class03;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.Objects;

public class SceneBuilderPractice extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/_3_pingponggame/SceneBuilderFile.fxml")));
        Scene scene = new Scene(root);
//        FXMLLoader fxmlLoader = new FXMLLoader(SceneBuilderPractice.class.getResource("/SceneBuilderFile.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setScene(scene);
        stage.show();
    }

    static void main(String[] args) {
        launch(args);
    }
}
