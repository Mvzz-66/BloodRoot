package main;

import input.KeyInputs;
import input.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.lang.management.BufferPoolMXBean;
import java.util.Random;
import java.util.Scanner;

public class GamePannel extends JPanel {
    private MouseInputs mouseInputs;
    private BufferedImage img;

    private float xDelta  = 0, yDelta = 0;
    private float xDir = 0.01f, yDir = 0.01f;


    public GamePannel() {
        mouseInputs = new MouseInputs(this);

        importImg();

        addKeyListener(new KeyInputs(this));
        addMouseListener(mouseInputs);
    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/Comparison2x.png");
    }

    //metodi per spostamento
    public void moveXDelta(int value){
        this.xDelta += value;
    }
    public void moveYDelta(int value){
        this.yDelta += value;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(img, 0, 0, null);


    }

}
