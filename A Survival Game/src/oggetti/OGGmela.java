package oggetti;

import Umani.umani;
import a.survival.game.Pannello;

/**
 *
 * @author Denis
 */
public class OGGmela extends umani{
    public OGGmela(Pannello p) {
        super(p);
        nome = "cassa";
        giu1 = setup("/immagini/oggetti/cassa", p.FinalAP, p.FinalAP);
        collisioni = true;
    }
}
