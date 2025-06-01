package dk.sdu.cbse.common;

import java.util.ArrayList;
import java.util.List;

public class World {

    private final List<Entity> entities = new ArrayList<Entity>();

    public List<Entity> getEntities() {
        return entities;
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }



}
