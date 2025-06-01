package dk.sdu.cbse.commoncollision;

import dk.sdu.cbse.common.Entity;
import dk.sdu.cbse.common.GameData;
import dk.sdu.cbse.common.World;

public interface IEntityCollisionEvent {
    public void onCollision(GameData gameData, World world, Entity entity1, Entity entity2);
}
