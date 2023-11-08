package dev.zomarrd.app.controllers;

import dev.zomarrd.app.AppLauncher;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RegisterController extends BaseController {
    @FXML
    public TextField userName;

    @FXML
    public TextField userLastName;

    @FXML
    public TextField userEmail;

    @FXML
    public TextField userPass;

    @FXML
    public TextField userPassConfirm;
    @FXML
    public Button btnRegister;

    @Override
    public void initialize(Stage stage) {
        super.initialize(stage);

        btnRegister.setDisable(true);
    }

    public void redirectLogin() {
        try {
            AppLauncher.loadFXML("auth/login", "Login", getStage());
        } catch (Exception e) {
            AppLauncher.getLogger().log(System.Logger.Level.ERROR, e.getMessage());
        }
    }

    public void makeAccount(MouseEvent mouseEvent) {
        //TODO: Implement register logic
    }

    public void hasTyped() {
        btnRegister.setDisable(userName.getText().isEmpty() || userLastName.getText().isEmpty() || userEmail.getText().isEmpty() || userPass.getText().isEmpty() || userPassConfirm.getText().isEmpty());
    }
}
