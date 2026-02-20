module com.example._3_pingponggame {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example._3_pingponggame to javafx.fxml;
    exports com.example._3_pingponggame.Class01;
    exports com.example._3_pingponggame.Class02;
    exports com.example._3_pingponggame.Class03;
    exports com.example._3_pingponggame.Class04;
    opens com.example._3_pingponggame.Class01 to javafx.fxml;
    opens com.example._3_pingponggame.Class02 to javafx.fxml;
    opens com.example._3_pingponggame.Class03 to javafx.fxml;
    opens com.example._3_pingponggame.Class04 to javafx.fxml;
    exports com.example._3_pingponggame;
}