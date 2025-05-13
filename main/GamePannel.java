package main;

import Inputs.KeyBoardInputs;
import Inputs.MouseInputs;
import entity.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utilz.Costants.PlayerCostans.*; //importa tutto che c'e nel Costants

public class GamePannel extends JPanel {
    private MouseInputs mouseInputs;
    private KeyBoardInputs keyBoardInputs = new KeyBoardInputs();
    private BufferedImage img, subImg;
    private BufferedImage[] animation;
    private int aniTick, aniIndex, aniSpeed = 15;

    Player player = new Player(this, keyBoardInputs);

    public GamePannel() {
        mouseInputs = new MouseInputs();


        addKeyListener(keyBoardInputs); //input tastiera
        addMouseListener(mouseInputs); //input del mouse
        windowCorrectSize();

        this.setFocusable(true);
        requestFocusInWindow();

        importImg();
        runAinimation();
    }

    private void runAinimation() {
        animation = new BufferedImage[8];
        for (int i = 0; i < animation.length; i++) {
            animation[i] = img.getSubimage(i*120,0, 120, 80);
        }
    }

    public void importImg() {
        InputStream is = getClass().getResourceAsStream("/player/Colour1/Outline/120x80_PNGSheets/_RunRight.png");
        try {
            if (is == null) {
                throw new RuntimeException("File non trovato! Percorso sbagliato o file mancante");
            }

            img = ImageIO.read(is);
            System.out.println("Immagine caricata: " + img.getWidth() + "x" + img.getHeight());
        } catch (IOException e) {
            e.printStackTrace();
        }finally { // serve per risparmiare risorse
            try {
                is.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    //set della finesta a dimensioni giuste
    public void windowCorrectSize(){
        Dimension size = new Dimension(1920, 1080);
        setPreferredSize(size);
    }

    //metodi per spostamento
    public void update(){
        player.update(); //funzione dalla classe del Player update.
    }

    private void aggiornaAnimazione() {
        aniTick++;
        if(aniTick >= aniSpeed){
            aniTick = 0;
            aniIndex++;
            if(aniIndex >= animation.length) aniIndex = 0;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        aggiornaAnimazione();

        g.drawImage(animation [aniIndex], 0, 0,240, 160, null);
    }

}
