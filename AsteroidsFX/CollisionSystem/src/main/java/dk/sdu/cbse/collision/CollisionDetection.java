package dk.sdu.cbse.collision;

import dk.sdu.cbse.common.Entity;
import dk.sdu.cbse.common.GameData;
import dk.sdu.cbse.common.IEntityPostProcessing;
import dk.sdu.cbse.common.World;

public class CollisionDetection implements IEntityPostProcessing {

    public boolean CheckCollision(Entity e1, Entity e2) {
        double xDifference = e1.getXCoordinate() - e2.getXCoordinate();
        double yDifference = e1.getYCoordinate() - e2.getYCoordinate();
        double distance = Math.sqrt(xDifference * xDifference + yDifference * yDifference);
        return distance < (e1.getSize() + e2.getSize());
    }

    @Override
    public void process(GameData gameData, World world) {
        for(Entity firstEntity : world.getEntities()) {
            for(Entity secondEntity : world.getEntities()) {
                if(firstEntity.equals(secondEntity)) {
                    continue;
                }
                if(CheckCollision(firstEntity, secondEntity)) {
                    
                    //Remove entities
                    world.removeEntity(firstEntity);
                    world.removeEntity(secondEntity);
                }
            }
        }
    }
}
