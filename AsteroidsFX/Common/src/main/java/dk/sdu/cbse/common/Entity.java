package dk.sdu.cbse.common;

import java.io.Serializable;
import java.util.UUID;

public class Entity implements Serializable {

    private final UUID ID = UUID.randomUUID();

    private float xCoordinate;
    private float yCoordinate;
    private float[] coordinates;
    private float rotationAngle;
    private float size;

    public String GetID(){
        return ID.toString();
    }

    public float[] getCoordinates() { return coordinates; }
    public void setCoordinates(float[] newCoordinates) { coordinates = newCoordinates; }
    public void setCoordinates(float xCoordinate, float yCoordinate) {coordinates = new float[]{xCoordinate, yCoordinate};}

    public float getRotationAngle() { return rotationAngle; }
    public void setRotationAngle(float rotationAngle) { this.rotationAngle = rotationAngle; }

    public float getSize() { return size; }
    public void setSize(float size) { this.size = size; }

    public float getXCoordinate() { return xCoordinate; }
    public float getYCoordinate() { return yCoordinate; }
    public void setXCoordinate(float xCoordinate) { this.xCoordinate = xCoordinate; }
    public void setYCoordinate(float yCoordinate) { this.yCoordinate = yCoordinate; }

}