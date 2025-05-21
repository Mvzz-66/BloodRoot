package Inputs;

import entity.Player;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static java.awt.event.MouseEvent.MOUSE_CLICKED;

public class MouseInputs implements MouseListener {
    private Player player;
    public volatile boolean attacco;

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        attacco = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        attacco = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
