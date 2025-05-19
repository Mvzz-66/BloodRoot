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
        System.out.printf("x: " + e.getX());
        System.out.println("y: " + e.getY());
        if (e.getButton() == MouseEvent.BUTTON1) {
            attacco = true;
            System.out.println("Attacco attivato!");
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            attacco = false;
            System.out.println("Attacco attivato!");
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
