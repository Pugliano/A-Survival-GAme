package oggetti;

import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Denis
 */
public class OGGmela extends TuttiOGG{
    public OGGmela() {
        nome = "mela";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/immagini/oggetti/mela.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
