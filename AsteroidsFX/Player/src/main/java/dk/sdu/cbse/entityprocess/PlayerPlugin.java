package dk.sdu.cbse.entityprocess;

import dk.sdu.cbse.common.GameData;
import dk.sdu.cbse.common.IPlugin;
import dk.sdu.cbse.common.World;

public class PlayerPlugin implements IPlugin {

    protected static EntityProcess entityProcess = new EntityProcess();

    @Override
    public void start(GameData gameData, World world) {
        entityProcess.setXCoordinate(gameData.getWidth() / 3f);
        entityProcess.setYCoordinate(gameData.getHeight() / 3f);
        entityProcess.setCoordinates(-15,-10,15,0,-15,10,-10,0);
        entityProcess.setSize(5);

        world.addEntity(entityProcess);

        System.out.println("Created player!");
    }

    @Override
    public void stop(GameData gameData, World world) {
        world.removeEntity(entityProcess);
    }
}
