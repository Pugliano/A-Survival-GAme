package oggetti;

import Entita.Entita;
import a.survival.game.Pannello;

/**
 *
 * @author Denis
 */
public class OGGmuro extends Entita{
    public OGGmuro(Pannello p) {
        super(p);
        nome = "cassa";
        giu1 = setup("/immagini/oggetti/cassa", p.FinalAP, p.FinalAP);
        collisioni = true;
    }
}
