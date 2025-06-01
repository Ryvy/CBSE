package dk.sdu.cbse.commonasteroid;

import dk.sdu.cbse.common.Entity;

public interface AsteroidSPI {
    Entity createAsteroid(double[] coordinates, float rotation);
}
