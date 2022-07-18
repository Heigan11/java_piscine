
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import models.Game;
import parsers.ParametrsParser;

import java.util.Properties;

public class Start {

    public static Game game = new Game();

    public static void main(String[] args) {

        ParametrsParser parametrsParser = new ParametrsParser();

        JCommander.
                newBuilder().
                addObject(parametrsParser).
                build().
                parse(args);
        parametrsParser.setParameters(game);



        System.out.println(game);
    }
}


// java -jar target/game.jar --enemiesCount=10 --wallsCount=10 --size=30 --profile=production