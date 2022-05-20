/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nemici;

import a.survival.game.Pannello;
import a.survival.game.UtilityTool;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author occhiato_andrea
 */
public class Mob extends Thread{
    Pannello p;
    int tipo=2;
    String nome;
    int velocita = 5;
    int vitaMax = 4;
    int vita = vitaMax;
    int danno;
    public BufferedImage su1,su2,giu1,giu2,sinistra1,sinistra2,destra1,destra2;

    public Mob(Pannello p, String nome, int danno) {
        this.p=p;
        this.nome=nome;
        this.danno=danno;
    }
    
    public BufferedImage setup(String Nimmagine, int l, int a) {
        UtilityTool uTool=new UtilityTool();
        BufferedImage img = null;

        try {
            img = ImageIO.read(getClass().getResourceAsStream(Nimmagine + ".png"));
            //img = uTool.Simm(img, l,a);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    @Override
    public void run() {
        while(true){
            
        }
    }
    
    
}
