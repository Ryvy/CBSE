package dk.sdu.cbse;

import dk.sdu.cbse.bulletsystem.Bullet;
import dk.sdu.cbse.bulletsystem.BulletSPI;
import dk.sdu.cbse.common.Entity;
import dk.sdu.cbse.common.GameData;
import dk.sdu.cbse.common.IEntityProcessing;
import dk.sdu.cbse.common.World;

public class BulletSystem implements BulletSPI, IEntityProcessing {



    @Override
    public Entity CreateBullet(double[] position, double rotation) {
        Bullet bullet = new Bullet();
        bullet.setCoordinates(0,2,1,1,2,0,1,-1,0,-2,-1,-1,-2,0,-1,1);
        return bullet;
    }

    @Override
    public void process(GameData gameData, World world) {
        for(Bullet bullet : world.getEntities(Bullet.class)){
            double xChange = Math.cos(Math.toRadians(bullet.getRotationAngle()));
            double yChange = Math.sin(Math.toRadians(bullet.getRotationAngle()));
            bullet.setXCoordinate(bullet.getXCoordinate() + xChange);
            bullet.setYCoordinate(bullet.getYCoordinate() + yChange);
        }
    }
}
