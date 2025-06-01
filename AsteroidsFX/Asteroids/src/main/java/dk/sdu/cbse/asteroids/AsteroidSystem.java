package dk.sdu.cbse.asteroids;

import dk.sdu.cbse.common.*;
import dk.sdu.cbse.commonasteroid.Asteroid;
import dk.sdu.cbse.commonasteroid.AsteroidSPI;
import dk.sdu.cbse.commoncollision.IEntityCollisionEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ServiceLoader;

public class AsteroidSystem implements IEntityProcessing, AsteroidSPI {

    Random rnd = new Random();

    private List<IEntityCollisionEvent> entityCollisionEvents;

    @Override
    public void process(GameData gameData, World world) {

        if (world.getEntities(SplitAsteroid.class).isEmpty()){
            Entity Asteroid = createAsteroid(new double[]{0,0}, rnd.nextInt(90));
            world.addEntity(Asteroid);
            System.out.println("Asteroid created");
        }

        for(Entity asteroid : world.getEntities(SplitAsteroid.class)) {
            double xMovement = Math.cos(Math.toRadians(asteroid.getRotationAngle()));
            double yMovement = Math.sin(Math.toRadians(asteroid.getRotationAngle()));

            asteroid.setXCoordinate(asteroid.getXCoordinate() + xMovement);
            asteroid.setYCoordinate(asteroid.getYCoordinate() + yMovement);
        }
    }

    @Override
    public Entity createAsteroid(double[] coordinates, float rotation) {
        Entity asteroid = new SplitAsteroid();
        int size = 10;
        asteroid.setCoordinates(size, -size, -size, -size, -size, size, size, size);
        asteroid.setXCoordinate((coordinates[0]));
        asteroid.setYCoordinate((coordinates[1]));
        asteroid.setRotationAngle(rotation);
        asteroid.setSize(size);
        return asteroid;
    }
}
