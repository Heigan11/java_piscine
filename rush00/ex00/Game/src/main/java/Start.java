
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import models.Game;
import parsers.ParametrsParser;
import parsers.PropertyParser;

import java.util.Properties;

public class Start {

    public static void main(String[] args) {

        ParametrsParser parametrsParser = new ParametrsParser();
        PropertyParser propertyParser = new PropertyParser();

        JCommander.
                newBuilder().
                addObject(parametrsParser).
                build().
                parse(args);
        parametrsParser.setParameters();
        propertyParser.setProperties();

        System.out.println(Game.getInstance());
    }
}


// java -jar target/game.jar --enemiesCount=10 --wallsCount=10 --size=30 --profile=production