module dev.zomarrd.app {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;

    opens dev.zomarrd.app to javafx.fxml;
    exports dev.zomarrd.app;
}