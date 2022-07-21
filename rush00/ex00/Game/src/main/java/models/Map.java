package models;

import com.diogonunes.jcdp.color.api.Ansi;
import com.diogonunes.jcolor.AnsiFormat;
import com.diogonunes.jcolor.Command;
import generator.MapGenerator;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.BACK_COLOR;
import static com.diogonunes.jcolor.Attribute.NONE;

public class Map {

    private char[][] map;
    private int width;
    private int height;

    public Map() {
        this.width = Game.getSize();
        this.height = Game.getSize();
        this.map = MapGenerator.getFilledMap();
    }

    public char[][] getMap() {
        return map;
    }

    public char getSymbol(int x, int y){
        if (x < 0 || x >= width || y < 0 || y >= height) {
            return Wall.getSymbol();
        }
        return this.map[y][x];
    }

    public static char getSymbol(int x, int y, char[][] map){
        if (x < 0 || x >= Game.getSize() || y < 0 || y >= Game.getSize()) {
            return Wall.getSymbol();
        }
        return map[y][x];
    }

    public void setSymbol(int x, int y, char symbol){
        map[y][x] = symbol;
    }

    public void printMap() {

        if (!Game.getProfile().equals("dev")) {
            System.out.print(colorize(Command.CLEAR_SCREEN()));
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (this.map[y][x] == Empty.getSymbol()) {
                    System.out.print(colorize(" " + Empty.getSymbol() + " ", Empty.getColor()));
                } else if (this.map[y][x] == Wall.getSymbol()) {
                    System.out.print(colorize(" " + Wall.getSymbol() + " ", Wall.getColor()));
                } else if (this.map[y][x] == Enemy.getSymbol()) {
                    System.out.print(colorize(" " + Enemy.getSymbol() + " ", Enemy.getColor()));
                } else if (this.map[y][x] == Player.getSymbol()) {
                    System.out.print(colorize(" " + Player.getSymbol() + " ", Player.getColor()));
                } else {
                    System.out.print(colorize(" " + Goal.getSymbol() + " ", Goal.getColor()));
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
