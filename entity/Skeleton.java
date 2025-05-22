package entity;

import Inputs.KeyBoardInputs;
import main.GamePannel;
import utilz.animazioniSkeletri;
import utilz.AnimazioniSkeletri;

import java.awt.image.BufferedImage;

public class Skeleton extends Entity{
    GamePannel gamePannel;
    private AnimazioniSkeletri animazioniSkeletri;

    public Skeleton(GamePannel gamePannel){
        this.gamePannel = gamePannel;

        setDeutifulValues();

    }

    public void setDeutifulValues(){
        x = 100;
        y = 100;
        speed = 2;
    }


    public void update(){
        //movimento del personaggio
    }

    private BufferedImage[] getCurrentSpriteArray(int status) {
        switch (status) {
            case 0: return animazioniSkeletri.idleSpirte;
            case 1: return animazioniSkeletri.fallSpirte;
            case 2: return animazioniSkeletri.runRightSpirte;
            case 3: return animazioniSkeletri.runLeftSpirte;
            case 4: return animazioniSkeletri.attackSpirte;
            case 5: return animazioniSkeletri.hitSpirte;
            case 6: return animazioniSkeletri.rollSpirte;
            case 7: return animazioniSkeletri.deathSpirte;
            default: return animazioniSkeletri.idleSpirte;
        }
    }
}

