import dk.sdu.cbse.BulletPlugin;
import dk.sdu.cbse.BulletSystem;
import dk.sdu.cbse.common.IEntityProcessing;
import dk.sdu.cbse.common.IPlugin;

module BulletSystem {
    requires Common;
    requires CommonBullet;

    provides IPlugin with BulletPlugin;
    provides IEntityProcessing with BulletSystem;
}