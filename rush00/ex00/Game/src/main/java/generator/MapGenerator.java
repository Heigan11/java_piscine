package generator;

import models.*;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

public class MapGenerator {
    private static char[][] map;
    private MapGenerator() {};

    private static void setMapObject(char symbol, int count){
        for (int i = 0; i < count; i++) {
            while (true) {
                int x = new Random().nextInt(Game.getSize());
                int y = new Random().nextInt(Game.getSize());
                if (map[y][x] == Empty.getSymbol()) {
                    map[y][x] = symbol;
                    if (symbol == Player.getSymbol()){
                        Game.getInstance().setPlayer(new Player(x, y));
                    }
                    if (symbol == Goal.getSymbol()){
                        Game.setGoal(new Goal(x, y));
                    }
                    if (symbol == Enemy.getSymbol()){
                        Game.setEnemy(new Enemy(x, y));
                    }
                    break;
                }
            }
        }
    }

    private static boolean isMapValid(){
        char [][] tmpMap = new char[map.length][];
        for(int i = 0; i < map.length; i++)
            tmpMap[i] = map[i].clone();

        Deque<Coordinates> queue = new LinkedList<>();

        queue.add(new Coordinates(Game.getInstance().getPlayer().getX(), Game.getInstance().getPlayer().getY()));

        while (queue.size() != 0) {
            Coordinates coordinates = queue.pollFirst();
            int x = coordinates.getX();
            int y = coordinates.getY();

            if (tmpMap[y][x] == Goal.getSymbol()) {
                return true;
            }

            if (tmpMap[y][x] == Wall.getSymbol()) {
                continue;
            }

            tmpMap[y][x] = Wall.getSymbol();

            if (Game.getInstance().getPlayer().isCanMove(x - 1, y, tmpMap)) {
                queue.add(new Coordinates(x - 1, y));
            }
            if (Game.getInstance().getPlayer().isCanMove(x + 1, y, tmpMap)) {
                queue.add(new Coordinates(x + 1, y));
            }
            if (Game.getInstance().getPlayer().isCanMove(x, y - 1, tmpMap)) {
                queue.add(new Coordinates(x, y - 1));
            }
            if (Game.getInstance().getPlayer().isCanMove(x, y + 1, tmpMap)) {
                queue.add(new Coordinates(x, y + 1));
            }
        }
        Game.refreshEnemiesList();
        return false;
    }

    public static char[][] getFilledMap(){
        map = new char[Game.getSize()][Game.getSize()];
        do {
            for (char[] row : map) {
                Arrays.fill(row, Empty.getSymbol());
            }
            setMapObject(Wall.getSymbol(), Game.getWallsCount());
            setMapObject(Enemy.getSymbol(), Game.getEnemiesCount());
            setMapObject(Player.getSymbol(), 1);
            setMapObject(Goal.getSymbol(), 1);
        } while (!isMapValid());

        return map;
    }
}
