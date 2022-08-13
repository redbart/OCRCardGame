package com.example.ocrcardgame;

import javafx.event.ActionEvent;

import java.io.IOException;

public class MenuController {

    public void onConnectButtonPressed() throws IOException {
        Globals.CLIENT_APPLICATION.changeScene("client.fxml");
    }
}
