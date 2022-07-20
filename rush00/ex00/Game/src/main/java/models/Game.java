package models;

import java.util.Properties;

public class Game {

    private static Game instance;

    private static Properties properties;
    private static int enemiesCount;
    private static int wallsCount;
    private static int size;
    private static String profile;
    private Map map;
    private Player player;

    private Game() {}

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public static Game getInstance(){
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public static Properties getProperties() {
        return properties;
    }

    public static int getEnemiesCount() {
        return enemiesCount;
    }

    public void setEnemiesCount(int enemiesCount) {
        this.enemiesCount = enemiesCount;
    }

    public static int getWallsCount() {
        return wallsCount;
    }

    public void setWallsCount(int wallsCount) {
        this.wallsCount = wallsCount;
    }

    public static int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static String getProfile() {
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
