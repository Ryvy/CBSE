package dk.sdu.mmmi.cbse.core;

import dk.sdu.cbse.common.Input;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import dk.sdu.cbse.common.GameData;



public class Game {

    private final GameData gameData = new GameData();

    public void startGame(Stage stage) {
        stage.setTitle("Asteroids");

        StackPane root = new StackPane();
        Scene scene = new Scene(root, gameData.getWidth(), gameData.getHeight());

        scene.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.A)){
                gameData.getInput().setkey(Input.left, true);
            }
            if(event.getCode().equals(KeyCode.D)){
                gameData.getInput().setkey(Input.right, true);
            }
            if(event.getCode().equals(KeyCode.W)){
                gameData.getInput().setkey(Input.up, true);
            }
            if(event.getCode().equals(KeyCode.SPACE)){
                gameData.getInput().setkey(Input.space, true);
            }
        });

        scene.setOnKeyReleased(event ->{
            if(event.getCode().equals(KeyCode.A)){
                gameData.getInput().setkey(Input.left, false);
            }
            if(event.getCode().equals(KeyCode.D)){
                gameData.getInput().setkey(Input.right, false);
            }
            if(event.getCode().equals(KeyCode.W)){
                gameData.getInput().setkey(Input.up, false);
            }
            if(event.getCode().equals(KeyCode.SPACE)){
                gameData.getInput().setkey(Input.space, false);
            }
        });


        stage.setScene(scene);
        stage.show();
    }
}
