package ui;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.BoardingSystem;

import java.io.IOException;

public class BoardingGUI {

    // Mode Pane
    @FXML
    private BorderPane bpMode;

    @FXML
    private Button btnNormal;

    @FXML
    private Button btnTest;

    // Main Pane
    @FXML
    private Button btnLoad;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnViewBoarding;

    @FXML
    private Button btnViewExit;


    public BoardingGUI(BoardingSystem boardingSystem) {

    }

    @FXML
    private void handleNormal() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Boarding System");
        stage.show();

        Stage stage2 = (Stage) btnNormal.getScene().getWindow();
        stage2.close();
    }

    @FXML
    private void handleTest() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Boarding System");
        stage.show();

        Stage stage2 = (Stage) btnTest.getScene().getWindow();
        stage2.close();
    }

}
