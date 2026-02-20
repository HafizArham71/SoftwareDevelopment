package com.example._3_pingponggame.Class04;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;


public class Controller {

    @FXML
    private Circle circle;
    private double x;
    private double y;

    // METHODS
    public void up(ActionEvent e) {
        circle.setCenterY(y-=10);
    }

    public void down(ActionEvent e) {
        circle.setCenterY(y+=10);
    }

    public void left(ActionEvent e) {
        circle.setCenterX(x-=10);
    }

    public void right(ActionEvent e) {
        circle.setCenterX(x+=10);
    }
}
