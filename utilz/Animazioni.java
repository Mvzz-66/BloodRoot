package utilz;

import Inputs.KeyBoardInputs;
import Inputs.MouseInputs;
import entity.Player;
import main.GamePannel;
import main.GameWindow;

import javax.swing.*;
import java.awt.*;

public class Animazioni {

    private Image img;
    private int attack = 0;
    private int deaht = 1;
    private int fall = 2;
    private int hit = 3;
    private int idle = 4;
    private int jump = 5;
    private int roll = 6;
    private int runRight = 7;
    private int runLeft = 8;
    private GamePannel gamePannel;
    private KeyBoardInputs kb;
    private MouseInputs mI;

    public Animazioni(KeyBoardInputs kb, GamePannel gamePannel){
        this.kb = kb;
        this.gamePannel = gamePannel;
    }

    //Status action controller
    public int action(){        //In base al tasto cliccato fa l'animazione
        if(kb.rightSpeed) return runRight;
        if(kb.leftSpeed) return runLeft;
        if(kb.downSpeed) return fall;
        if(kb.roll) return roll;
        if(kb.upSpeed) return jump;
        if(gamePannel.gravita()) return fall;

        return idle;
    }
}
