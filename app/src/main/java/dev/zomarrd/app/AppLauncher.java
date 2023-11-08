package dev.zomarrd.app;

import dev.zomarrd.app.controllers.BaseController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

public class AppLauncher extends Application {

    @Getter
    @Setter
    public static System.Logger logger;

    @Override
    public void start(Stage stage) throws IOException {
        loadFXML("auth/login", "Login", stage);
    }

    public static void loadFXML(String fxml, String appTitle, Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(AppLauncher.class.getResource("views/" + fxml + ".fxml"));

        Scene scene = new Scene(loader.load());
        scene.setFill(Color.TRANSPARENT);

        stage.setTitle("PIFinal - " + appTitle);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
        ((BaseController) loader.getController()).initialize(stage);
    }

    public static void main(String[] args) {
        setLogger(System.getLogger("Proyecto Final - App"));
        launch();
    }
}