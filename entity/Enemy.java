package entity;

import Inputs.KeyBoardInputs;
import main.GamePannel;
import utilz.AnimazioniPlayer;

public class Enemy extends Entity{
    GamePannel gamePannel;
    KeyBoardInputs keyBoardInputs;
    private AnimazioniPlayer ani;

    public Enemy(GamePannel gamePannel, KeyBoardInputs keyBoardInputs){
        this.gamePannel = gamePannel;
        this.keyBoardInputs = keyBoardInputs;

        setDeutifulValues();

    }

    public void setDeutifulValues(){
        x = 100;
        y = 100;
        speed = 4;
    }


    public void update(){
        //movimento del personaggio
    }
}

