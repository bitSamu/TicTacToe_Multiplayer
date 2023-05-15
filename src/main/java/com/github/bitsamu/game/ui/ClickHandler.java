package com.github.bitsamu.game.ui;

import com.github.bitsamu.game.logic.sign.Sign;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClickHandler extends MouseAdapter {

    private Gui gui;
    private final int BOARDSIZE;
    private final int LINEWIDTH;
    private final int FIELDWIDTH;

    private int counter = 0;

    public ClickHandler(Gui gui, int boardSize, int lineWidth, int fieldWidth){
        this.gui = gui;
        this.BOARDSIZE = boardSize;
        this.LINEWIDTH = lineWidth;
        this.FIELDWIDTH = fieldWidth;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        Sign sign = null;

        if(counter % 2 == 0){
            sign = Sign.CROSS;
        }
        else {
            sign = Sign.CIRCLE;
        }
        gui.update(getColRow(x), getColRow(y), sign);

        counter++;
    }

    public int detectClickedField(int x, int y){
        int clickedColumn;
        int clickedRow;

        int clickedField;

        clickedColumn = getColRow(x);
        clickedRow = getColRow(y);

        if(clickedColumn == 0 || clickedRow == 0){
            return 0;
        }

        //System.out.println("Test" + clickedColumn + " " + clickedRow);

        clickedField = clickedColumn + ((clickedRow - 1) * 3);

        return clickedField;
    }

    private int getColRow(int num){
        if (num < FIELDWIDTH){
            return  1;
        }
        else if (num > FIELDWIDTH + LINEWIDTH && num < FIELDWIDTH * 2 + (LINEWIDTH/2)) {
            return 2;
        }
        else if (num > FIELDWIDTH * 2 + (LINEWIDTH/2) + LINEWIDTH && num < FIELDWIDTH * 3 + LINEWIDTH * 2) {
            return 3;
        }

        return 0;
    }
}
