package dk.sdu.mmmi.cbse.core;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class Game {
    public static void startGame(Stage stage ) {
        stage.setTitle("Asteroids");

        StackPane root = new StackPane();
        stage.setScene(new Scene(root, 800, 550));
        stage.show();
    }
}
