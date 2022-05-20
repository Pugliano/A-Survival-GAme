/**
 * @author Pugliano Denis, Occhiato Andrea
 * @version 1.0
 * @file UtilityTool.java
 * @brief Classe Per caricare image
 */

package a.survival.game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * @class UtilityTool
 */
public class UtilityTool {
    
    /**\brief
     * Metodo per caricare immagine e settare la larghezza e l'altezza di tale immagine
     * @param og
     * @param l
     * @param a
     * @return 
     */
    public BufferedImage Simm(BufferedImage og,int l,int a) {
        BufferedImage Simm=new BufferedImage(l,a,og.getType());
        Graphics2D g2=Simm.createGraphics();
        g2.drawImage(og,0,0,l,a,null);
        g2.dispose();
        return Simm;
    }
}
