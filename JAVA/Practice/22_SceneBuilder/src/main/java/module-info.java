module com.example._2_scenebuilder {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example._2_scenebuilder to javafx.fxml;
    exports com.example._2_scenebuilder;
}