import dk.sdu.cbse.asteroids.AsteroidPlugin;
import dk.sdu.cbse.asteroids.AsteroidSystem;
import dk.sdu.cbse.common.IEntityProcessing;
import dk.sdu.cbse.common.IPlugin;

module Asteroids {
    requires CommonAsteroid;
    requires Common;
    requires CommonCollision;

    provides IPlugin with AsteroidPlugin;
    provides IEntityProcessing with AsteroidSystem;
}