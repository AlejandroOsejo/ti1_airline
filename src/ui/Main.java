package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.BoardingSystem;

public class Main extends Application {
    private BoardingSystem boardingSystem;
    private BoardingGUI boardingGUI;
    public static void main(String[] args) {
        launch(args);
        /*BoardingSystem boardingSystem = new BoardingSystem("passangers.txt");

        System.out.println("Passangers:");
        boardingSystem.printPassengers();

        System.out.println("Passanger 1:");
        System.out.println(boardingSystem.getPassenger("1"));

        boardingSystem.addToArrivalQueue("1");
        boardingSystem.addToArrivalQueue("2");
        boardingSystem.addToArrivalQueue("3");
        boardingSystem.addToArrivalQueue("4");

        System.out.println("\nArrival queue:");
        boardingSystem.printArrivalQueue();

        boardingSystem.setPriorityEntrance();

        System.out.println("\nBoarding queue:");
        boardingSystem.printBoardingQueue();*/
    }

    public Main() {
        boardingSystem = new BoardingSystem("passangers.txt");
        boardingGUI = new BoardingGUI(boardingSystem);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Mode.fxml"));
        loader.setController(boardingGUI);

        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Boarding System");
        primaryStage.show();
    }
}