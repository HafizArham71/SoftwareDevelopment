package com.example.Scenes;

import javafx.application.Application;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Circle;
import javafx.scene.image.Image;

public class Scenes extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Root Nodes
        Group root = new Group();

        // Nodes
        Text text = new Text("Arham Mujahid");
        text.setFont(Font.font("Roboto", FontWeight.BOLD, 48));
        text.setFill(Color.web("#332e3c"));
        text.setX(10);
        text.setY(70);

        Line line = new Line();
        line.setStartX(15);
        line.setStartY(100);
        line.setEndX(350);
        line.setEndY(100);
        line.setStrokeWidth(6);
        line.setOpacity(.95);
//        line.setRotate(20);
        line.setStroke(Color.web("#332e3c"));

        Circle circle = new Circle();
        circle.setCenterX(550);
        circle.setCenterY(500);
        circle.setRadius(100);
        circle.setFill(Color.web("#332e3c"));

        Rectangle rectangle = new Rectangle();
        rectangle.setX(15);
        rectangle.setY(150);
        rectangle.setWidth(200);
        rectangle.setHeight(200);
        rectangle.setFill(Color.web("#332e3c"));
        rectangle.setStroke(Color.web("#ff0000"));
        rectangle.setArcWidth(10);
        rectangle.setArcHeight(10);

        Polygon rectangle1 = new Polygon();
        rectangle1.getPoints().setAll(
                15.0, 400.0, 215.0, 400.0,
                215.0, 600.0, 15.0, 600.0
        );
        rectangle1.setFill(Color.web("#332e3c"));

        Polygon triangle = new Polygon();
        triangle.getPoints().setAll(
                230.0, 400.0,
                430.0, 600.0,
                230.0, 600.0
        );
        triangle.setFill(Color.web("#332e3c"));

        Image image = new Image("Logo.png");
        ImageView myImage = new ImageView(image);
        myImage.setX(230);
        myImage.setY(150);
        myImage.setFitWidth(200);
        myImage.setFitHeight(200);

        root.getChildren().addAll(text, line, rectangle, rectangle1, triangle, circle, myImage);

        // Scene
        Scene scene = new Scene(root, 600, 600, Color.web("#d8d4f2"));

        // Stages
        stage.setScene(scene);
        stage.setWidth(900);
        stage.setHeight(700);
        stage.show();
    }

}
