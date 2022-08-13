package com.example.ocrcardgame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientApplication extends Application {

    private Stage stage;
    @Override
    public void start(Stage stage) throws IOException {

        Globals.CLIENT_APPLICATION = this;
        this.stage = stage;

        FXMLLoader fxmlLoader = new FXMLLoader(ClientApplication.class.getResource("menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public void changeScene(String fxml) throws IOException  {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stage.getScene().setRoot(pane);
    }
    public static void main(String[] args) {
        launch();
    }
}