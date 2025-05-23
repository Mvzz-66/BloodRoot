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
        attacco = true;
        System.out.println("attacco");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
