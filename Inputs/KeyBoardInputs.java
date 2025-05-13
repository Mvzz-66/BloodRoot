package Inputs;

import main.GamePannel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardInputs implements KeyListener {

    public volatile boolean upSpeed, rightSpeed, leftSpeed, downSpeed;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W) upSpeed = true;
        if(code == KeyEvent.VK_S) downSpeed = true;
        if(code == KeyEvent.VK_A) leftSpeed = true;
        if(code == KeyEvent.VK_D) rightSpeed = true;

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W) upSpeed = false;
        if(code == KeyEvent.VK_S) downSpeed = false;
        if(code == KeyEvent.VK_A) leftSpeed = false;
        if(code == KeyEvent.VK_D) rightSpeed = false;
    }
}
