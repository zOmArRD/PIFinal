package dev.zomarrd.app.controllers;

import dev.zomarrd.app.AppLauncher;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController extends BaseController {
    @FXML
    public TextField userEmail;

    @FXML
    public TextField userPass;

    @FXML
    public Button btnLogin;

    @Override
    public void initialize(Stage stage) {
        super.initialize(stage);

        btnLogin.setDisable(true);
    }

    public void login() {
        try {
            //TODO: Implement login logic
            AppLauncher.loadFXML("app/menu", "Menu", getStage());
        } catch (Exception e) {
            AppLauncher.getLogger().log(System.Logger.Level.ERROR, e.getMessage());
        }
    }

    public void redirectMakeAccount() {
        try {
            AppLauncher.loadFXML("auth/register", "Register", getStage());
        } catch (Exception e) {
            AppLauncher.getLogger().log(System.Logger.Level.ERROR, e.getMessage());
        }
    }

    public void hasTyped() {
        btnLogin.setDisable(userEmail.getText().isEmpty() || userPass.getText().isEmpty());
    }
}
