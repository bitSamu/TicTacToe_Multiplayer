package com.github.bitsamu.game.logic;

import com.github.bitsamu.game.logic.sign.Sign;

public class TestDriver {
    public static void main(String[] args) {
        TicTacToe test = new TicTacToe();
        test.detectWin(Sign.EMPTY);
    }
}
