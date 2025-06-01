package dk.sdu.cbse.common;

public class GameData {

    private final Input input = new Input();

    private int width = 800;
    private int height = 800;

    public void setWidth(int width) { this.width = width; }
    public void setHeight(int height) { this.height = height; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public Input getInput() { return input; }

}
