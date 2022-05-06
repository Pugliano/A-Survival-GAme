package oggetti;

import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Denis
 */
public class OGGporta extends TuttiOGG{
    public OGGporta() {
        nome = "porta";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/immagini/oggetti/porta.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collisioni=true;
    }
}
