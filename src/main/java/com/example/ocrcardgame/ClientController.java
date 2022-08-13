package com.example.ocrcardgame;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.List;

public class ClientController {
    public GridPane MainBox;
    public HBox player1CardBox;
    public HBox player2CardBox;
    public VBox deckBox;
    public Text leftInDeckText;
    public Text player1HandText;
    public Text player2HandText;
    @FXML
    private Label welcomeText;

    @FXML
    protected void initialize(){

        Card deckCard = new Card(0, Color.LIGHTSALMON).initialiseBackPane();
        deckBox.getChildren().add(deckCard.getBackPane());

        Card card1 = new Card(8, Color.YELLOW).initialiseFrontPane().initialiseBackPane();
        player1CardBox.getChildren().add(card1.getFrontPane());

        Card card2 = new Card(1, Color.RED).initialiseFrontPane().initialiseBackPane();
        player2CardBox.getChildren().add(0, card2.getFrontPane());

        Card card3 = new Card(4,Color.BLACK);
        swapCardsInPlayAreas(card3, true);
    }

    void swapCardsInPlayAreas(Card newCard, boolean player1) {
        if (player1) {
            player1CardBox.getChildren().remove(1);
            player1CardBox.getChildren().add(newCard.initialiseFrontPane().getFrontPane());
        } else {
            player2CardBox.getChildren().remove(0);
            player2CardBox.getChildren().add(newCard.initialiseFrontPane().getFrontPane());
        }
    }
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}