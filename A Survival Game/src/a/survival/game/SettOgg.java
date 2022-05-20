package a.survival.game;

import Nemici.MONape;
import Nemici.MONslime;
import Umani.NPC_anziano;
import oggetti.OGGcartello;
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
    
    public void setoggetto() {
        //cartello
        p.ogg[0]=new OGGcartello(p);
        p.ogg[0].Mondox=p.FinalAP*54;
        p.ogg[0].Mondoy=p.FinalAP*132;
        p.ogg[0].collisioniSI=true;
    }
    
    public void setNpc() {
        //npc anziano
        p.npc[0]=new NPC_anziano(p,true);
        p.npc[0].Mondox=p.FinalAP*56;
        p.npc[0].Mondoy=p.FinalAP*137;
        p.npc[0].collisioniSI=true;
        
        p.npc[1]=new NPC_anziano(p,false);
        p.npc[1].Mondox=p.FinalAP*55;
        p.npc[1].Mondoy=p.FinalAP*93;
        p.npc[1].collisioniSI=true;
    }
    
    public void setNemici() {
        p.nemici[0]=new MONslime(p);
        p.nemici[0].Mondox=p.FinalAP*56;
        p.nemici[0].Mondoy=p.FinalAP*93;
        
        p.nemici[1] = new MONslime(p);
        p.nemici[1].Mondox = p.FinalAP * 57;
        p.nemici[1].Mondoy = p.FinalAP * 93;
        
        p.nemici[2] = new MONape(p);
        p.nemici[2].Mondox = p.FinalAP * 58;
        p.nemici[2].Mondoy = p.FinalAP * 93;
        
        p.nemici[3] = new MONape(p);
        p.nemici[3].Mondox = p.FinalAP * 59;
        p.nemici[3].Mondoy = p.FinalAP * 93;
    }
}
