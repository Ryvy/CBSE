package dk.sdu.cbse;

import dk.sdu.cbse.bulletsystem.Bullet;
import dk.sdu.cbse.bulletsystem.BulletSPI;
import dk.sdu.cbse.common.Entity;

public class BulletSystem implements BulletSPI {



    @Override
    public Entity CreateBullet(float[] position, float rotation) {
        Bullet bullet = new Bullet();
        bullet.setCoordinates(0,2,1,1,2,0,1,-1,0,-2,-1,-1,-2,0,-1,1);
        return bullet;
    }
}
