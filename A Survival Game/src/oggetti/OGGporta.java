package oggetti;

import Umani.umani;
import a.survival.game.Pannello;

/**
 *
 * @author Denis
 */
public class OGGporta extends umani{
    public OGGporta(Pannello p) {
        super(p);
        nome = "porta";
        giu1 = setup("/immagini/oggetti/porta");
        collisioni=true;
        
        SArea.x=10;
        SArea.y=0;
        SArea.width=31;
        SArea.height=32;
        AreaSX=SArea.x;
        AreaSY=SArea.y;
    }
}
