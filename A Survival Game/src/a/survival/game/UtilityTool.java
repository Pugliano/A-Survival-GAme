package a.survival.game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author Denis
 */
public class UtilityTool {
    
    public BufferedImage Simm(BufferedImage og,int l,int a) {
        BufferedImage Simm=new BufferedImage(l,a,og.getType());
        Graphics2D g2=Simm.createGraphics();
        g2.drawImage(og,0,0,l,a,null);
        g2.dispose();
        return Simm;
    }
}
