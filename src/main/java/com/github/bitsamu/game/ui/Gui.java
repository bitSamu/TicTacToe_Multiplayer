package com.github.bitsamu.game.ui;

import com.github.bitsamu.game.logic.windetector.WinDetector;
import com.github.bitsamu.game.logic.board.GameBoard;
import com.github.bitsamu.game.logic.sign.Sign;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Gui class
 * @author bitSamu
 * @version 1.0
 */
public class Gui extends JPanel {

    /**
     * gameboard which holds the sings
     */
    private GameBoard gameBoard;

    /**
     * Size of the Board
     */
    private final int BOARD_SIZE = 300;

    /**
     * Width of the line
     */
    private final int LINE_WIDTH = 10;

    /**
     * Size of a cell
     */
    private final int CELL_SIZE = BOARD_SIZE / 3 - 5;

    /**
     * Size of a image
     */
    private final int IMAGE_SIZE = 64;

    /**
     * Image path
     */
    private final String IMAGE_PATH = "src/main/resources/images/";

    /**
     * Cross image
     */
    private BufferedImage cross;

    /**
     * Circle image
     */
    private BufferedImage circle;

    /**
     * Windetector, which is added to the Gameboard
     */
    private WinDetector winDetector;

    /**
     * Detects click position
     */
    private ClickHandler clickHandler = new ClickHandler(this, BOARD_SIZE, LINE_WIDTH, BOARD_SIZE/3-(LINE_WIDTH/2));

    //Ctor
    public Gui() throws IOException {
        this.winDetector = new WinDetector();
        this.gameBoard = new GameBoard();
        this.gameBoard.addWinDetector(winDetector);

        setPreferredSize(new java.awt.Dimension(BOARD_SIZE, BOARD_SIZE));

        this.addMouseListener(clickHandler);

        loadImages();
    }

    /**
     * Loads the images from the given path
     * @throws IOException
     */
    public void loadImages() throws IOException {
        cross = ImageIO.read(new File(IMAGE_PATH + "cross.png"));
        circle = ImageIO.read(new File(IMAGE_PATH + "circle.png"));
    }

    @Override
    protected void paintComponent(Graphics g) {

        final Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);

        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, BOARD_SIZE, BOARD_SIZE);
        g2d.setColor(Color.BLACK);

        if(gameBoard.detectWin(Sign.CROSS)){
            System.out.println("Cross won");
            setupRestartPanel();
        }
        else if(gameBoard.detectWin(Sign.CIRCLE)){
            System.out.println("Circle won");
            setupRestartPanel();
        }

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

    public void startWinAnimation(){

    }

    private void setupRestartPanel() {
        JPanel restartPanel = new JPanel();
        restartPanel.setLayout(new FlowLayout());

        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //restartGame();
            }
        });
        restartPanel.add(restartButton);

        frame.getContentPane().add(restartPanel, BorderLayout.SOUTH);
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
        //System.out.println(gameBoard.getSign(column - 1, row - 1));
        repaint();
    }
    static JFrame frame = new JFrame("Tic Tac Toe");
    public static void main(String[] args) throws IOException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Gui());
        frame.pack();
        frame.setVisible(true);
    }
}