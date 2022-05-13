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
    public String direzione;
    
    public int Contatore=0;
    public int Num=1;
    
    public Rectangle AreaS=new Rectangle(0,0,48,48);
    
    public int AreaSX,AreaSY;
    public boolean collisioniSI=false;
    
    public umani(Pannello p) {
        this.p=p;
    }
    
    public void draw(Graphics2D g2) {
        BufferedImage image=null;
        int schermoX = Mondox - p.player.Mondox + p.player.schermoX;
        int schermoY = Mondoy - p.player.Mondoy + p.player.schermoY;

        if (Mondox + p.FinalAP > p.player.Mondox - p.player.schermoX
                && Mondox - p.FinalAP < p.player.Mondox + p.player.schermoX
                && Mondoy + p.FinalAP > p.player.Mondoy - p.player.schermoY
                && Mondoy - p.FinalAP < p.player.Mondoy + p.player.schermoY) {
            
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
            
            g2.drawImage(image, schermoX, schermoY, 48, 48, null);
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
