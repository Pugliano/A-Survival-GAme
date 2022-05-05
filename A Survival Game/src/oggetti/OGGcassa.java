package oggetti;

import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Denis
 */
public class OGGcassa extends TuttiOGG{
    public OGGcassa() {
        nome = "cassa";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/immagini/oggetti/cassa.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
