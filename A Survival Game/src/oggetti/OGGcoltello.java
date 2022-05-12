package oggetti;

import a.survival.game.Pannello;
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 *
 * @author Denis
 */
public class OGGcoltello extends TuttiOGG{
    Pannello p;
    public OGGcoltello(Pannello p) {
        this.p = p;
        nome="coltello";
        try{
            image=ImageIO.read(getClass().getResourceAsStream("/immagini/oggetti/cs.png"));
            uTool.Simm(image, p.FinalAP, p.FinalAP);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
