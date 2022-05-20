package oggetti;

import Entita.Entita;
import a.survival.game.Pannello;

/**
 *
 * @author Denis
 */
public class OGGscudo extends Entita{
    
    public OGGscudo(Pannello p) {
        super(p);

        nome = "scudo";
        giu1 = setup("/immagini/oggetti/scudo", p.FinalAP, p.FinalAP);
        difesaScudo = 1;
    }
}
