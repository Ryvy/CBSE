import dk.sdu.cbse.AsteroidPlugin;
import dk.sdu.cbse.AsteroidSystem;
import dk.sdu.cbse.common.IEntityProcessing;
import dk.sdu.cbse.common.IPlugin;

module Asteroids {
    requires CommonAsteroid;
    requires Common;
    requires CommonCollision;
    exports dk.sdu.cbse.entityprocess;

    provides IPlugin with AsteroidPlugin;
    provides IEntityProcessing with AsteroidSystem;
}