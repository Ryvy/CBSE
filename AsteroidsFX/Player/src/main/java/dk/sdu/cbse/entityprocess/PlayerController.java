package dk.sdu.cbse.entityprocess;

import dk.sdu.cbse.bulletsystem.BulletSPI;
import dk.sdu.cbse.common.*;

import java.util.ServiceLoader;

public class PlayerController implements IEntityProcessing {

    @Override
    public void process(GameData gameData, World world) {
        if(gameData.getInput().ispressed(Input.LEFT))
            PlayerPlugin.entityProcess.setRotationAngle(PlayerPlugin.entityProcess.getRotationAngle() - 3);
        if(gameData.getInput().ispressed(Input.RIGHT))
            PlayerPlugin.entityProcess.setRotationAngle(PlayerPlugin.entityProcess.getRotationAngle() + 3);
        if(gameData.getInput().ispressed(Input.UP)){
            double xChange = Math.cos(Math.toRadians(PlayerPlugin.entityProcess.getRotationAngle()));
            double yChange = Math.sin(Math.toRadians(PlayerPlugin.entityProcess.getRotationAngle()));
            PlayerPlugin.entityProcess.setXCoordinate(PlayerPlugin.entityProcess.getXCoordinate() + xChange);
            PlayerPlugin.entityProcess.setYCoordinate(PlayerPlugin.entityProcess.getYCoordinate() + yChange);
        }

        if(gameData.getInput().ispressed(Input.SPACE)){
            BulletSPI bulletSPI = GetBulletSPI();
            if(bulletSPI != null){
                Entity newBullet = bulletSPI.CreateBullet(PlayerPlugin.entityProcess, PlayerPlugin.entityProcess.getRotationAngle());
                world.addEntity(newBullet);
            }
        }
    }


    private BulletSPI GetBulletSPI() {
        return ServiceLoader.load(BulletSPI.class).findFirst().orElse(null);
    }
}
