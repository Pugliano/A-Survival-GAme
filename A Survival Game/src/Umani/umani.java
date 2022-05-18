package Umani;

import a.survival.game.Pannello;
import a.survival.game.UtilityTool;
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
    public String direzione="giu";
    
    public int Contat=0;
    public int Num=1;
    
    public Rectangle SArea=new Rectangle(0,0,48,48);
    
    public int AreaSX,AreaSY;
    public boolean collisioniSI=false;
    public int VelocitaM=0;
    
    public BufferedImage image,image1, image2, image3;
    public String nome;
    public boolean collisioni = false;
    
    public boolean invincibile=false;
    int invincibileContatore;
    
    public int type; //0->giocatore 1->npc 2->nemico
    
    //vita giocatore
    public int VitaMax;
    public int vita;
    
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
                break;
            case "giu":
                direzione = "su";
                break;
            case "sinistra":
                direzione = "destra";
                break;
            case "destra":
                direzione = "sinistra";
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
                if (Num == 1) {
                    image = su1;
                }
                if (Num == 2) {
                    image = su2;
                }
                break;
            case "giu":
                if (Num == 1) {
                    image = giu1;
                }
                if (Num == 2) {
                    image = giu2;
                }
                break;
            case "sinistra":
                if (Num == 1) {
                    image = sinistra1;
                }
                if (Num == 2) {
                    image = sinistra2;
                }
                break;
            case "destra":
                if (Num == 1) {
                    image = destra1;
                }
                if (Num == 2) {
                    image = destra2;
                }
                break;
        }
            
            g2.drawImage(image, schermoX, schermoY, 45, 45, null);
        }
    }
    
    public BufferedImage setup(String Nimmagine) {
        UtilityTool uTool=new UtilityTool();
        BufferedImage image = null;

        try {
            image = ImageIO.read(getClass().getResourceAsStream(Nimmagine + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
