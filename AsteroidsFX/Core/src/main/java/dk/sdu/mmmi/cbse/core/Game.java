package dk.sdu.mmmi.cbse.core;

import dk.sdu.cbse.common.*;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;


public class Game {

    private final World world = new World();
    private final GameData gameData = new GameData();
    private final Map<Entity, Polygon> polygonMap = new ConcurrentHashMap<>();
    private List<IEntityProcessing> entityProcessings;
    private List<IPlugin> plugins;
    private List<IEntityPostProcessing> entityPostProcessings;

    StackPane pane = new StackPane();
    Scene scene = new Scene(pane, gameData.getWidth(), gameData.getHeight());

    public Game(List<IEntityProcessing> entityProcessings, List<IEntityPostProcessing> entityPostProcessings, List<IPlugin> plugins){
        this.entityProcessings = entityProcessings;
        this.entityPostProcessings = entityPostProcessings;
        this.plugins = plugins;
    }

    public void startGame(Stage stage) {
        stage.setTitle("Asteroids");


        getEntityProcessingServices();
        getPluginServices();
        getEntityPostProcessingServices();

        RunPlugins();

        stage.setScene(scene);
        stage.show();
    }

    public void GameLoop(){
        new AnimationTimer(){

            @Override
            public void handle(long l) {

                scene.setOnKeyPressed(event -> {
                    if(event.getCode().equals(KeyCode.A)){
                        gameData.getInput().setkey(Input.LEFT, true);
                    }
                    if(event.getCode().equals(KeyCode.D)){
                        gameData.getInput().setkey(Input.RIGHT, true);
                    }
                    if(event.getCode().equals(KeyCode.W)){
                        gameData.getInput().setkey(Input.UP, true);
                    }
                    if(event.getCode().equals(KeyCode.SPACE)){
                        gameData.getInput().setkey(Input.SPACE, true);
                    }
                });

                scene.setOnKeyReleased(event ->{
                    if(event.getCode().equals(KeyCode.A)){
                        gameData.getInput().setkey(Input.LEFT, false);
                    }
                    if(event.getCode().equals(KeyCode.D)){
                        gameData.getInput().setkey(Input.RIGHT, false);
                    }
                    if(event.getCode().equals(KeyCode.W)){
                        gameData.getInput().setkey(Input.UP, false);
                    }
                    if(event.getCode().equals(KeyCode.SPACE)){
                        gameData.getInput().setkey(Input.SPACE, false);
                    }
                });

                gameData.getInput().update();
                Update();
                Draw();
                LateUpdate();
            }
        }.start();
    }

    public void RunPlugins(){
        if(plugins != null){
            for(IPlugin plugin : getPluginServices()){
                plugin.start(gameData, world);
            }
        }
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
        for(Entity polygon : polygonMap.keySet()){
            if(!world.getEntities().contains(polygon)){
                Polygon polygonToRemove = polygonMap.get(polygon);
                polygonMap.remove(polygon);
                pane.getChildren().remove(polygonToRemove);
            }
        }

        for (Entity entity : world.getEntities()) {
            Polygon polygon = polygonMap.get(entity);
            if (polygon == null) {
                polygon = new Polygon(entity.getCoordinates());
                polygonMap.put(entity, polygon);
                pane.getChildren().add(polygon);
            }
            polygon.setTranslateX(entity.getXCoordinate());
            polygon.setTranslateY(entity.getYCoordinate());
            polygon.setRotate(entity.getRotationAngle());
        }
    }


    private List<IEntityProcessing> getEntityProcessingServices() {
        if (entityProcessings == null) {
            entityProcessings = new ArrayList<>();
            ServiceLoader.load(IEntityProcessing.class).forEach(entityProcessings::add);
        }
        return entityProcessings;
    }

    private List<IPlugin> getPluginServices() {
        System.out.println("Loading plugins");
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
