package entity;

import Inputs.KeyBoardInputs;
import main.GamePannel;
import utilz.Animazioni;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {

    GamePannel gamePannel;
    KeyBoardInputs keyBoardInputs;
    private Animazioni ani;
    private ImageIcon gifIcon[] = new ImageIcon[]{
            new ImageIcon(getClass().getResource("/main/res/120x80_gifs/__Attack.gif")),
            new ImageIcon(getClass().getResource("/main/res/120x80_gifs/__Death.gif")),
            new ImageIcon(getClass().getResource("/main/res/120x80_gifs/__Fall.gif")),
            new ImageIcon(getClass().getResource("/main/res/120x80_gifs/__Hit.gif")),
            new ImageIcon(getClass().getResource("/main/res/120x80_gifs/__Idle.gif")),
            new ImageIcon(getClass().getResource("/main/res/120x80_gifs/__Jump.gif")),
            new ImageIcon(getClass().getResource("/main/res/120x80_gifs/__Roll.gif")),
            new ImageIcon(getClass().getResource("/main/res/120x80_gifs/__RunRight.gif")),
            new ImageIcon(getClass().getResource("/main/res/120x80_gifs/__RunLeft.gif")),
    };

    public Player(GamePannel gamePannel, KeyBoardInputs keyBoardInputs){
        this.gamePannel = gamePannel;
        this.keyBoardInputs = keyBoardInputs;
        this.ani = new Animazioni(keyBoardInputs, gamePannel);
        setDeutifulValues();

    }

    public void setDeutifulValues(){
        x = 100;
        y = 100;
        speed = 4;
        jumpSpeed = speed * 2;
    }

    //movimento del personaggio
    public void update(){
        if(keyBoardInputs.upSpeed) y -= jumpSpeed;
        if(keyBoardInputs.downSpeed) y += speed;
        if(keyBoardInputs.rightSpeed) x += speed;
        if(keyBoardInputs.leftSpeed) x -= speed;

    }



    //Disegno del personaggio
    public void draw(Graphics g){
        g.drawImage(gifIcon[ani.action()].getImage(),x, y, 125 * 2, 80*2, null);
    }
}
