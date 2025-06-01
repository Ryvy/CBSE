package dk.sdu.cbse.common;

public class Input {
    private static final int keyNum = 4;

    private static boolean[] keys = new boolean[keyNum];
    private static boolean[] pressedKeys = new boolean[keyNum];

    public static final int UP = 0;
    public static final int LEFT = 1;
    public static final int RIGHT = 2;
    public static final int SPACE = 3;

    public void update(){
        for (int i = 0; i < keyNum; i++) {
            pressedKeys[i] = keys[i];
        }
    }

    public void setkey(int key, boolean ispressed){
        keys[key] = ispressed;
    }

    public boolean ispressed(int key){
        return keys[key];
    }

    public boolean OnKeyDown(int key){
        return keys[key] && !pressedKeys[key];
    }
}
