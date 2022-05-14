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
    public int mondoX,mondoY;
    public int velocita;
    public BufferedImage  su1,su2,giu1,giu2,sinistra1,sinistra2,destra1,destra2;
    public String direzione;
    public int Contat=0;
    public int Num=1;
    
    public Rectangle SArea=new Rectangle(0,0,48,48);
    
    public int AreaSX,AreaSY;
    public boolean collisioniOn=false;
    public int VelocitaM=0;
    
    String dialoghi[]=new String[20];
    int Inddialoghi=0;
    
    public umani(Pannello p) {
        this.p=p;
    }
    
    public void setMove() {
        
    }
    
    public void parla() {
        
    }
    
    public void muovi() {
        setMove();
        collisioniOn=false;
        p.collisioni.controllaCollisioni(this);
        p.collisioni.ControllaOGG(this,false);
        p.collisioni.ControllaP(this);
        
        if (collisioniOn == false) {
            switch (direzione) {
                case "su": mondoY -= velocita; break;
                case "giu": mondoY += velocita; break; 
                case "sinistra": mondoX -= velocita; break;
                case "destra": mondoX += velocita; break;
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
        int schermoX = mondoX - p.player.mondoX + p.player.schermoX;
        int schermoY = mondoY - p.player.mondoY + p.player.schermoY;

        if (mondoX + p.FinalAP > p.player.mondoX - p.player.schermoX && 
            mondoX - p.FinalAP < p.player.mondoX + p.player.schermoX && 
            mondoY + p.FinalAP > p.player.mondoY - p.player.schermoY && 
            mondoY - p.FinalAP < p.player.mondoY + p.player.schermoY) {
            
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
        BufferedImage image = null;

        try {
            image = ImageIO.read(getClass().getResourceAsStream(Nimmagine + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
