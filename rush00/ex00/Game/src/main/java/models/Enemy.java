package models;

import rush00.chaselogic.ChaseLogic;
import rush00.chaselogic.Coordinates;
import rush00.chaselogic.GameParameters;


import com.diogonunes.jcolor.AnsiFormat;

public class Enemy extends MapObject{

    private static char symbol;
    private static AnsiFormat color;

    public Enemy(int x, int y) {
        super(x, y);
    }

    public static char getSymbol() {
        return symbol;
    }

    public static void setSymbol(char symbol) {
        Enemy.symbol = symbol;
    }

    public static AnsiFormat getColor() {
        return color;
    }

    public static void setColor(AnsiFormat color) {
        Enemy.color = color;
    }

    public boolean getEnemyTurn(){
       GameParameters gameParameters = new GameParameters(
               Game.getMap().getMap(),
               Game.getPlayer().getX(),
               Game.getPlayer().getY(),
               this.getX(),
               this.getY(),
               Game.getSize(),
               Player.getSymbol(),
               Empty.getSymbol());

       Coordinates coordinates = ChaseLogic.getEnemyMove(gameParameters);

       this.setX(this.getX() + coordinates.getX());
       this.setY(this.getY() + coordinates.getY());

       return coordinates.getX() != 0 || coordinates.getY() != 0;
    }
}

