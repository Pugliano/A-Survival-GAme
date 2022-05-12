package oggetti;

import a.survival.game.Pannello;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Denis
 */
public class OGGporta extends TuttiOGG{
    Pannello p;
    public OGGporta(Pannello p) {
        this.p=p;
        nome = "porta";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/immagini/oggetti/porta.png"));
            uTool.Simm(image, p.FinalAP, p.FinalAP);
        } catch (IOException e) {
            e.printStackTrace();
        }
        collisioni=true;
    }
}
