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
    }

    public Main() {
        boardingSystem = new BoardingSystem();
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