package com.github.bitsamu.game.logic.board;

import com.github.bitsamu.game.logic.windetector.WinDetector;
import com.github.bitsamu.game.logic.sign.Sign;

/**
 * This class represents the Gameboard
 */
public class GameBoard {

    private WinDetector winDetector;
    public Sign[][] gameBoard = {
            {Sign.EMPTY, Sign.EMPTY, Sign.EMPTY},
            {Sign.EMPTY, Sign.EMPTY, Sign.EMPTY},
            {Sign.EMPTY, Sign.EMPTY, Sign.EMPTY}
    };

    public GameBoard(){}

    public void addWinDetector(WinDetector winDetector){
        this.winDetector = winDetector;
    }

    public boolean detectWin(Sign sign){
        return winDetector.detectWin(gameBoard, sign);
    }

    public Sign getSign(int x, int y){
        return gameBoard[x][y];
    }

    public void setGameBoard(int x, int y, Sign sign){
        gameBoard[x - 1][y - 1] = sign;
    }
}
