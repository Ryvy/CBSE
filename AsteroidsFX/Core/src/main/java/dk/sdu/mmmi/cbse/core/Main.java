package dk.sdu.mmmi.cbse.core;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Game game = new Game();
        game.startGame(primaryStage);
        game.GameLoop();
    }
}