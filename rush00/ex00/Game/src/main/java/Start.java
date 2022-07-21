import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import exceptions.IllegalParametersException;
import models.Game;
import models.ModelsHandler;
import parsers.ParametersParser;
import parsers.PropertyParser;

public class Start {

    public static Game game = Game.getInstance();

    public static void main(String[] args) {

        ParametersParser parametersParser = new ParametersParser();
        try {
        JCommander.
                newBuilder().
                addObject(parametersParser).
                build().
                parse(args);
        } catch (ParameterException ex){
            throw new IllegalParametersException("Not valid parameters");
        }

        parametersParser.setParameters();
        PropertyParser.setProperties();

        ModelsHandler.getInstance().setModelsParameters();

        while (true) {
            try {
                Game.getMap().printMap();
                game.gameOverCheck();
                game.playersMove();
                Game.getMap().printMap();
                game.gameOverCheck();
                game.enemiesMove();
            } catch (RuntimeException ex){
                System.out.println(ex.getMessage());
                System.exit(0);
            }
        }
    }
}


// java -jar target/game.jar --enemiesCount=10 --wallsCount=10 --size=30 --profile=production