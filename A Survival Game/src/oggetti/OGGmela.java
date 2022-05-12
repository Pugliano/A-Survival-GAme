package oggetti;

import a.survival.game.Pannello;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Denis
 */
public class OGGmela extends TuttiOGG{
    Pannello p;
    public OGGmela(Pannello p) {
        this.p = p;
        nome = "mela";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/immagini/oggetti/mela.png"));
            uTool.Simm(image, p.FinalAP, p.FinalAP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
