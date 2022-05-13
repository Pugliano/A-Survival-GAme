package Umani;

import a.survival.game.Pannello;

/**
 *
 * @author Andrea
 */
public class NPC_anziano extends umani{
    public NPC_anziano(Pannello p) {
        super(p);
        
        direzione="giu";
        velocita=1;
        
        getImmagineV();
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
}
