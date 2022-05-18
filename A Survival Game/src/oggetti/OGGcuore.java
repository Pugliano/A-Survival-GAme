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
        image1 = setup("/immagini/oggetti/cuore_m");
        image2 = setup("/immagini/oggetti/cuore_p");
        image3 = setup("/immagini/oggetti/cuore_b");
        
        image1 = uTool.Simm(image1, p.FinalAP, p.FinalAP);
        image2 = uTool.Simm(image2, p.FinalAP, p.FinalAP);
        image3 = uTool.Simm(image3, p.FinalAP, p.FinalAP);
    }
}
