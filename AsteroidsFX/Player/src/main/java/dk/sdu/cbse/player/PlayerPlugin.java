package dk.sdu.cbse.player;

import dk.sdu.cbse.common.GameData;
import dk.sdu.cbse.common.IPlugin;
import dk.sdu.cbse.common.World;

public class PlayerPlugin implements IPlugin {
    protected static Player player;


    @Override
    public void start(GameData gameData, World world) {
        player = new Player();
    }

    @Override
    public void stop(GameData gameData, World world) {

    }
}
