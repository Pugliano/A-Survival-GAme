package Umani;

import a.survival.game.Pannello;
import a.survival.game.UtilityTool;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Andrea
 */
public class NPC_anziano extends umani{
    public NPC_anziano(Pannello p) {
        super(p);
        
        direzione="giu";
        velocita=1;
    }
    
    public void getImmagineG() {
        su1 = setup("/immagini/npc/vsu1");
        su2 = setup("/immagini/npc/vsu2");
        giu1 = setup("/immagini/npc/vg1");
        giu2 = setup("/immagini/npc/vg2");
        sinistra1 = setup("/immagini/npc/vsinistra1");
        sinistra2 = setup("/immagini/npc/vsinistra2");
        destra1 = setup("/immagini/npc/gd1");
        destra2 = setup("/immagini/npc/gd2");
    }
}
