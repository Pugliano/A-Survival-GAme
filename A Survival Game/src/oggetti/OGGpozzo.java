package oggetti;

import Umani.umani;
import a.survival.game.Pannello;

/**
 *
 * @author Denis
 */
public class OGGpozzo extends umani{
    public OGGpozzo(Pannello p) {
        super(p);
        nome = "pozzo";
        giu1 = setup("/immagini/oggetti/pozzo");
        collisioni = true;

        SArea.x = 1;
        SArea.y = 0;
        SArea.width = 31;
        SArea.height = 15;
        AreaSX = SArea.x;
        AreaSY = SArea.y;
    }
}
