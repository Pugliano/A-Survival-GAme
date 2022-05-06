package oggetti;

import java.io.IOException;
import javax.imageio.ImageIO;


/**
 *
 * @author Denis
 */
public class OGGcoltello extends TuttiOGG{
    public OGGcoltello() {
        nome="coltello";
        try{
            image=ImageIO.read(getClass().getResourceAsStream("/immagini/oggetti/cs.png"));
        }catch(IOException e) {
            e.printStackTrace();
        }
        
        SArea.x=5;
    }
}
