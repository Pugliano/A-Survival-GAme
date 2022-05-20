package oggetti;

import Entita.Entita;
import a.survival.game.Pannello;

/**
 *
 * @author Denis
 */
public class OGGcassa extends Entita{
    public OGGcassa(Pannello p) {
        super(p);
        nome = "cassa";
        giu1 = setup("/immagini/oggetti/cassa",p.FinalAP,p.FinalAP);
        collisioni=true;
    }
}
