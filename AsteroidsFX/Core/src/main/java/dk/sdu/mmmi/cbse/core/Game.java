package dk.sdu.mmmi.cbse.core;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import dk.sdu.cbse.common.DisplaySettings;



public class Game {

    private final DisplaySettings displaySettings = new DisplaySettings();

    public void startGame(Stage stage) {
        stage.setTitle("Asteroids");

        StackPane root = new StackPane();
        Scene gameScene = new Scene(root, displaySettings.getWidth(), displaySettings.getHeight());
        stage.setScene(gameScene);
        stage.show();
    }
}
