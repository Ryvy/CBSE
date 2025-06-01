package dk.sdu.cbse.common;

import java.io.Serializable;
import java.util.UUID;

public class Entity implements Serializable {

    private final UUID ID = UUID.randomUUID();

    private double xCoordinate;
    private double yCoordinate;
    private double[] polygon;
    private float rotationAngle;
    private float size;

    public String GetID(){
        return ID.toString();
    }

    public double[] getCoordinates() { return polygon; }
    public void setCoordinates(double... polygonCoordinates) { this.polygon = polygonCoordinates; }

    public float getRotationAngle() { return rotationAngle; }
    public void setRotationAngle(float rotationAngle) { this.rotationAngle = rotationAngle; }

    public float getSize() { return size; }
    public void setSize(float size) { this.size = size; }

    public double getXCoordinate() { return xCoordinate; }
    public double getYCoordinate() { return yCoordinate; }
    public void setXCoordinate(double xCoordinate) { this.xCoordinate = xCoordinate; }
    public void setYCoordinate(double yCoordinate) { this.yCoordinate = yCoordinate; }

}