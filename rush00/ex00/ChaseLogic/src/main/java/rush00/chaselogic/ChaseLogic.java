package rush00.chaselogic;

public class ChaseLogic {
    private static boolean isMoveValid(GameParameters gameParameters, int x, int y) {
        if (x < 0 || x >= gameParameters.getMapSize() || y < 0 || y >= gameParameters.getMapSize()) {
            return false;
        }
        if (gameParameters.getMap()[y][x] == gameParameters.getPlayersSymbol()){
            throw new GameOverException("You are caught! You lose...");
        }

        return gameParameters.getMap()[y][x] == gameParameters.getEmptySymbol();
    }

    private static int getDirection(int x1, int x2) {
        return Integer.compare(x2, x1);
    }

    public static Coordinates getEnemyMove(GameParameters gameParameters){
        int x = getDirection(gameParameters.getEnemyX(), gameParameters.getPlayerX());
        int y = getDirection(gameParameters.getEnemyY(), gameParameters.getPlayerY());

        if (x < y) {
            if (x != 0 && isMoveValid(gameParameters, gameParameters.getEnemyX() + x, gameParameters.getEnemyY())) {
                return new Coordinates(x, 0);
            }

            if (y != 0 && isMoveValid(gameParameters, gameParameters.getEnemyX(), gameParameters.getEnemyY() + y)) {
                return new Coordinates(0, y);
            }
        } else {
            if (y != 0 && isMoveValid(gameParameters, gameParameters.getEnemyX(), gameParameters.getEnemyY() + y)) {
                return new Coordinates(0, y);
            }

            if (x != 0 && isMoveValid(gameParameters, gameParameters.getEnemyX() + x, gameParameters.getEnemyY())) {
                return new Coordinates(x, 0);
            }
        }
        return new Coordinates(0,0);
    }
}
