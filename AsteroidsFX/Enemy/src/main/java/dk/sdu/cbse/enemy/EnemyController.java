package dk.sdu.cbse.enemy;

import dk.sdu.cbse.bulletsystem.BulletSPI;
import dk.sdu.cbse.common.Entity;
import dk.sdu.cbse.common.GameData;
import dk.sdu.cbse.common.IEntityProcessing;
import dk.sdu.cbse.common.World;

import java.util.Random;
import java.util.ServiceLoader;

import static dk.sdu.cbse.enemy.EnemyPlugin.enemy;

public class EnemyController implements IEntityProcessing {

    Random rnd = new Random();

    @Override
    public void process(GameData gameData, World world) {
        if(!world.getEntities(Enemy.class).isEmpty()){
            if(rnd.nextInt(10) > 2) {
                enemy.setRotationAngle(enemy.getRotationAngle() - 3);
            }
            if(rnd.nextInt(12) > 5) {
                enemy.setRotationAngle(enemy.getRotationAngle() + 3);
            }
            if(rnd.nextInt(10) > 7) {
                double xChange = Math.cos(Math.toRadians(enemy.getRotationAngle()));
                double yChange = Math.sin(Math.toRadians(enemy.getRotationAngle()));
                enemy.setXCoordinate(enemy.getXCoordinate() + xChange);
                enemy.setYCoordinate(enemy.getYCoordinate() + yChange);
            }
            if(rnd.nextInt(100) > 95) {
                BulletSPI bulletSPI = GetBulletSPI();
                if(bulletSPI != null){
                    Entity newBullet = bulletSPI.CreateBullet(enemy, enemy.getRotationAngle());
                    world.addEntity(newBullet);
                }
            }
        }
    }

    private BulletSPI GetBulletSPI() {
        return ServiceLoader.load(BulletSPI.class).findFirst().orElse(null);
    }
}
