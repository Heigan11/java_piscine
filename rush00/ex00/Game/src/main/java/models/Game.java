package models;

import java.util.Properties;

public class Game {

    private static Game instance;

    private Properties properties;
    private int enemiesCount;
    private int wallsCount;
    private int size;
    private String profile;

    private Game() {}

    public static Game getInstance(){
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public Properties getProperties() {
        return properties;
    }

    public int getEnemiesCount() {
        return enemiesCount;
    }

    public void setEnemiesCount(int enemiesCount) {
        this.enemiesCount = enemiesCount;
    }

    public int getWallsCount() {
        return wallsCount;
    }

    public void setWallsCount(int wallsCount) {
        this.wallsCount = wallsCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Game{" +
                "properties=" + properties +
                ", enemiesCount=" + enemiesCount +
                ", wallsCount=" + wallsCount +
                ", size=" + size +
                ", profile='" + profile + '\'' +
                '}';
    }
}
