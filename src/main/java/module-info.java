module com.example.ocrcardgame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ocrcardgame to javafx.fxml;
    exports com.example.ocrcardgame;
}