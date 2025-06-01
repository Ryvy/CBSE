package dk.sdu.mmmi.cbse.core;

import dk.sdu.cbse.common.*;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;


public class Game {

    private final World world = new World();
    private final GameData gameData = new GameData();
    private List<IEntityProcessing> entityProcessings;
    private List<IPlugin> plugins;
    private List<IEntityPostProcessing> entityPostProcessings;

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

        Update();

        Draw();

        gameData.getInput().update();

        LateUpdate();

        stage.setScene(scene);
        stage.show();
    }

    public void Update(){
        if(entityProcessings != null)
            for(IEntityProcessing iEntityProcessing : entityProcessings){
                iEntityProcessing.process(gameData, world);
            }
    }

    public void LateUpdate(){
        if(entityProcessings != null)
            for(IEntityPostProcessing entityPostProcessing : entityPostProcessings){
                entityPostProcessing.process(gameData, world);
            }
    }

    public void Draw(){

    }


    private List<IEntityProcessing> getEntityProcessingServices() {
        if (entityProcessings == null) {
            entityProcessings = new ArrayList<>();
            ServiceLoader.load(IEntityProcessing.class).forEach(entityProcessings::add);
        }
        return entityProcessings;
    }

    private List<IPlugin> getPluginServices() {
        if (plugins == null) {
            plugins = new ArrayList<>();
            ServiceLoader.load(IPlugin.class).forEach(plugins::add);
        }
        return plugins;
    }

    private List<IEntityPostProcessing> getEntityPostProcessingServices() {
        if (entityPostProcessings == null) {
            entityPostProcessings = new ArrayList<>();
            ServiceLoader.load(IEntityPostProcessing.class).forEach(entityPostProcessings::add);
        }
        return entityPostProcessings;
    }
}
