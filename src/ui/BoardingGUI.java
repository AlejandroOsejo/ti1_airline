package ui;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
    private Button btnLoadArrivalList;

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

        btnLoadArrivalList.setVisible(false);
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
        btnLoadArrivalList.setVisible(true);
        btnSearch.setDisable(true);
        btnViewBoarding.setDisable(true);
        btnViewExit.setDisable(true);
    }

    @FXML
    private void handleLoad() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File listPassangers = fileChooser.showOpenDialog(null);

        boolean isValid = listPassangers.getName().endsWith(".txt");
        if (isValid) {
            System.out.println(listPassangers.getPath());
            boardingSystem.loadPassengers(listPassangers.getPath());
            System.out.println("Load");

            btnSearch.setDisable(false);
            btnViewBoarding.setDisable(false);
            btnViewExit.setDisable(false);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid file");
            alert.setContentText("The file must be a .txt file");
            alert.showAndWait();

            System.out.println("Invalid file");
        }
    }

    @FXML
    private void handleLoadArrival() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File arrivalPassangers = fileChooser.showOpenDialog(null);

        boolean isValid = arrivalPassangers.getName().endsWith(".txt");
        if (isValid) {
            System.out.println(arrivalPassangers.getPath());
            boardingSystem.addToArrivalQueueTest(arrivalPassangers.getPath());
            System.out.println("Load Test");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid file");
            alert.setContentText("The file must be a .txt file");
            alert.showAndWait();

            System.out.println("Invalid file");
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
