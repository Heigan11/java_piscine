package models;

import enaums.Button;
import exceptions.GameOverException;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Game {

    private static Game instance;

    private static Properties properties;
    private static int enemiesCount;
    private static int wallsCount;
    private static int size;
    private static String profile;
    private static Map map;
    private static Player player;
    private static Goal goal;
    private static List<Enemy> enemies = new ArrayList<>();

    private Game() {}

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public static void setEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    public static Goal getGoal() {
        return goal;
    }

    public static void setGoal(Goal goal) {
        Game.goal = goal;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public static Map getMap() {
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

    private static Button getPushedButton(){
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()){
            char symbol = scanner.next().charAt(0);
            return Button.getButtonBySymbol(symbol);
        }
        return Button.UNKNOWN;
    }

    public boolean getPlayerTurn(Button button){
        if (button == Button.GIVE_UP){
            throw new GameOverException("You are gave up!");
        }
        if (button == Button.CONFIRM || button == Button.UNKNOWN) {
            return false;
        }
        return player.getTurn(button, map.getMap());
    }

    public void playersMove() {
        System.out.println("press: A to LEFT, W to UPWARD, D to RIGHT, S to DOWNWARD: ");
        Button button;
        int oldX = player.getX();
        int oldY = player.getY();
        while (true) {
            button = getPushedButton();
            if (getPlayerTurn(button)) {
                map.setSymbol(player.getX(), player.getY(), Player.getSymbol());
                map.setSymbol(oldX, oldY, Empty.getSymbol());
                break;
            }
        }
        System.out.println("Pushed button = " + button.getSymbol());

    }

    private void nextMovePossibleCheck() {
        int x = player.getX();
        int y = player.getY();
        if (!(player.isNextMovePossible(x - 1, y) || player.isNextMovePossible(x + 1, y) ||
                player.isNextMovePossible(x, y - 1) || player.isNextMovePossible(x, y + 1))) {
            throw new GameOverException("Do not any possible moves");
        }
    }

    public void gameOverCheck() {
        nextMovePossibleCheck();

        if (player.isCollision(goal)) {
//            game.playerWon = true;
            throw new GameOverException("You won!");
        }

        for (Enemy enemy : this.getEnemies()) {
            if (player.isCollision(enemy)) {
                throw new GameOverException("You lose...");
            }
        }
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
