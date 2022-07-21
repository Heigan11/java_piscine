package rush00.chaselogic;

public class GameParameters {
    private char[][] map;
    private int playerX;
    private int playerY;
    private int EnemyX;
    private int EnemyY;
    private int mapSize;
    private char playersSymbol;
    private char emptySymbol;

    public GameParameters(char[][] map, int playerX, int playerY, int enemyX, int enemyY, int mapSize, char playersSymbol, char emptySymbol) {
        this.map = map;
        this.playerX = playerX;
        this.playerY = playerY;
        EnemyX = enemyX;
        EnemyY = enemyY;
        this.mapSize = mapSize;
        this.playersSymbol = playersSymbol;
        this.emptySymbol = emptySymbol;
    }

    public char[][] getMap() {
        return map;
    }

    public char getEmptySymbol() {
        return emptySymbol;
    }

    public int getPlayerX() {
        return playerX;
    }

    public char getPlayersSymbol() {
        return playersSymbol;
    }

    public int getPlayerY() {
        return playerY;
    }

    public int getEnemyX() {
        return EnemyX;
    }

    public int getEnemyY() {
        return EnemyY;
    }

    public int getMapSize() {
        return mapSize;
    }
}
