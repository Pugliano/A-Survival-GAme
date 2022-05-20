package oggetti;

import Umani.umani;
import a.survival.game.Pannello;
import a.survival.game.UtilityTool;

/**
 *
 * @author Denis
 */
public class OGGcuore extends umani{
    UtilityTool uTool=new UtilityTool();
    public OGGcuore(Pannello p) {
        super(p);
        nome = "cuore";
        image1 = setup("/immagini/oggetti/cuore_m",p.FinalAP,p.FinalAP);
        image2 = setup("/immagini/oggetti/cuore_p",p.FinalAP,p.FinalAP);
        image3 = setup("/immagini/oggetti/cuore_b",p.FinalAP,p.FinalAP);
        
        
    }
}
