package dev.zomarrd.app.controllers;

import javafx.stage.Stage;
import lombok.Getter;

@Getter
public class BaseController {
    public Stage stage;

    public void initialize(Stage stage) {
        this.stage = stage;
    }
}
