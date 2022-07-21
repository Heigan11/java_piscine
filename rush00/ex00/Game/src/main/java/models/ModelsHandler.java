package models;

import com.diogonunes.jcdp.color.api.Ansi;
import com.diogonunes.jcolor.AnsiFormat;
import exceptions.IllegalParametersException;

import static com.diogonunes.jcolor.Attribute.BACK_COLOR;
import static com.diogonunes.jcolor.Attribute.NONE;

public class ModelsHandler {
    private static ModelsHandler instance;

    public static ModelsHandler getInstance(){
        if (instance == null) {
            instance = new ModelsHandler();
        }
        return instance;
    }

    public void setModelsParameters(){
        try {
            Empty.setSymbol(Game.getProperties().getProperty("empty.char").charAt(0));
            Empty.setColor(new AnsiFormat(NONE(), BACK_COLOR(Ansi.BColor.valueOf(Game.getProperties().getProperty("empty.color")).ordinal()), NONE()));
            Wall.setSymbol(Game.getProperties().getProperty("wall.char").charAt(0));
            Wall.setColor(new AnsiFormat(NONE(), BACK_COLOR(Ansi.BColor.valueOf(Game.getProperties().getProperty("wall.color")).ordinal()), NONE()));
            Enemy.setSymbol(Game.getProperties().getProperty("enemy.char").charAt(0));
            Enemy.setColor(new AnsiFormat(NONE(), BACK_COLOR(Ansi.BColor.valueOf(Game.getProperties().getProperty("enemy.color")).ordinal()), NONE()));
            Player.setSymbol(Game.getProperties().getProperty("player.char").charAt(0));
            Player.setColor(new AnsiFormat(NONE(), BACK_COLOR(Ansi.BColor.valueOf(Game.getProperties().getProperty("player.color")).ordinal()), NONE()));
            Goal.setSymbol(Game.getProperties().getProperty("goal.char").charAt(0));
            Goal.setColor(new AnsiFormat(NONE(), BACK_COLOR(Ansi.BColor.valueOf(Game.getProperties().getProperty("goal.color")).ordinal()), NONE()));
        } catch (Exception e){
            throw new IllegalParametersException("Property file not valid");
        }
        Map map = new Map();
        Game.getInstance().setMap(map);
    }
}
