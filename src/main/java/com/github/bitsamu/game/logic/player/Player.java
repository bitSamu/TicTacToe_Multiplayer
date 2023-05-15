package com.github.bitsamu.game.logic.player;

import com.github.bitsamu.game.logic.sign.Sign;

public class Player {
    private String name;

    private final Sign sign;


    public Player(String name, Sign sign){
        this.name = name;
        this.sign = sign;
    }

}
