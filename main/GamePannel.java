package main;

import Inputs.KeyBoardInputs;
import entity.Player;
import entity.Skeleton;

import javax.swing.*;
import java.awt.*;


public class GamePannel extends JPanel {
    private KeyBoardInputs keyBoardInputs = new KeyBoardInputs();
    private Player player = new Player(this, keyBoardInputs);
    private Skeleton skeleton = new Skeleton(this);
    private Mappa mappa = new Mappa();
    private ImageIcon bg = new ImageIcon(getClass().getResource("/map/bg.png"));
    private double gravita = 4.1;

    //quadretti
    //private static final int ROWS = 600;
    //private static final int COLS = 600;
    //private static final int CELL_SIZE = 32;

    public GamePannel() {

        addKeyListener(keyBoardInputs); //input tastiera
        windowCorrectSize();

        setFocusable(true);
        requestFocusInWindow();

    }

    //set della finesta a dimensioni giuste
    public void windowCorrectSize(){
        Dimension size = new Dimension(800, 800);
        setPreferredSize(size);
    }

    public void update(){
        player.update(); //funzione dalla classe Player update.
        skeleton.update();
    }



    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        /*for (int row = 0; row <= ROWS; row++) {
            g.drawLine(0, row * CELL_SIZE, COLS * CELL_SIZE, row * CELL_SIZE);
        }
        for (int col = 0; col <= COLS; col++) {
            g.drawLine(col * CELL_SIZE, 0, col * CELL_SIZE, ROWS * CELL_SIZE);
        }*/

       g.drawImage(bg.getImage(), 0, -100, getWidth(), getHeight(), null);
        mappa.creazioneMappa(g);
        player.draw(g);
        skeleton.draw(g);
    }

}
