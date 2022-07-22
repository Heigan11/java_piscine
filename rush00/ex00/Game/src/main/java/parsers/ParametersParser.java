package parsers;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import exceptions.IllegalParametersException;
import models.Game;

import java.io.FileNotFoundException;
import java.io.InputStream;

@Parameters(separators = "=")
public class ParametersParser {
    @Parameter(names = "--enemiesCount")
    private int enemiesCount;

    @Parameter(names = "--wallsCount")
    private int wallsCount;

    @Parameter(names = "--size")
    private int size;

    @Parameter(names = "--profile")
    private String profile;

    public static final int MAX_MAP_SIZE = 300;

    public void validateParametrs() throws IllegalParametersException, FileNotFoundException {
        if (enemiesCount <= 0 || wallsCount <= 0 || size <= 0){
            throw new IllegalParametersException("Parameters should be more then 0");
        }
        String path = "/application-" + profile + ".properties";
        InputStream input = Game.class.getResourceAsStream(path);
        if (input == null){
            throw new IllegalParametersException("Property file not found");
        }

        if (enemiesCount + wallsCount + 2 > size * size || size > MAX_MAP_SIZE){
            throw new IllegalParametersException("Map parameters is not valid");
        }
    }

    public void setParameters(){

        try {
            validateParametrs();
        } catch (IllegalParametersException | FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            System.exit(-1);
        }

        Game.getInstance().setEnemiesCount(enemiesCount);
        Game.getInstance().setWallsCount(wallsCount);
        Game.getInstance().setSize(size);
        Game.getInstance().setProfile(profile);
    }
}
