package dk.sdu.cbse.bulletsystem;

import dk.sdu.cbse.common.Entity;

public interface BulletSPI {
    Entity CreateBullet(double[] position, double rotation);
}
