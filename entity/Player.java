package entity;

import Inputs.KeyBoardInputs;
import main.GamePannel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {

    GamePannel gamePannel;
    KeyBoardInputs keyBoardInputs;
    private BufferedImage img, subImg;

    public Player(GamePannel gamePannel, KeyBoardInputs keyBoardInputs){
        this.gamePannel = gamePannel;
        this.keyBoardInputs = keyBoardInputs;
        setDeutifulValues();

    }

    public void setDeutifulValues(){
        x = 100;
        y = 100;
        speed = 4;
    }

    //movimento del personaggio
    public void update(){
        if(keyBoardInputs.upSpeed) y -= speed;
        if(keyBoardInputs.downSpeed) y += speed;
        if(keyBoardInputs.rightSpeed) x += speed;
        if(keyBoardInputs.leftSpeed) x -= speed;
    }

    /*Disegno del personaggio
    public void draw(Graphics g){
        subImg = img.getSubimage(1*120, 0, 120, 80);
        g.drawImage(img.getSubimage(0, 0, 120, 80), 0, 0, 240, 160, null);
        g.drawImage(subImg, 120, 0, 240, 160, null);
    }*/
}
