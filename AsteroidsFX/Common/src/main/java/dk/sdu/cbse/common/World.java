package dk.sdu.cbse.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class World {

    private final List<Entity> entities = new ArrayList<Entity>();

    public List<Entity> getEntities() {
        return entities;
    }

    public <E extends Entity> List<E> getEntities(Class<E>... entityClass) {
        List<E> r = new ArrayList<>();

        List<Class<E>> t = Arrays.stream(entityClass).toList();

        for (Entity entity : entities) {
            if(t.contains(entity.getClass())) {
                r.add((E)entity);
            }
        }
        return r;
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }



}
