package main;

import javax.swing.*;
import java.awt.*;

public class GameWindow {
    private JFrame jFrame;

    public GameWindow(GamePannel gamePannel){
        jFrame = new JFrame("Blood Root Window");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(gamePannel);
        jFrame.setResizable(true);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
    }
}

