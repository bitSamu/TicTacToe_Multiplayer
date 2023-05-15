package com.github.bitsamu.game.ui;

import com.github.bitsamu.game.logic.WinDetector;
import com.github.bitsamu.game.logic.board.GameBoard;
import com.github.bitsamu.game.logic.sign.Sign;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gui extends JPanel {

    private GameBoard gameBoard;

    private final long serialVersionUID = 1L;
    private final int BOARD_SIZE = 300;
    private final int LINE_WIDTH = 10;
    private final int CELL_SIZE = BOARD_SIZE / 3 - 5;
    private final int IMAGE_SIZE = 64;

    private BufferedImage cross;
    private BufferedImage circle;

    private WinDetector winDetector;

    private ClickHandler clickHandler = new ClickHandler(this, BOARD_SIZE, LINE_WIDTH, BOARD_SIZE/3-(LINE_WIDTH/2));

    public Gui() throws IOException {
        this.gameBoard = new GameBoard();
        setPreferredSize(new java.awt.Dimension(BOARD_SIZE, BOARD_SIZE));
        this.addMouseListener(clickHandler);
        this.winDetector = new WinDetector();
        loadImages();
    }

    public void loadImages() throws IOException {
        cross = ImageIO.read(new File("C:\\Users\\Samuel\\Desktop\\TicTacToe_Multiplayer\\src\\main\\resources\\images\\cross.png"));
        circle = ImageIO.read(new File("C:\\Users\\Samuel\\Desktop\\TicTacToe_Multiplayer\\src\\main\\resources\\images\\circle.png"));
    }

    @Override
    protected void paintComponent(Graphics g) {
        if(winDetector.detectWin(Sign.CROSS)){
            System.out.println("Win");
        }

        final Graphics2D g2d = (Graphics2D) g;

        super.paintComponent(g2d);

        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, BOARD_SIZE, BOARD_SIZE);
        g2d.setColor(Color.BLACK);

        for(int i = 0; i < 3; i++){

            // Vertical lines
            g2d.fillRect(i * CELL_SIZE - LINE_WIDTH / 2, 0, LINE_WIDTH, BOARD_SIZE);
            // Horizontal lines
            g2d.fillRect(0, i * CELL_SIZE - LINE_WIDTH / 2, BOARD_SIZE, LINE_WIDTH);

            for(int j = 0; j < 3; j++){
                drawSign(g2d, i , j, gameBoard.getSign(i, j));
            }
        }
    }

    private void drawSign(Graphics2D g2d, int column, int row, Sign sign){
        BufferedImage image = null;

        if(sign == Sign.EMPTY){
            return;
        }
        else if(sign == Sign.CROSS){
            image = cross;

        }
        else if(sign == Sign.CIRCLE){
            image = circle;
        }

        g2d.drawImage(image, (CELL_SIZE-IMAGE_SIZE)/2 + (CELL_SIZE + LINE_WIDTH / 2) * (column), (CELL_SIZE-IMAGE_SIZE)/2 + (CELL_SIZE + LINE_WIDTH / 2) * (row), null);
    }

    public void update(int column, int row, Sign sign) {
        gameBoard.setGameBoard(column, row, sign);
        repaint();
    }

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Gui());
        frame.pack();
        frame.setVisible(true);
    }
}