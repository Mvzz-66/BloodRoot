package entity;

import Inputs.KeyBoardInputs;
import main.GamePannel;
import utilz.AnimazioniPlayer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player{

    GamePannel gamePannel;
    KeyBoardInputs keyBoardInputs;
    private AnimazioniPlayer animazioniPlayer;
    private Skeleton skeleton;
    private Rectangle hitbox;


    public int playerStatus;
    private boolean isAttacking = false;
    private boolean playerHit = false;
    private int attackCooldown = 0;
    private double gravita = 0.3;
    private double velocitaY = 0;
    private boolean aTerra = true;

    int width, height;

    private int x;
    private int y;
    private int speed;
    private int health;

    public Player(GamePannel gamePannel, KeyBoardInputs keyBoardInputs){
        this.gamePannel = gamePannel;
        this.keyBoardInputs = keyBoardInputs;

        width = 38 * 3;
        height = 37 * 3;
        hitbox = new Rectangle(x, y, width, height); // usa this.hitbox

        animazioniPlayer = new AnimazioniPlayer();  // inizializza correttamente
        animazioniPlayer.caricaAnimazioni();        // carica i frame una sola volta!

        setDeutifulValues();
    }

    public int getX() {
        return x;
    }

    public boolean isaTerra() {
        return aTerra;
    }

    public boolean isPlayerHit(){
        if(playerHit && health > 0){
            health--;
            return true;
        }
        return playerHit;
    }

    public void setPlayerStatus(int value){
        this.playerStatus = value;
    }

    public void setDeutifulValues(){
        x = 64;
        y = 490;
        speed = 4;
    }

    //gravita
    public void gravita(){
        if (!aTerra) {
            velocitaY += gravita;
            y += velocitaY;
            playerStatus = 1; // stato caduta
        }

        // Verifica collisione col "terreno"
        int groundLevel = 470; // adatta questo valore alla tua mappa

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
        isPlayerHit();

        if (keyBoardInputs.upSpeed) y -= 10;
        if (keyBoardInputs.downSpeed) y += speed;
        if (keyBoardInputs.rightSpeed) {
            x += speed;
            playerStatus = 2;
        }
        if (keyBoardInputs.leftSpeed) {
            x -= speed;
            playerStatus = 3;
        }
        if (keyBoardInputs.roll) playerStatus = 7;

        if(keyBoardInputs.attacco || (keyBoardInputs.attacco && keyBoardInputs.rightSpeed)) playerStatus = 4;

        if((keyBoardInputs.attacco && keyBoardInputs.leftSpeed)) playerStatus = 5;

        if(isPlayerHit()) playerStatus = 6;

        if(height == 0) playerStatus = 8;

        int drawWidth = 120 * 2;
        int drawHeight = 80 * 2;

        // Approssima hitbox centrale
        int hitboxWidth = 40;
        int hitboxHeight = 60;
        int hitboxOffsetX = (drawWidth - hitboxWidth) / 2;
        int hitboxOffsetY = drawHeight - hitboxHeight; // es. allinea ai piedi

        hitbox.setLocation(x + hitboxOffsetX, y + hitboxOffsetY);
    }

    private BufferedImage[] getCurrentSpriteArray(int status) {
        switch (status) {
            case 0: return animazioniPlayer.idleSpirte;
            case 1: return animazioniPlayer.fallSpirte;
            case 2: return animazioniPlayer.runRightSpirte;
            case 3: return animazioniPlayer.runLeftSpirte;
            case 4: return animazioniPlayer.attackSpirte;
            case 5: return animazioniPlayer.attackLeftSpirte;
            case 6: return animazioniPlayer.hitSpirte;
            case 7: return animazioniPlayer.rollSpirte;
            case 8: return animazioniPlayer.deathSpirte;
            default: return animazioniPlayer.idleSpirte;
        }
    }
    
    //Disegno del personaggio
    public void draw(Graphics g){
        int index = animazioniPlayer.updateAnimazione(playerStatus);
        BufferedImage frame = getCurrentSpriteArray(playerStatus)[index];
        g.drawImage(frame, x, y, 120 * 3, 80 * 3, null);
        g.setColor(Color.red);
        g.drawRect(hitbox.x, hitbox.y, hitbox.width, hitbox.height); // Debug hitbox

        if(playerStatus == 4){
            g.drawRect(hitbox.x, hitbox.y, 200, hitbox.height);
        }
        if(playerStatus == 5){
            g.drawRect(hitbox.x - 100, hitbox.y, 200, hitbox.height);
        }

        animazioniPlayer.debugAnimation(playerStatus);
    }
}
