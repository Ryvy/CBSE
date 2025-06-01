package dk.sdu.cbse.common;

public class Input {
    private static final int keyNum = 4;

    private static boolean[] keys = new boolean[keyNum];
    private static boolean[] pressedKeys = new boolean[keyNum];

    public static int up = 0;
    public static int left = 1;
    public static int right = 2;
    public static int space = 3;

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
