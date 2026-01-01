module com.example {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.example.SceneBuilder;
    opens com.example.SceneBuilder to javafx.fxml, javafx.graphics;
}
