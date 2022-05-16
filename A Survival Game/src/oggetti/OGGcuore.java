package oggetti;

import a.survival.game.Pannello;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Denis
 */
public class OGGcuore extends TuttiOGG{
    Pannello p;

    public OGGcuore(Pannello p) {
        this.p = p;
        nome = "cuore";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/immagini/oggetti/cuore_m.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/immagini/oggetti/cuore_p.png"));
            image3 = ImageIO.read(getClass().getResourceAsStream("/immagini/oggetti/cuore_b.png"));
            image=uTool.Simm(image, p.FinalAP, p.FinalAP);
            image2=uTool.Simm(image2, p.FinalAP, p.FinalAP);
            image3=uTool.Simm(image3, p.FinalAP, p.FinalAP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
