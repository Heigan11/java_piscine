package models;

import com.diogonunes.jcolor.AnsiFormat;

public class Goal extends MapObject{

    private static char symbol;
    private static AnsiFormat color;

    public Goal(int x, int y) {
        super(x, y);
    }

    public static char getSymbol() {
        return symbol;
    }

    public static void setSymbol(char symbol) {
        Goal.symbol = symbol;
    }

    public static AnsiFormat getColor() {
        return color;
    }

    public static void setColor(AnsiFormat color) {
        Goal.color = color;
    }
}

