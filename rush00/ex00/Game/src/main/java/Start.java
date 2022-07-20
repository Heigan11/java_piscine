
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import models.Game;
import models.Map;
import models.ModelsHandler;
import parsers.ParametersParser;
import parsers.PropertyParser;

import java.util.Properties;

public class Start {

    public static Game game = Game.getInstance();

    public static void main(String[] args) {

//        Game game = Game.getInstance();

        ParametersParser parametersParser = new ParametersParser();

        JCommander.
                newBuilder().
                addObject(parametersParser).
                build().
                parse(args);
        parametersParser.setParameters();
        PropertyParser.setProperties();

        ModelsHandler.getInstance().setModelsParameters();

        while (true) {
            game.getMap().printMap();
            game.gameOverCheck();
            game.playersMove();
            game.gameOverCheck();
        }



    }
}


// java -jar target/game.jar --enemiesCount=10 --wallsCount=10 --size=30 --profile=production