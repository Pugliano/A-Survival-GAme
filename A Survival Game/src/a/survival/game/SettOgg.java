package a.survival.game;

import Nemici.MONslime;
import Umani.NPC_anziano;
import oggetti.OGGpozzo;

/**
 *
 * @author Denis
 */
public class SettOgg {
    Pannello p;
    
    public SettOgg(Pannello p) {
        this.p=p;
    }
    
    public void setNpc() {
        //npc anziano
        p.npc[0]=new NPC_anziano(p);
        p.npc[0].Mondox=p.FinalAP*55;
        p.npc[0].Mondoy=p.FinalAP*93;
        p.npc[0].collisioniSI=true;
    }
    
    public void setNemici() {
        p.nemici[0]=new MONslime(p);
        p.nemici[0].Mondox=p.FinalAP*56;
        p.nemici[0].Mondoy=p.FinalAP*93;
        
        p.nemici[1] = new MONslime(p);
        p.nemici[1].Mondox = p.FinalAP * 57;
        p.nemici[1].Mondoy = p.FinalAP * 93;
    }
}
