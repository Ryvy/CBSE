package dk.sdu.cbse.player;

import dk.sdu.cbse.bulletsystem.BulletSPI;
import dk.sdu.cbse.common.*;

import java.util.ServiceLoader;

import static dk.sdu.cbse.player.PlayerPlugin.player;

public class PlayerController implements IEntityProcessing {

    @Override
    public void process(GameData gameData, World world) {
        if(gameData.getInput().ispressed(Input.LEFT))
            player.setRotationAngle(player.getRotationAngle() - 3);
        if(gameData.getInput().ispressed(Input.RIGHT))
            player.setRotationAngle(player.getRotationAngle() + 3);
        if(gameData.getInput().ispressed(Input.UP)){
            double xChange = Math.cos(Math.toRadians(player.getRotationAngle()));
            double yChange = Math.sin(Math.toRadians(player.getRotationAngle()));
            player.setXCoordinate(player.getXCoordinate() + xChange);
            player.setYCoordinate(player.getYCoordinate() + yChange);
        }

        if(gameData.getInput().ispressed(Input.SPACE)){
            BulletSPI bulletSPI = GetBulletSPI();
            if(bulletSPI != null){
                Entity newBullet = bulletSPI.CreateBullet(player, player.getRotationAngle());
                world.addEntity(newBullet);
            }
        }
    }


    private BulletSPI GetBulletSPI() {
        return ServiceLoader.load(BulletSPI.class).findFirst().orElse(null);
    }
}
