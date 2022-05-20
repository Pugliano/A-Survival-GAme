package oggetti;

import Entita.Entita;
import a.survival.game.Pannello;

/**
 *
 * @author Denis
 */
public class OGGspada extends Entita{
    
    public OGGspada(Pannello p) {
        super(p);

        nome = "Spada";
        giu1 = setup("/immagini/oggetti/spada",p.FinalAP,p.FinalAP);
        attaccoSpada = 4;
    }
}
