package models;

import com.diogonunes.jcolor.AnsiFormat;
import enaums.Button;

public class Player extends MapObject{

    private static char symbol;
    private static AnsiFormat color;

    public Player(int x, int y) {
        super(x, y);
    }

    public boolean isCanMove(int x, int y, char[][] map) {
        return Map.getSymbol(x, y, map) != Wall.getSymbol();
    }

    public boolean getTurn(Button button, char[][] map) {
        int dx;
        int dy;

        switch (button) {
            case LEFT:  dx = -1; dy = 0; break;
            case UP:    dx = 0; dy = -1; break;
            case RIGHT: dx = 1; dy = 0; break;
            case DOWN:  dx = 0; dy = 1; break;
            default:    dx = 0; dy = 0; break;
        }

        if (isCanMove(this.getX() + dx, this.getY() + dy, map)) {
            this.setX(this.getX() + dx);
            this.setY(this.getY() + dy);
            return true;
        }
        return false;
    }

    public boolean isNextMovePossible(int x, int y){
        return (Map.getSymbol(x, y, Game.getMap().getMap()) != Wall.getSymbol() && Map.getSymbol(x, y, Game.getMap().getMap()) != Enemy.getSymbol());
    }

    public boolean isCollision(MapObject mapObject){
        return this.getX() == mapObject.getX() && this.getY() == mapObject.getY();
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

