package cleancode.minesweeper.tobe;

import cleancode.minesweeper.tobe.gameLevel.Advanced;
import cleancode.minesweeper.tobe.gameLevel.Beginner;
import cleancode.minesweeper.tobe.gameLevel.GameLevel;

public class GameApplication {

    public static void main(String[] args) {

        GameLevel gameLevel = new Beginner();
        MineSweeper mineSweeper = new MineSweeper(gameLevel);
        mineSweeper.run();
    }

}
