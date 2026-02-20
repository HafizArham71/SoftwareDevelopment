module com.example._9_aigamecode {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.desktop;

    opens com.example._9_aigamecode to javafx.fxml;
    exports com.example._9_aigamecode.Game;
    opens com.example._9_aigamecode.Game to javafx.fxml;
}
