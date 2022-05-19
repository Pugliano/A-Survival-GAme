package oggetti;

import Umani.umani;
import a.survival.game.Pannello;

/**
 *
 * @author Denis
 */
public class OGGspada extends umani{
    public OGGspada(Pannello p) {
        super(p);
        
        nome="Spada";
        giu1=setup("/immagini/oggetti/spada");
        attaccoSpada=4;
    }
}
