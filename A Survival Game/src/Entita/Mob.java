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
import javax.imageio.ImageIO;

/**
 *
 * @author occhiato_andrea
 */
public class Mob extends Entita{
    
    int danno;

    public Mob(Pannello p, String nome, int danno) {
        super(p);
        this.nome=nome;
        this.danno=danno;
        type=2;
        velocita = 5;
        VitaMax = 4;
        vita = VitaMax;
    }

    @Override
    public void run() {
        //muovi();
        //sleep();
    }

    @Override
    public void setMove() {
        
    }
    
    
    
    /*public int calcoloDistanzaX(){
        
    }
    
    public int calcoloDistanzaY(){
        
    }*/
}
