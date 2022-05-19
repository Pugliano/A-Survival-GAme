package Umani;

import a.survival.game.Pannello;
import java.util.Random;

/**
 *
 * @author Andrea
 */
public class NPC_anziano extends umani {

    Pannello p;

    public NPC_anziano(Pannello p) {
        super(p);
        this.p = p;
        direzione = "giu";
        velocita = 1;

        getImmagineV();
        setDialoghi();
    }

    public void getImmagineV() {
        su1 = setup("/immagini/npc/Vsu1");
        su2 = setup("/immagini/npc/vsu2");
        giu1 = setup("/immagini/npc/vgiu1");
        giu2 = setup("/immagini/npc/vgiu2");
        sinistra1 = setup("/immagini/npc/vsinistra1");
        sinistra2 = setup("/immagini/npc/vsinistra2");
        destra1 = setup("/immagini/npc/vdestra1");
        destra2 = setup("/immagini/npc/vdestra2");
    }

    public void setDialoghi() {
        dial[0] = "Ciao";
        dial[1] = "Sono un fantasma";
        dial[2] = "Ma sono anche un mago, quindi tieni";
    }

    public void setMove() {
        if (p.state == p.dialoghi) {
            
        } 
        else {
            VelocitaM++;
            if (VelocitaM == 150) {
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

    public void parla() {
        super.parla();
    }
}
