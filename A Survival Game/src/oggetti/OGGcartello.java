package oggetti;

import Umani.umani;
import a.survival.game.Pannello;

/**
 *
 * @author Denis
 */
public class OGGcartello extends umani{
    public OGGcartello(Pannello p) {
        super(p);
        nome = "cartello";
        giu1 = setup("/immagini/oggetti/cartello");
        collisioni = true;

        SArea.x = 1;
        SArea.y = 0;
        SArea.width = 31;
        SArea.height = 15;
        AreaSX = SArea.x;
        AreaSY = SArea.y;
    }
}
