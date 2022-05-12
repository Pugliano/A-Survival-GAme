package oggetti;

import a.survival.game.Pannello;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Denis
 */
public class OGGcassa extends TuttiOGG{
    Pannello p;
    public OGGcassa(Pannello p) {
        this.p = p;
        nome = "cassa";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/immagini/oggetti/cassa.png"));
            uTool.Simm(image, p.FinalAP, p.FinalAP);
        } catch (IOException e) {
            e.printStackTrace();
        }
        collisioni=true;
    }
}
