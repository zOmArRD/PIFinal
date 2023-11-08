module dev.zomarrd.app {
    requires static lombok;

    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;

    opens dev.zomarrd.app to javafx.fxml;
    opens dev.zomarrd.app.controllers to javafx.fxml;

    exports dev.zomarrd.app;
    exports dev.zomarrd.app.controllers;
}