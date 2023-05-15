package com.github.bitsamu.game.logic;

import com.github.bitsamu.game.logic.board.GameBoard;
import com.github.bitsamu.game.logic.sign.Sign;

public class TicTacToe {

    private GameBoard gameBoard;

    public TicTacToe(){
        this.gameBoard = new GameBoard();
    }

    public boolean detectWin(Sign sign){
        int counter = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){

                if(gameBoard.getSign(i, j) == sign){
                   counter++;
                }
            }
            if(counter == 3){
                return true;
            }
            counter = 0;
        }
        return false;
    }

}
