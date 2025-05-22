package entity;

import Inputs.KeyBoardInputs;
import Inputs.MouseInputs;
import main.GamePannel;
import utilz.AnimazioniPlayer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {

    GamePannel gamePannel;
    KeyBoardInputs keyBoardInputs;
    MouseInputs mouseInputs;
    private AnimazioniPlayer animazioniPlayer;


    public int playerStatus;
    private double gravita = 0.3;
    private double smorzamento = 0.8;
    private double velocitaY = 0;
    private boolean aTerra = true;

    public Player(GamePannel gamePannel, KeyBoardInputs keyBoardInputs, MouseInputs mouseInputs){
        this.gamePannel = gamePannel;
        this.keyBoardInputs = keyBoardInputs;
        this.mouseInputs = mouseInputs;

        animazioniPlayer = new AnimazioniPlayer();  // inizializza correttamente
        animazioniPlayer.caricaAnimazioni();        // carica i frame una sola volta!

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
            playerStatus = 1; // stato caduta
        }

        // Verifica collisione col "terreno"
        int groundLevel = 490; // adatta questo valore alla tua mappa

        if (y >= groundLevel) { //quanto y raggiunge il terrno la velocitaY è azzerrata
            y = groundLevel;
            velocitaY = 0;
            aTerra = true;  //player è a terra
            playerStatus = 0; // stato idle
        } else {
            aTerra = false;
        }
    }


    public void update(){
        //movimento del personaggio
        gravita();

        if(keyBoardInputs.upSpeed) y-= 10; //salto
        if(keyBoardInputs.downSpeed) y += speed;
        if(keyBoardInputs.rightSpeed){
            x += speed;
            playerStatus = 2; //stato corsa verso destra
        }
        if(keyBoardInputs.leftSpeed){
            x -= speed;
            playerStatus = 3; //stato corsa verso sinistra
        }
        if (keyBoardInputs.roll) playerStatus = 6;

        if(mouseInputs.attacco){
            playerStatus = 4;
        }
    }

    private BufferedImage[] getCurrentSpriteArray(int status) {
        switch (status) {
            case 0: return animazioniPlayer.idleSpirte;
            case 1: return animazioniPlayer.fallSpirte;
            case 2: return animazioniPlayer.runRightSpirte;
            case 3: return animazioniPlayer.runLeftSpirte;
            case 4: return animazioniPlayer.attackSpirte;
            case 5: return animazioniPlayer.hitSpirte;
            case 6: return animazioniPlayer.rollSpirte;
            case 7: return animazioniPlayer.deathSpirte;
            default: return animazioniPlayer.idleSpirte;
        }
    }
    
    //Disegno del personaggio
    public void draw(Graphics g){
        int index = animazioniPlayer.updateAnimazione(playerStatus);
        BufferedImage frame = getCurrentSpriteArray(playerStatus)[index];
        g.drawImage(frame, x, y, 120 * 3, 80 * 3, null);
    }
}
