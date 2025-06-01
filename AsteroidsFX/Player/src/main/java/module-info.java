import dk.sdu.cbse.bulletsystem.BulletSPI;
import dk.sdu.cbse.common.IEntityPostProcessing;
import dk.sdu.cbse.common.IEntityProcessing;
import dk.sdu.cbse.common.IPlugin;
import dk.sdu.cbse.player.Player;
import dk.sdu.cbse.player.PlayerController;
import dk.sdu.cbse.player.PlayerPlugin;

module Player {
    exports dk.sdu.cbse.player;
    requires Common;
    requires CommonBullet;

    uses BulletSPI;

    provides IPlugin with PlayerPlugin;
    provides IEntityProcessing with PlayerController;
}