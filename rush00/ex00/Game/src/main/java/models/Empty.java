package models;

import com.diogonunes.jcolor.AnsiFormat;

public class Empty extends MapObject{

    private static char symbol;
    private static AnsiFormat color;

    public Empty(int x, int y) {
        super(x, y);
    }

    public static char getSymbol() {
        return symbol;
    }

    public static void setSymbol(char symbol) {
        Empty.symbol = symbol;
    }

    public static AnsiFormat getColor() {
        return color;
    }

    public static void setColor(AnsiFormat color) {
        Empty.color = color;
    }
}

