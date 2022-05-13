package Umani;

import a.survival.game.Pannello;
import a.survival.game.UtilityTool;
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
    
    public BufferedImage setup(String Nimmagine) {
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;

        try {
            image = ImageIO.read(getClass().getResourceAsStream(Nimmagine + ".png"));
            //image = uTool.Simm(image, p.FinalAP, p.FinalAP);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
