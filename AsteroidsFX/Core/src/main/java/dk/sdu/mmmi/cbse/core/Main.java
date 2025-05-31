package dk.sdu.mmmi.cbse.core;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application
{

    private final Pane gameWindow = new Pane();
    private final Stage sceneStage = new Stage();


    public static void main(String[] args)
    {
        launch(args);
        System.out.println("goodnight World");
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Asteroids");

        StackPane root = new StackPane();
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}