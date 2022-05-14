package oggetti;

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
public class OGGporta extends TuttiOGG{
    public BufferedImage image;
    public String nome;
    public boolean collisioni = false;
    public int mondox, mondoy;
    public Rectangle SArea = new Rectangle(0, 0, 48, 48);
    public int AreaSX = 0;
    public int AreaSY = 0;
    UtilityTool uTool = new UtilityTool();

    public void draw(Graphics2D g2, Pannello p) {
        int schermoX = mondox - p.player.mondoX + p.player.schermoX;
        int schermoY = mondoy - p.player.mondoY + p.player.schermoY;

        if (mondox + p.FinalAP > p.player.mondoX - p.player.schermoX
                && mondox - p.FinalAP < p.player.mondoX + p.player.schermoX
                && mondoy + p.FinalAP > p.player.mondoY - p.player.schermoY
                && mondoy - p.FinalAP < p.player.mondoY + p.player.schermoY) {
            g2.drawImage(image, schermoX, schermoY, p.FinalAP, p.FinalAP, null);
        }
    }
}
