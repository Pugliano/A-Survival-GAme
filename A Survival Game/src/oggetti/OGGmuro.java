package oggetti;

import Umani.umani;
import a.survival.game.Pannello;

/**
 *
 * @author Denis
 */
public class OGGmuro extends umani{
    public OGGmuro(Pannello p) {
        super(p);
        nome = "muro";
        giu1 = setup("/immagini/oggetti/wall");
        collisioni=true;
    }
}
