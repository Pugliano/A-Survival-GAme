package a.survival.game;

import Umani.NPC_anziano;

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
        
    }
    
    public void setNpc() {
        p.npc[0]=new NPC_anziano(p);
        p.npc[0].Mondox=p.FinalAP*55;
        p.npc[0].Mondoy=p.FinalAP*93;
        p.npc[0].collisioniSI=true;
    }
}
