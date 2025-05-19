package entity;

import Inputs.KeyBoardInputs;
import Inputs.MouseInputs;
import main.GamePannel;
import utilz.Animazioni;

import javax.swing.*;
import java.awt.*;

public class Player extends Entity {

    GamePannel gamePannel;
    KeyBoardInputs keyBoardInputs;
    MouseInputs mouseInputs;
    private Animazioni ani;
    private ImageIcon gifIcon[] = new ImageIcon[]{

            new ImageIcon(getClass().getResource("/player/__Attack.gif")),
            new ImageIcon(getClass().getResource("/player/__Death.gif")),
            new ImageIcon(getClass().getResource("/player/__Fall.gif")),
            new ImageIcon(getClass().getResource("/player/__Idle.gif")),
            new ImageIcon(getClass().getResource("/player/__Hit.gif")),
            new ImageIcon(getClass().getResource("/player/__Jump.gif")),
            new ImageIcon(getClass().getResource("/player/__Roll.gif")),
            new ImageIcon(getClass().getResource("/player/__RunRight.gif")),
            new ImageIcon(getClass().getResource("/player/__RunLeft.gif")),
    };

    public Player(GamePannel gamePannel, KeyBoardInputs keyBoardInputs, MouseInputs mouseInputs){
        this.gamePannel = gamePannel;
        this.keyBoardInputs = keyBoardInputs;
        this.mouseInputs = mouseInputs;
        this.ani = new Animazioni(keyBoardInputs, gamePannel, mouseInputs);
        setDeutifulValues();

    }

    public void setDeutifulValues(){
        x = 64;
        y = 800;
        speed = 4;
        initialVelocity = 2.1;
    }


    public void update(){
        //movimento del personaggio
        if(keyBoardInputs.upSpeed) y -= 2.1 * 5;
        if(keyBoardInputs.downSpeed) y += speed;
        if(keyBoardInputs.rightSpeed) x += speed;
        if(keyBoardInputs.leftSpeed) x -= speed;

        if (mouseInputs.attacco) {
            mouseInputs.attacco = false; // Reset dopo l'attacco
        }
    }



    //Disegno del personaggio
    public void draw(Graphics g){
        g.drawImage(gifIcon[ani.action()].getImage(), x, y, 120*3, 80*3, null);
    }
}
