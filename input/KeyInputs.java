package input;

import main.BloodRootPannel;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInputs implements KeyListener {

    private BloodRootPannel bloodRootPannel;

    public KeyInputs(BloodRootPannel bloodRootPannel){
        this.bloodRootPannel = bloodRootPannel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_A:
                bloodRootPannel.moveXDelta(-5);
                break;
            case KeyEvent.VK_S:
                bloodRootPannel.moveYDelta(+5);
                break;
            case KeyEvent.VK_D:
                bloodRootPannel.moveXDelta(+);
                break;
            case KeyEvent.VK_W:
                bloodRootPannel.moveXDelta(-5);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {    }
}
