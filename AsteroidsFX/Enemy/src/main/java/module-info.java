import dk.sdu.cbse.bulletsystem.BulletSPI;
import dk.sdu.cbse.common.IEntityProcessing;
import dk.sdu.cbse.common.IPlugin;
import dk.sdu.cbse.enemy.EnemyController;
import dk.sdu.cbse.enemy.EnemyPlugin;

module Enemy {
    requires Common;
    requires CommonBullet;

    uses BulletSPI;

    provides IPlugin with EnemyPlugin;
    provides IEntityProcessing with EnemyController;

}