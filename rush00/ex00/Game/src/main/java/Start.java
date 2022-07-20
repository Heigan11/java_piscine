
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import models.Game;
import models.Map;
import models.ModelsHandler;
import parsers.ParametrsParser;
import parsers.PropertyParser;

import java.util.Properties;

public class Start {

    public static void main(String[] args) {

        ParametrsParser parametrsParser = new ParametrsParser();

        JCommander.
                newBuilder().
                addObject(parametrsParser).
                build().
                parse(args);
        parametrsParser.setParameters();
        PropertyParser.setProperties();

        System.out.println(Game.getInstance());

        ModelsHandler.getInstance().setModelsParameters();

        Game.getInstance().getMap().printMap();
    }
}


// java -jar target/game.jar --enemiesCount=10 --wallsCount=10 --size=30 --profile=production