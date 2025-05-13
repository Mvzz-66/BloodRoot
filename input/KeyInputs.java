package input;

import main.GamePannel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInputs implements KeyListener {

    private GamePannel gamePannel;

    public KeyInputs(GamePannel gamePannel){
        this.gamePannel = gamePannel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_A:
                gamePannel.moveXDelta(-25);
                break;
            case KeyEvent.VK_S:
                gamePannel.moveYDelta(+25);
                break;
            case KeyEvent.VK_D:
                gamePannel.moveXDelta(+25);
                break;
            case KeyEvent.VK_W:
                gamePannel.moveYDelta(-25);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {    }
}
