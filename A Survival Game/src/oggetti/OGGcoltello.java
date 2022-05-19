package oggetti;

import Umani.umani;
import a.survival.game.Pannello;


/**
 *
 * @author Denis
 */
public class OGGcoltello extends umani{
    public OGGcoltello(Pannello p) {
        super(p);
        nome="coltello";
        giu1=setup("/immagini/oggetti/cs",p.FinalAP,p.FinalAP);
    }
}
