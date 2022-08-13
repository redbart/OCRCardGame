package com.example.ocrcardgame;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Card {

    public static final double CARD_HEIGHT = 140d, CARD_WIDTH = 90d;
    private static final double TEXT_OFFSET_X = 12.5d, TEXT_OFFSET_Y = 25d;

    private static final Color BACK_COLOUR = Color.GREY;
    private static final Image BACK_GRAPHIC = new Image("com/example/ocrcardgame/pp.png");

    private Pane frontPane;
    private Canvas frontCanvas;
    private GraphicsContext frontGC;

    private Pane backPane;
    private Canvas backCanvas;
    private GraphicsContext backGC;

    private int number;
    private Color colour;

    public Card(int number, Color colour) {

        this.number = number;
        this.colour = colour;



    }

    public Card initialiseFrontPane(){
        frontCanvas = new Canvas(CARD_WIDTH, CARD_HEIGHT);
        frontGC = frontCanvas.getGraphicsContext2D();
        frontPane = new Pane(frontCanvas);
        frontPane.setMaxSize(CARD_WIDTH, CARD_HEIGHT);

        //fill in background of card with correct colour
        String style = String.format("-fx-background-color: rgb(%f,%f,%f);",colour.getRed() * 255,
                colour.getGreen() * 255, colour.getBlue() * 255);
        frontPane.setStyle(style);

        //add the text for the number
        Color textColor = (colour == Color.BLACK) ? Color.WHITE : Color.BLACK;
        frontGC.setFill(textColor);
        frontGC.fillText(String.valueOf(number), TEXT_OFFSET_X, TEXT_OFFSET_Y);
        return this;
    }

    public Card initialiseBackPane() {
        backCanvas = new Canvas(CARD_WIDTH, CARD_HEIGHT);
        backPane = new Pane(backCanvas);
        backPane.setMaxSize(CARD_WIDTH, CARD_HEIGHT);
        backGC = backCanvas.getGraphicsContext2D();

        //fill in background of card with correct colour
        String style = String.format("-fx-background-color: rgb(%f,%f,%f);",BACK_COLOUR.getRed() * 255,
                BACK_COLOUR.getGreen() * 255, BACK_COLOUR.getBlue() * 255);
        backPane.setStyle(style);

        //add the path of the background image
        backGC.drawImage(BACK_GRAPHIC, 0,0);
        return this;
    }

    public Pane getFrontPane(){
        return frontPane;
    }

    public Pane getBackPane() {
        return backPane;
    }

    public Canvas getFrontCanvas() {
        return frontCanvas;
    }
}
