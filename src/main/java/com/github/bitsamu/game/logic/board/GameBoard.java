package com.github.bitsamu.game.logic.board;

import com.github.bitsamu.game.logic.sign.Sign;

import java.util.HashMap;
import java.util.Map;

public class GameBoard {
    private Sign[][] gameBoard = {
            {Sign.EMPTY, Sign.EMPTY, Sign.EMPTY},
            {Sign.EMPTY, Sign.EMPTY, Sign.EMPTY},
            {Sign.EMPTY, Sign.EMPTY, Sign.EMPTY}
    };

    public GameBoard(){
    }

    public Sign getSign(int x, int y){
        return gameBoard[x][y];
    }

    public void setGameBoard(int x, int y, Sign sign){
        System.out.println(x + " " +y);
        gameBoard[x - 1][y - 1] = sign;
    }
}
