package com.github.bitsamu.game.logic.windetector;

import com.github.bitsamu.game.logic.sign.Sign;

public interface WinDetec {
    /**
     * detect a win
     * @param gameBoard Current signs on the gameboard
     * @param sign the sign, which windetector is detecting
     * @return true if the game is won
     */
    boolean detectWin(Sign[][] gameBoard, Sign sign);

    /**
     *
     * detect a horizontal win
     * @param gameBoard Current signs on the gameboard
     * @param sign the sign, which windetector is detecting
     * @return true if the game is won
     */
    boolean detectHorizontalWin(Sign[][] gameBoard, Sign sign);

    /**
     * detect a vertical win
     * @param gameBoard Current signs on the gameboard
     * @param sign the sign, which windetector is detecting
     * @return true if the game is won
     */
    boolean detectVerticalWin(Sign[][] gameBoard, Sign sign);

    /**
     * detect a diagonal win
     * @param gameBoard Current signs on the gameboard
     * @param sign the sign, which windetector is detecting
     * @return true if the game is won
     */
    boolean detectDiagonalWin(Sign[][] gameBoard, Sign sign);
}
