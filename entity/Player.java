package entity;

import Inputs.KeyBoardInputs;
import Inputs.MouseInputs;
import main.GamePannel;
import utilz.Animazioni;

import javax.swing.*;
import java.awt.*;
import java.sql.Time;

public class Player extends Entity {

    GamePannel gamePannel;
    KeyBoardInputs keyBoardInputs;
    MouseInputs mouseInputs;
    private Animazioni ani;

    private double gravita = 0.3;
    private double smorzamento = 0.8;
    private double velocitaY = 0;
    private boolean aTerra = true;

    private int timerAttacco = 0;
    private int durataAttacco = 20;

    private ImageIcon gifIcon[] = new ImageIcon[]{

            new ImageIcon(getClass().getResource("/player/__Attack.gif")), // aggiungere tasto segreto che mostra il callegari
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
        this.ani = new Animazioni(keyBoardInputs, gamePannel, mouseInputs, this);
        setDeutifulValues();

    }


    public boolean isaTerra() {
        return aTerra;
    }

    public void setDeutifulValues(){
        x = 64;
        y = 490;
        speed = 4;
        initialVelocity = 2.1;
    }

    //gravita
    public void gravita(){
        if (!aTerra) {
            velocitaY += gravita;
            y += velocitaY;
        }

        // Verifica collisione col "terreno"
        int groundLevel = 490; // adatta questo valore alla tua mappa

        if (y >= groundLevel) { //quanto y raggiunge il terrno la velocitaY è azzerrata
            y = groundLevel;
            velocitaY = 0;
            aTerra = true;  //player è a terra
        } else {
            aTerra = false;
        }
    }


    public void update(){
        //movimento del personaggio
        gravita();

        if(keyBoardInputs.upSpeed) y-= 10; //salto
        if(keyBoardInputs.downSpeed) y += speed;
        if(keyBoardInputs.rightSpeed) x += speed;
        if(keyBoardInputs.leftSpeed) x -= speed;

    }

    //Disegno del personaggio
    public void draw(Graphics g){
        g.drawImage(gifIcon[ani.action()].getImage(), x, y, 120*3, 80*3, null);
    }
}
