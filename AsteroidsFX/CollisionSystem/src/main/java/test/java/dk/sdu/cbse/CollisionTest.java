package test.java.dk.sdu.cbse;

import dk.sdu.cbse.collision.CollisionDetection;
import dk.sdu.cbse.common.Entity;
import dk.sdu.cbse.common.GameData;
import dk.sdu.cbse.common.World;
import org.junit.Assert;
import org.junit.Test;

import org.junit.Before;

public class CollisionTest {

    CollisionDetection collisionDetection = new CollisionDetection();

    private GameData gameData = new GameData();
    private World world = new World();

    private Entity firstEntity;
    private Entity secondEntity;

    @Before
    public void setUp() throws Exception {
        firstEntity = new Entity();

        firstEntity.setSize(5);

        secondEntity = new Entity();

        secondEntity.setSize(10);

        world.addEntity(firstEntity);
        world.addEntity(secondEntity);
    }

    @Test
    public void testTrueCollision() throws Exception {
        firstEntity.setXCoordinate(0);
        firstEntity.setYCoordinate(0);
        secondEntity.setXCoordinate(2.5);
        secondEntity.setYCoordinate(2.5);

        Assert.assertTrue(CollisionDetection.CheckCollision(gameData, world));
    }

    @Test
    public void testMove(){
        firstEntity.setXCoordinate(0);
        firstEntity.setYCoordinate(0);
        secondEntity.setXCoordinate(15);
        secondEntity.setYCoordinate(15);

        Assert.assertTrue(CollisionDetection.CheckCollision(gameData, world));
    }
}
