/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entita;

import a.survival.game.Pannello;
import a.survival.game.UtilityTool;
import java.awt.image.BufferedImage;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author occhiato_andrea
 */
public class Mob extends Entita {

    int danno;

    public Mob(Pannello p, String nome, int danno) {
        super(p);
        this.nome = nome;
        this.danno = danno;
        type = 2;
        velocita = 5;
        VitaMax = 4;
        vita = VitaMax;
    }

    @Override
    public void run() {
        while (true) {
            if (p.state != p.gioco) {
                continue;
            }
            muovi();
            try {
                sleep(16);
            } catch (InterruptedException ex) {
                Logger.getLogger(NPC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void setMove() {
        VelocitaM++;
        if (VelocitaM == 50) {
            Random random = new Random();
            int i = random.nextInt(100) + 1;

            if (i <= 25) {
                direzione = "su";
            }
            if (i > 25 && i <= 50) {
                direzione = "giu";
            }
            if (i > 50 && i <= 75) {
                direzione = "sinistra";
            }
            if (i > 75 && i <= 100) {
                direzione = "destra";
            }
            VelocitaM = 0;
        }
    }

    /*public int calcoloDistanzaX(){
        
    }
    
    public int calcoloDistanzaY(){
        
    }*/
}
