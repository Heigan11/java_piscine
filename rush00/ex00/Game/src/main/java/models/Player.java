package models;

import com.diogonunes.jcolor.AnsiFormat;

public class Player extends MapObject{

    private static char symbol;
    private static AnsiFormat color;

    public Player(int x, int y) {
        super(x, y);
    }

    public boolean isCanMove(int x, int y, char[][] map) {
//        if (x < 0 || x >= Game.getSize() || y < 0 || y >= Game.getSize()) {
//            return false;
//        }
        return Map.getSymbol(x, y, map) != Wall.getSymbol();
    }

    public static char getSymbol() {
        return symbol;
    }

    public static void setSymbol(char symbol) {
        Player.symbol = symbol;
    }

    public static AnsiFormat getColor() {
        return color;
    }

    public static void setColor(AnsiFormat color) {
        Player.color = color;
    }
}

