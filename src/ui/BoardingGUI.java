package ui;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.BoardingSystem;
import model.Passenger;

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

    @FXML
    private Pane viewPane;

    // Search Pane
    @FXML
    private Button btnSearchPassenger;

    @FXML
    private TextField tfPassengerId;

    @FXML
    private Button btnCheckIn;

    // View Passenger Info Pane
    @FXML
    private Label lbAge;

    @FXML
    private Label lbId;

    @FXML
    private Label lbIsFirstClass;

    @FXML
    private Label lbMiles;

    @FXML
    private Label lbName;

    @FXML
    private Label lbNeedSpecialAtte;

    @FXML
    private Label lbSeat;

    // Passengers List
    @FXML
    private TableColumn<Passenger, String> tcName;

    @FXML
    private TableColumn<Passenger, String> tcSeat;

    @FXML
    private TableColumn<Passenger, String> tcRow;

    @FXML
    private TableView<Passenger> tvPassengersList;

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
        File listPassengers = fileChooser.showOpenDialog(null);

        boolean isValid = listPassengers.getName().endsWith(".txt");
        if (isValid) {
            System.out.println(listPassengers.getPath());
            boardingSystem.loadPassengers(listPassengers.getPath());

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
        File arrivalPassengers = fileChooser.showOpenDialog(null);

        boolean isValid = arrivalPassengers.getName().endsWith(".txt");
        if (isValid) {
            System.out.println(arrivalPassengers.getPath());
            boardingSystem.addToArrivalQueueTest(arrivalPassengers.getPath());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid file");
            alert.setContentText("The file must be a .txt file");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleSearch() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Search.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Search");
        stage.show();
    }

    @FXML
    private void handleSearchPassenger() throws IOException {
        String passengerId = tfPassengerId.getText();
        Passenger passenger = boardingSystem.getPassenger(passengerId);

        if (passenger != null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("passengerInfo.fxml"));
            loader.setController(this);
            Node root = loader.load();

            viewPane.getChildren().clear();
            viewPane.getChildren().add(root);

            Stage stage = (Stage) btnSearchPassenger.getScene().getWindow();
            stage.close();

            lbName.setText(passenger.getName());
            lbId.setText(passenger.getId());
            lbAge.setText(passenger.getAge() + " years old");
            lbSeat.setText(passenger.getRow() + " " + passenger.getSeat());
            lbIsFirstClass.setText(passenger.isFirstClass() ? "Yes" : "No");
            lbMiles.setText(passenger.getAccumulatedMiles() + "");
            lbNeedSpecialAtte.setText(passenger.isSpecialAttention() ? "Yes" : "No");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Passenger not found");
            alert.setContentText("The passenger with the ID " + passengerId + " was not found");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleCheckIn() {
        String passengerId = tfPassengerId.getText();
        boardingSystem.addToArrivalQueue(passengerId);
        System.out.println("Check In");
    }

    @FXML
    private void handleViewBoarding() throws IOException {
        boardingSystem.setPriorityEntrance();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("passengersList.fxml"));
        loader.setController(this);
        Node root = loader.load();

        viewPane.getChildren().clear();
        viewPane.getChildren().add(root);
        root.setLayoutX(130);

        initBoardingList();
    }

    private void initBoardingList() {
        ObservableList<Passenger> passengers = FXCollections.observableArrayList(boardingSystem.getBoardingQueue());
        tvPassengersList.setItems(passengers);
        tcName.setCellValueFactory(new PropertyValueFactory<Passenger, String>("name"));
        tcRow.setCellValueFactory(new PropertyValueFactory<Passenger, String>("row"));
        tcSeat.setCellValueFactory(new PropertyValueFactory<Passenger, String>("seat"));
    }

    @FXML
    private void handleViewExit() throws IOException {
        boardingSystem.setPriorityExit();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("passengersList.fxml"));
        loader.setController(this);
        Node root = loader.load();

        viewPane.getChildren().clear();
        viewPane.getChildren().add(root);
        root.setLayoutX(130);

        initExitList();
    }

    private void initExitList() {
        ObservableList<Passenger> passengers = FXCollections.observableArrayList(boardingSystem.getExitQueue());
        tvPassengersList.setItems(passengers);
        tcName.setCellValueFactory(new PropertyValueFactory<Passenger, String>("name"));
        tcRow.setCellValueFactory(new PropertyValueFactory<Passenger, String>("row"));
        tcSeat.setCellValueFactory(new PropertyValueFactory<Passenger, String>("seat"));
    }

}
