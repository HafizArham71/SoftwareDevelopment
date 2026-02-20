package com.example._3_pingponggame.Class02;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Circle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Scenes extends Application {

    @Override
    public void start(Stage stage) {

        // NODES
        // --> Text
        Text text = new Text();
        text.setText("Welcome to Hafiz Arham!");
        text.setX(100);
        text.setY(50);
        text.setFont(Font.font("Inter", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 32));
        text.setFill(Color.web("#0E1C36"));

        // --> Line
        Line line = new Line();
        line.setStartX(100);
        line.setEndX(480);
        line.setStartY(60);
        line.setEndY(60);
        line.setStrokeWidth(2);
        line.setStroke(Color.web("#0E1C36"));
        line.setOpacity(.8);
//        line.setRotate(45);

        // --> Rectangle
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(100);
        rectangle.setHeight(100);
        rectangle.setX(10);
        rectangle.setY(100);
        rectangle.setFill(Color.web("#0E1C36"));
        rectangle.setArcHeight(12);
        rectangle.setArcWidth(12);
        rectangle.setStroke(Color.web("#FFEDE1"));
        rectangle.setStrokeWidth(2);

        // --> Triangle
        Polygon triangle = new Polygon();
        triangle.setFill(Color.web("#0E1C36"));
        triangle.getPoints().setAll(
                120.0, 100.0,
                120.0, 200.0,
                220.0, 200.0
        );
        triangle.setStroke(Color.web("#FFEDE1"));
        triangle.setStrokeWidth(2);

        // --> Circle
        Circle circle = new Circle();
        circle.setRadius(50);
        circle.setFill(Color.web("#0E1C36"));
        circle.setStroke(Color.web("#FFEDE1"));
        circle.setStrokeWidth(2);
        circle.setCenterX(280);
        circle.setCenterY(150);

        // --> Image
        Image image = new Image("Icon.png");
        ImageView imageView = new ImageView(image);
        imageView.setX(340);
        imageView.setY(100);
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);

        // BRANCH NODES

        // ROOT NODES
        Group group = new Group();
        group.getChildren().addAll(text, line, rectangle, triangle, circle, imageView);

        // SCENE
        Scene scene = new Scene(group, 600, 600, Color.web("#AFCBFF"));

        // STAGE
        stage.setScene(scene);
        stage.show();
    }

    static void main(String[] args) {
        launch(args);
    }
}
