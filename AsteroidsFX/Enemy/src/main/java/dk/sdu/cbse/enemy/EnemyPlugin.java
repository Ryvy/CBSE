package dk.sdu.cbse.enemy;

import dk.sdu.cbse.common.GameData;
import dk.sdu.cbse.common.IPlugin;
import dk.sdu.cbse.common.World;

public class EnemyPlugin implements IPlugin {

    protected static Enemy enemy = new Enemy();


    @Override
    public void start(GameData gameData, World world) {
        enemy.setXCoordinate(gameData.getWidth() / 2.5);
        enemy.setYCoordinate(gameData.getHeight() / 2.5);
        enemy.setCoordinates(-15,-10,15,0,-15,10,-10,0);
        enemy.setRotationAngle(180);
        enemy.setSize(5);

        world.addEntity(enemy);

        System.out.println("Created an enemy!");
    }

    @Override
    public void stop(GameData gameData, World world) {
        world.removeEntity(enemy);
    }
}
