package a.survival.game;

import Umani.NPC_anziano;
import oggetti.OGGmuro;
import oggetti.OGGporta;

/**
 *
 * @author Denis
 */
public class SettOgg {
    Pannello p;
    
    public SettOgg(Pannello p) {
        this.p=p;
    }
    
    public void setoggetto() {
        //2 porte
        p.ogg[0] = new OGGporta(p);
        p.ogg[0].mondox = p.FinalAP * 100;
        p.ogg[0].mondoy = p.FinalAP * 70;

        p.ogg[1] = new OGGporta(p);
        p.ogg[1].mondox = p.FinalAP * 99;
        p.ogg[1].mondoy = p.FinalAP * 70;

        //mura
        p.ogg[2] = new OGGmuro(p);  
        p.ogg[2].mondox = p.FinalAP * 98;
        p.ogg[2].mondoy = p.FinalAP * 70;
        
        p.ogg[3] = new OGGmuro(p);
        p.ogg[3].mondox = p.FinalAP * 101;
        p.ogg[3].mondoy = p.FinalAP * 70;
        
        p.ogg[4] = new OGGmuro(p);
        p.ogg[4].mondox = p.FinalAP * 97;
        p.ogg[4].mondoy = p.FinalAP * 70;
        
        p.ogg[5] = new OGGmuro(p);
        p.ogg[5].mondox = p.FinalAP * 102;
        p.ogg[5].mondoy = p.FinalAP * 70;
        
        p.ogg[6] = new OGGmuro(p);
        p.ogg[6].mondox = p.FinalAP * 96;
        p.ogg[6].mondoy = p.FinalAP * 70;
        
        p.ogg[7] = new OGGmuro(p);
        p.ogg[7].mondox = p.FinalAP * 103;
        p.ogg[7].mondoy = p.FinalAP * 70;
        
        p.ogg[8] = new OGGmuro(p);
        p.ogg[8].mondox = p.FinalAP * 104;
        p.ogg[8].mondoy = p.FinalAP * 70;
        
        p.ogg[9] = new OGGmuro(p);
        p.ogg[9].mondox = p.FinalAP * 95;
        p.ogg[9].mondoy = p.FinalAP * 70;
        
        p.ogg[10] = new OGGmuro(p);
        p.ogg[10].mondox = p.FinalAP * 95;
        p.ogg[10].mondoy = p.FinalAP * 69;
        
        p.ogg[11] = new OGGmuro(p);
        p.ogg[11].mondox = p.FinalAP * 104;
        p.ogg[11].mondoy = p.FinalAP * 69;
        
        p.ogg[12] = new OGGmuro(p);
        p.ogg[12].mondox = p.FinalAP * 95;
        p.ogg[12].mondoy = p.FinalAP * 68;
        
        p.ogg[13] = new OGGmuro(p);
        p.ogg[13].mondox = p.FinalAP * 104;
        p.ogg[13].mondoy = p.FinalAP * 68;
        
        p.ogg[14] = new OGGmuro(p);
        p.ogg[14].mondox = p.FinalAP * 95;
        p.ogg[14].mondoy = p.FinalAP * 67;

        p.ogg[15] = new OGGmuro(p);
        p.ogg[15].mondox = p.FinalAP * 95;
        p.ogg[15].mondoy = p.FinalAP * 66;
        
        p.ogg[16] = new OGGmuro(p);
        p.ogg[16].mondox = p.FinalAP * 95;
        p.ogg[16].mondoy = p.FinalAP * 65;

        p.ogg[17] = new OGGmuro(p);
        p.ogg[17].mondox = p.FinalAP * 95;
        p.ogg[17].mondoy = p.FinalAP * 64;
        
        p.ogg[18] = new OGGmuro(p);
        p.ogg[18].mondox = p.FinalAP * 95;
        p.ogg[18].mondoy = p.FinalAP * 63;

        p.ogg[19] = new OGGmuro(p);
        p.ogg[19].mondox = p.FinalAP * 95;
        p.ogg[19].mondoy = p.FinalAP * 62;

        p.ogg[20] = new OGGmuro(p);
        p.ogg[20].mondox = p.FinalAP * 95;
        p.ogg[20].mondoy = p.FinalAP * 61;
        
        p.ogg[21] = new OGGmuro(p);
        p.ogg[21].mondox = p.FinalAP * 95;
        p.ogg[21].mondoy = p.FinalAP * 60;

        p.ogg[22] = new OGGmuro(p);
        p.ogg[22].mondox = p.FinalAP * 95;
        p.ogg[22].mondoy = p.FinalAP * 59;

        p.ogg[23] = new OGGmuro(p);
        p.ogg[23].mondox = p.FinalAP * 95;
        p.ogg[23].mondoy = p.FinalAP * 58;
        
        p.ogg[24] = new OGGmuro(p);
        p.ogg[24].mondox = p.FinalAP * 95;
        p.ogg[24].mondoy = p.FinalAP * 57;

        p.ogg[25] = new OGGmuro(p);
        p.ogg[25].mondox = p.FinalAP * 95;
        p.ogg[25].mondoy = p.FinalAP * 56;

        p.ogg[26] = new OGGmuro(p);
        p.ogg[26].mondox = p.FinalAP * 95;
        p.ogg[26].mondoy = p.FinalAP * 55;
        
        p.ogg[27] = new OGGmuro(p);
        p.ogg[27].mondox = p.FinalAP * 95;
        p.ogg[27].mondoy = p.FinalAP * 54;

        p.ogg[28] = new OGGmuro(p);
        p.ogg[28].mondox = p.FinalAP * 95;
        p.ogg[28].mondoy = p.FinalAP * 53;

        p.ogg[29] = new OGGmuro(p);
        p.ogg[29].mondox = p.FinalAP * 95;
        p.ogg[29].mondoy = p.FinalAP * 52;

        p.ogg[30] = new OGGmuro(p);
        p.ogg[30].mondox = p.FinalAP * 95;
        p.ogg[30].mondoy = p.FinalAP * 51;

        p.ogg[31] = new OGGmuro(p);
        p.ogg[31].mondox = p.FinalAP * 95;
        p.ogg[31].mondoy = p.FinalAP * 50;
        
        p.ogg[32] = new OGGmuro(p);
        p.ogg[32].mondox = p.FinalAP * 95;
        p.ogg[32].mondoy = p.FinalAP * 49;

        p.ogg[33] = new OGGmuro(p);
        p.ogg[33].mondox = p.FinalAP * 96;
        p.ogg[33].mondoy = p.FinalAP * 49;
        
    }
    
    public void setNpc() {
        //npc anziano
        p.npc[0]=new NPC_anziano(p);
        p.npc[0].Mondox=p.FinalAP*55;
        p.npc[0].Mondoy=p.FinalAP*93;
        p.npc[0].collisioniSI=true;
        
        
    }
}
