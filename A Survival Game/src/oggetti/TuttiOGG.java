package oggetti;

import a.survival.game.Pannello;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author Denis
 */
public class TuttiOGG {
    public BufferedImage image;
    public String nome;
    public boolean collisioni=false;
    public int mondox,mondoy;
    
    public void draw(Graphics2D g2,Pannello p) {
        int schermoX = mondox - p.player.Mondox + p.player.schermoX;
        int schermoY = mondoy - p.player.Mondoy + p.player.schermoY;

        if (mondox + p.FinalAP > p.player.Mondox - p.player.schermoX
                && mondoy - p.FinalAP < p.player.Mondox + p.player.schermoX
                && mondoy + p.FinalAP > p.player.Mondoy - p.player.schermoY
                && mondoy - p.FinalAP < p.player.Mondoy + p.player.schermoY) {
            g2.drawImage(image, schermoX, schermoY, p.FinalAP, p.FinalAP, null);
        }
    }
}
