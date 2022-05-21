package com.visual.casalinda;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SystemApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SystemApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1480, 860);
        Image systemIcon = new Image(Objects.requireNonNull(SystemApplication.class.getResourceAsStream("images/icon.png")));

        stage.setTitle("Casa Linda");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(systemIcon);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}