package entity;

import main.GamePannel;
import utilz.AnimazioniSkeletri;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Skeleton{
    GamePannel gamePannel;
    private AnimazioniSkeletri animazioniSkeletri;
    private Player p;

    private int x;
    private int y;
    private int speed;
    private int skeletriStatus;
    private boolean changeDirection = false;

    public Skeleton(GamePannel gamePannel) {
        this.gamePannel = gamePannel;

        animazioniSkeletri = new AnimazioniSkeletri();
        animazioniSkeletri.caricaAnimazioni();

        setDeutifulValues();

    }

    public void setDeutifulValues(){
        x = 100;
        y = 575;
        speed = 2;
    }


    public void update(){
        //movimento dello scheletro
        if(x <= 1800 && changeDirection == false){
            x += speed;
            skeletriStatus = 1;
            if(x == 1800) changeDirection = true;
        }
        if(x >= 0 && changeDirection == true){
            x -= speed;
            skeletriStatus = 2;
            if(x == 0) changeDirection = false;
        }

    }

    private BufferedImage[] getCurrentSpriteArray(int status) {
        switch (status) {
            case 0: return animazioniSkeletri.idleSpirte;
            case 1: return animazioniSkeletri.walkRightSpirte;
            case 2: return animazioniSkeletri.walkLeftSpirte;
            case 3: return animazioniSkeletri.attackSpirte;
            case 4: return animazioniSkeletri.hitSpirte;
            case 5: return animazioniSkeletri.deathSpirte;
            default: return animazioniSkeletri.idleSpirte;
        }
    }

    public void draw(Graphics g){
        int index = animazioniSkeletri.updateAnimazione(skeletriStatus);
        BufferedImage frame = getCurrentSpriteArray(skeletriStatus)[index];
        g.drawImage(frame, x, y, frame.getWidth() * 4, frame.getHeight() * 4, null);
        g.drawRect(x, y, frame.getWidth() * 4, frame.getHeight() * 4);
    }
}

