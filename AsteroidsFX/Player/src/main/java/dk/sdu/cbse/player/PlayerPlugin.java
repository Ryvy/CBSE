package dk.sdu.cbse.player;

import dk.sdu.cbse.common.Entity;
import dk.sdu.cbse.common.GameData;
import dk.sdu.cbse.common.IPlugin;
import dk.sdu.cbse.common.World;

public class PlayerPlugin implements IPlugin {

    protected static Player player = new Player();

    @Override
    public void start(GameData gameData, World world) {
        player.setXCoordinate(gameData.getWidth() / 3f);
        player.setYCoordinate(gameData.getHeight() / 3f);
        player.setCoordinates(-15,-10,15,0,-15,10,-10,0);

        world.addEntity(player);

        System.out.println("Created player!");
    }

    @Override
    public void stop(GameData gameData, World world) {
        world.removeEntity(player);
    }
}
