import dk.sdu.cbse.bulletsystem.BulletSPI;
import dk.sdu.cbse.common.IEntityProcessing;
import dk.sdu.cbse.common.IPlugin;
import dk.sdu.cbse.entityprocess.PlayerController;
import dk.sdu.cbse.entityprocess.PlayerPlugin;

module Player {
    exports dk.sdu.cbse.entityprocess;
    requires Common;
    requires CommonBullet;

    uses BulletSPI;

    provides IPlugin with PlayerPlugin;
    provides IEntityProcessing with PlayerController;
}