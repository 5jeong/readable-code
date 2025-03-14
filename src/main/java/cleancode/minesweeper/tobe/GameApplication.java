package cleancode.minesweeper.tobe;

import cleancode.minesweeper.tobe.minesweeper.MineSweeper;
import cleancode.minesweeper.tobe.minesweeper.config.GameConfig;
import cleancode.minesweeper.tobe.minesweeper.gameLevel.Advanced;
import cleancode.minesweeper.tobe.minesweeper.gameLevel.Beginner;
import cleancode.minesweeper.tobe.minesweeper.io.ConsoleInputHandler;
import cleancode.minesweeper.tobe.minesweeper.io.ConsoleOutputHandler;

public class GameApplication {

    public static void main(String[] args) {

        GameConfig gameConfig = new GameConfig(new Advanced(), new ConsoleInputHandler(), new ConsoleOutputHandler());

        MineSweeper mineSweeper = new MineSweeper(gameConfig);
        mineSweeper.initialize();
        mineSweeper.run();
    }
}
