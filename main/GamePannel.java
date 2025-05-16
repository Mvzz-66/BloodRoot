package main;

import Inputs.KeyBoardInputs;
import Inputs.MouseInputs;
import entity.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;


public class GamePannel extends JPanel {
    private MouseInputs mouseInputs;
    private KeyBoardInputs keyBoardInputs = new KeyBoardInputs();
    private double gravity = 2.1;
    ImageIcon img = new ImageIcon();
    Player player = new Player(this, keyBoardInputs);

    public GamePannel() {
        mouseInputs = new MouseInputs();


        addKeyListener(keyBoardInputs); //input tastiera
        addMouseListener(mouseInputs); //input del mouse
        windowCorrectSize();

        this.setFocusable(true);
        requestFocusInWindow();

    }

    //set della finesta a dimensioni giuste
    public void windowCorrectSize(){
        Dimension size = new Dimension(1920, 1080);
        setPreferredSize(size);
    }

    //gravita del gioco;
    public boolean gravita(){
        if(player.y <= 510) {
            player.y += gravity;
            return true;
        }

        return false;
    }

    //metodi per spostamento
    public void update(){
        gravita();
        player.update(); //funzione dalla classe del Player update.
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        player.draw(g);
    }

}
