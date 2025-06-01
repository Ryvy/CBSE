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
        List<E> returnList = new ArrayList<>();

        List<Class<E>> ListToCheck = Arrays.stream(entityClass).toList();

        for (Entity entity : entities) {
            if(ListToCheck.contains(entity.getClass())) {
                returnList.add((E)entity);
            }
        }
        return returnList;
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }



}
