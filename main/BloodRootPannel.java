package main;

import input.KeyInputs;
import input.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BloodRootPannel extends JPanel {
    private MouseInputs mouseInputs;
    private int xDelta, yDelta = 0;

    public BloodRootPannel() {
        mouseInputs = new MouseInputs();
        addKeyListener(new KeyInputs(this));
        addMouseListener(mouseInputs);
    }

    //metodi per spostamento
    public void moveXDelta(int value){
        this.xDelta += value;
        repaint(); //redisegna permette allo spostamento della figura
    }
    public void moveYDelta(int value){
        this.yDelta += value;
        repaint(); // redisegna
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillOval(10 + xDelta, 10 + yDelta, 100, 100);
        g.fillRect(0, 900, 100000, 300);
    }
}
