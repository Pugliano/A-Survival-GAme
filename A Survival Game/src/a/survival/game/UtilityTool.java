package a.survival.game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author Denis
 */
public class UtilityTool {
    
    public BufferedImage Simm(BufferedImage or,int l,int a) {
        BufferedImage Simm=new BufferedImage(l,a,or.getType());
        Graphics2D g2=Simm.createGraphics();
        g2.drawImage(or,0,0,l,a,null);
        g2.dispose();
        
        return Simm;
    }
}
