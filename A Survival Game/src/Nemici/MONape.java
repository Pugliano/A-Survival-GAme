package Nemici;

import Umani.umani;
import a.survival.game.Pannello;
import java.util.Random;

/**
 *
 * @author Denis
 */
public class MONape extends umani{
    public MONape(Pannello p) {
        super(p);
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
        su1 = setup("/immagini/nemici/agiu1");
        su2 = setup("/immagini/nemici/agiu2");
        giu1 = setup("/immagini/nemici/agiu3");
        giu2 = setup("/immagini/nemici/agiu4");
        sinistra1 = setup("/immagini/nemici/agiu1");
        sinistra2 = setup("/immagini/nemici/agiu2");
        destra1 = setup("/immagini/nemici/agiu3");
        destra2 = setup("/immagini/nemici/agiu4");
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
