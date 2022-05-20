/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entita;

import a.survival.game.Pannello;
import a.survival.game.Tastiera;
import a.survival.game.UtilityTool;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Andrea
 */
public class Entita extends Thread{
    Pannello p;
    Tastiera t;
    
    public int x,y;
    public int velocita;
    
    public BufferedImage  su1,su2,giu1,giu2,sinistra1,sinistra2,destra1,destra2;
    public String direzione="giu";
    
    public int Contat=0;
    public int Num=1;
    
    public Rectangle SArea=new Rectangle(0,0,48,48);
    public Rectangle AreaAttacco=new Rectangle(0,0,0,0);
    
    public int AreaSX,AreaSY;
    public boolean collisioniSI=false;
    public int VelocitaM=0;
    
    
    public BufferedImage image,image1, image2, image3;
    public String nome;
    public boolean collisioni = true;
    
    public boolean invincibile=false;
    
    public int spriteCounter=0;
    int invincibileContatore;
    
    public int type; //0->giocatore 1->npc 2->nemico
    
    //vita giocatore
    public int VitaMax;
    public int vita;
    
    //armi
    public int attaccoSpada;
    public int difesaScudo;
    
    //npc
    int Inddialoghi;
    
    public Entita(Pannello p) {
        this.p=p;
    }
    
    public Entita(Pannello p, Tastiera t) {
        this.p=p;
        this.t=t;
    }
    
    public void setMove() {
        
    }
    
    public void muovi() {
        setMove();
        collisioniSI=false;
        p.collis.Controlla(this);
        p.collis.ControllaOGG(this,false);
        p.collis.ControllaU(this, p.gestNPC);
        p.collis.ControllaU(this, p.gestMob);
        boolean contattoPlayer=p.collis.ControllaP(this);
        
        if(this.type==2 && contattoPlayer==true) {
            if(p.player.invincibile==false) {
                //prendiamo danno
                p.player.vita-=1;
                p.player.invincibile=true;
            }
        }
        
        if (collisioniSI == false) {
            switch (direzione) {
                case "su": y -= velocita; break;
                case "giu": y += velocita; break; 
                case "sinistra": x -= velocita; break;
                case "destra": x += velocita; break;
            }
        }

        Contat++;
        if (Contat > 12) {
            if (Num == 1) {
                Num = 2;
            } else if (Num == 2) {
                Num = 1;
            }
            Contat = 0;
        }
        
        if (invincibile == true) {
            invincibileContatore++;
            if (invincibileContatore > 40) {
                invincibile = false;
                invincibileContatore = 0;
            }
        }
    }
    
    public void draw(Graphics2D g2) {
        BufferedImage image=null;
        int schermoX = x - p.player.x + p.player.schermoX;
        int schermoY = y - p.player.y + p.player.schermoY;

        if (x + p.FinalAP > p.player.x - p.player.schermoX && 
            x - p.FinalAP < p.player.x + p.player.schermoX && 
            y + p.FinalAP > p.player.y - p.player.schermoY && 
            y - p.FinalAP < p.player.y + p.player.schermoY) {
            
            switch (direzione) {
            case "su":
                if (Num == 1) {image = su1;}
                if (Num == 2) {image = su2;}
                break;
            case "giu":
                if (Num == 1) {image = giu1;}
                if (Num == 2) {image = giu2;}
                break;
            case "sinistra":
                if (Num == 1) {image = sinistra1;}
                if (Num == 2) {image = sinistra2;}
                break;
            case "destra":
                if (Num == 1) {image = destra1;}
                if (Num == 2) {image = destra2;}
                break;
        }
            
            if (invincibile == true) {
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
            }
            
            g2.drawImage(image, schermoX, schermoY, 45, 45, null);
            
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        }
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
    
    public void parla(){
        
    }
}
