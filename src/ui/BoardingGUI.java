package ui;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.BoardingSystem;

import java.io.File;
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

    private boolean isTestMode;

    private BoardingSystem boardingSystem;


    public BoardingGUI(BoardingSystem boardingSystem) {
        this.boardingSystem = boardingSystem;
        isTestMode = false;
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

        btnSearch.setDisable(true);
        btnViewBoarding.setDisable(true);
        btnViewExit.setDisable(true);
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

        isTestMode = true;

        btnSearch.setDisable(true);
        btnViewBoarding.setDisable(true);
        btnViewExit.setDisable(true);
    }

    @FXML
    private void handleLoad() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            System.out.println(file.getPath());
            boardingSystem.loadPassengers(file.getPath());
            System.out.println("Load");

            btnSearch.setDisable(false);
            btnViewBoarding.setDisable(false);
            btnViewExit.setDisable(false);
        }
    }

    @FXML
    private void handleSearch() {
        System.out.println("Search");
    }

    @FXML
    private void handleViewBoarding() {
        System.out.println("View Boarding");
    }

    @FXML
    private void handleViewExit() {
        System.out.println("View Exit");
    }

}
