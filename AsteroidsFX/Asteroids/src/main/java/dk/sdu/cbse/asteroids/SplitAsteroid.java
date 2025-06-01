package dk.sdu.cbse.asteroids;

import dk.sdu.cbse.commonasteroid.Asteroid;

public class SplitAsteroid extends Asteroid {

    private int splitsLeft = 1;

    public int getHealth() {
        return splitsLeft;
    }

    public void setHealth(int health) {
        this.splitsLeft = health;
    }
}
