package com.github.bitsamu.game.logic.windetector;

import com.github.bitsamu.game.logic.board.GameBoard;
import com.github.bitsamu.game.logic.sign.Sign;

public class WinDetector implements WinDetec{
    private GameBoard gameBoard;

    public WinDetector(){
        this.gameBoard = new GameBoard();
    }

    @Override
    public boolean detectWin(Sign[][] gameBoard, Sign sign){
        if(detectHorizontalWin(gameBoard, sign) || detectVerticalWin(gameBoard, sign) || detectDiagonalWin(gameBoard, sign)){
            return true;
        }
        return false;
    }

    @Override
    public boolean detectHorizontalWin(Sign[][] gameBoard, Sign sign) {
        int i = 0;
        int j = 0;

        for(; i < gameBoard.length; i++){
            if(gameBoard[j][i] == sign && gameBoard[j + 1][i] == sign && gameBoard[j + 2][i] == sign){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean detectVerticalWin(Sign[][] gameBoard, Sign sign) {
        int i = 0;
        int j = 0;

        for(; i < gameBoard.length; i++){
            if(gameBoard[i][j] == sign && gameBoard[i][j + 1] == sign && gameBoard[i][j + 2] == sign){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean detectDiagonalWin(Sign[][] gameBoard, Sign sign) {
        int i = 0;
        int j = 0;


        if(gameBoard[i][j] == sign && gameBoard[i + 1][j + 1] == sign && gameBoard[i + 2][j + 2] == sign || gameBoard[i + 2][j] == sign && gameBoard[i + 1][j + 1] == sign && gameBoard[i][j + 2] == sign){
            return true;
        }

        return false;
    }
}
