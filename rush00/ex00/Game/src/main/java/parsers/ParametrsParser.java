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

    public void setParameters(){
        Game.getInstance().setEnemiesCount(enemiesCount);
        Game.getInstance().setWallsCount(wallsCount);
        Game.getInstance().setSize(size);
        Game.getInstance().setProfile(profile);
    }
}
