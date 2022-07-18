package parsers;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import models.Game;

@Parameters(separators = "=")
public class ParametrsParser {
    @Parameter(names = "--enemiesCount")
    private int enemiesCount;

    @Parameter(names = "--wallsCount")
    private int wallsCount;

    @Parameter(names = "--size")
    private int size;

    @Parameter(names = "--profile")
    private String profile;

    public void setParameters(Game game){
        game.setEnemiesCount(enemiesCount);
        game.setWallsCount(wallsCount);
        game.setSize(size);
        game.setProfile(profile);
    }
}
