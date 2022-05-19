package Nemici;

import Umani.umani;
import a.survival.game.Pannello;
import java.util.Random;

/**
 *
 * @author Denis
 */
public class MONape extends umani{
    
    Pannello p;
    
    public MONape(Pannello p) {
        super(p);
        this.p=p;
        type = 2;
        nome = "Ape";
        velocita = 1;
        VitaMax = 4;
        vita = VitaMax;

        SArea.x = 3;
        SArea.y = 18;
        SArea.width = 42;
        SArea.height = 30;
        AreaSX = SArea.x;
        AreaSY = SArea.y;
        getImage();
    }

    public void getImage() {
        su1 = setup("/immagini/nemici/agiu1",p.FinalAP,p.FinalAP);
        su2 = setup("/immagini/nemici/agiu2",p.FinalAP,p.FinalAP);
        giu1 = setup("/immagini/nemici/agiu3",p.FinalAP,p.FinalAP);
        giu2 = setup("/immagini/nemici/agiu4",p.FinalAP,p.FinalAP);
        sinistra1 = setup("/immagini/nemici/agiu1",p.FinalAP,p.FinalAP);
        sinistra2 = setup("/immagini/nemici/agiu2",p.FinalAP,p.FinalAP);
        destra1 = setup("/immagini/nemici/agiu3",p.FinalAP,p.FinalAP);
        destra2 = setup("/immagini/nemici/agiu4",p.FinalAP,p.FinalAP);
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
