package main;

import javax.swing.*;

public class GameWindow {
    private JFrame jFrame;

    public GameWindow(GamePannel gamePannel){
        jFrame = new JFrame("Blood Root Window");
        jFrame.setSize(600, 600);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(gamePannel);
        jFrame.setVisible(true);

        /* Imposto la visuale a full screen
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();

        if (gd.isFullScreenSupported()) {
            gd.setFullScreenWindow(jFrame);
        } else {
            // Se non é supportato full screen
            jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); //mette la dimesione della finestra al massimo
            jFrame.setVisible(true);
        }

         */
    }
}

