package oggetti;

import Umani.umani;
import a.survival.game.Pannello;

/**
 *
 * @author Denis
 */
public class OGGscudo extends umani{
    public OGGscudo(Pannello p) {
        super(p);
        
        nome="scudo";
        giu1=setup("/immagini/oggetti/scudo");
        difesaScudo=1;
    }
}
