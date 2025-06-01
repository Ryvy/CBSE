package dk.sdu.cbse.common;

public interface IPlugin {
    void start(GameData gameData, World world);
    void stop(GameData gameData, World world);
}
