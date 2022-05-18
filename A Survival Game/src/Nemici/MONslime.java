package Nemici;

import Umani.umani;
import a.survival.game.Pannello;
import java.util.Random;

/**
 *
 * @author Denis
 */
public class MONslime extends umani{
    public MONslime(Pannello p) {
        super(p);
        type=2;
        nome="Slime Verde";
        velocita=1;
        VitaMax=4;
        vita=VitaMax;
        
        SArea.x=3;
        SArea.y=18;
        SArea.width=42;
        SArea.height=30;
        AreaSX=SArea.x;
        AreaSY=SArea.y;
        getImage();
    }
    
    public void getImage() {
        su1 = setup("/immagini/nemici/slime_giu1");
        su2 = setup("/immagini/nemici/slime_giu2");
        giu1 = setup("/immagini/nemici/slime_giu1");
        giu2 = setup("/immagini/nemici/slime_giu2");
        sinistra1 = setup("/immagini/nemici/slime_giu1");
        sinistra2 = setup("/immagini/nemici/slime_giu2");
        destra1 = setup("/immagini/nemici/slime_giu1");
        destra2 = setup("/immagini/nemici/slime_giu2");
    }
    
    public void setMove() {
        VelocitaM++;
        if (VelocitaM == 50) {
            Random random = new Random();
            int i = random.nextInt(100) + 1;

            if (i <= 25) {
                direzione = "su";
            }
            if (i > 25 && i <= 50) {
                direzione = "giu";
            }
            if (i > 50 && i <= 75) {
                direzione = "sinistra";
            }
            if (i > 75 && i <= 100) {
                direzione = "destra";
            }
            VelocitaM = 0;
        }
    }
}
