package models;

import com.diogonunes.jcolor.AnsiFormat;

public class Wall extends MapObject{

    private static char symbol;
    private static AnsiFormat color;

    public Wall(int x, int y) {
        super(x, y);
    }

    public static char getSymbol() {
        return symbol;
    }

    public static void setSymbol(char symbol) {
        Wall.symbol = symbol;
    }

    public static AnsiFormat getColor() {
        return color;
    }

    public static void setColor(AnsiFormat color) {
        Wall.color = color;
    }
}
