package Umani;

import a.survival.game.Pannello;
import a.survival.game.UtilityTool;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Denis
 */
public class umani {
    Pannello p;
    public int Mondox,Mondoy;
    public int velocita;
    
    public BufferedImage  su1,su2,giu1,giu2,sinistra1,sinistra2,destra1,destra2;
    public BufferedImage attaccoSu1, attaccoSu2, attaccoGiu1, attaccoGiu2, attaccoSinistra1, attaccoSinistra2, attaccoDestra1, attaccoDestra2;
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
    public boolean collisioni = false;
    
    public boolean invincibile=false;
    
    public int spriteCounter=0;
    int invincibileContatore;
    
    public int type; //0->giocatore 1->npc 2->nemico
    
    //vita giocatore
    public int VitaMax;
    public int vita;
    
    //statistiche giocatore
    public int livello;
    public int forza;
    public int attacco;
    public int difesa;
    public int spirito;
    public int exp;
    public int soldi;
    public umani Arma;
    public umani Scudo;
    
    //statistiche armi
    public int attaccoSpada;
    public int difesaScudo;
    
    boolean attaccando=false;
    
    
    String[] dial=new String[20];
    int Inddialoghi=0;
    
    public umani(Pannello p) {
        this.p=p;
    }
    
    public void setMove() {
        
    }
    
    public void parla() {
        if (dial[Inddialoghi] == null) {
            Inddialoghi = 0;
        }
        p.messaggi.Dcorrente = dial[Inddialoghi];
        Inddialoghi++;

        switch (p.player.direzione) {
            case "su":
                direzione = "giu";
                p.player.vita=p.player.VitaMax;
                break;
            case "giu":
                direzione = "su";
                p.player.vita = p.player.VitaMax;
                break;
            case "sinistra":
                direzione = "destra";
                p.player.vita = p.player.VitaMax;
                break;
            case "destra":
                direzione = "sinistra";
                p.player.vita = p.player.VitaMax;
                break;
        }
    }
    
    public void muovi() {
        setMove();
        collisioniSI=false;
        p.collis.Controlla(this);
        p.collis.ControllaOGG(this,false);
        p.collis.ControllaU(this, p.npc);
        p.collis.ControllaU(this, p.nemici);
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
                case "su": Mondoy -= velocita; break;
                case "giu": Mondoy += velocita; break; 
                case "sinistra": Mondox -= velocita; break;
                case "destra": Mondox += velocita; break;
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
        int schermoX = Mondox - p.player.Mondox + p.player.schermoX;
        int schermoY = Mondoy - p.player.Mondoy + p.player.schermoY;

        if (Mondox + p.FinalAP > p.player.Mondox - p.player.schermoX && 
            Mondox - p.FinalAP < p.player.Mondox + p.player.schermoX && 
            Mondoy + p.FinalAP > p.player.Mondoy - p.player.schermoY && 
            Mondoy - p.FinalAP < p.player.Mondoy + p.player.schermoY) {
            
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
            img = uTool.Simm(img, l,a);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }
}
