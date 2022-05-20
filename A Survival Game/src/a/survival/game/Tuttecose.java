package a.survival.game;

import Entita.Entita;
import Entita.NPC_Anziano;
import oggetti.OGGcartello;
import oggetti.OGGpozzo;

/**
 *
 * @author Denis
 */
public class Tuttecose {
    Pannello p;
    
    public Tuttecose(Pannello p) {
        this.p=p;
    }
    
    public void setoggetto() {
        //cartello
        p.gestOgg.add(new OGGcartello(p));
        Entita temp = p.gestOgg.get(0);
        temp.x=p.FinalAP*54;
        temp.y=p.FinalAP*132;
        temp.collisioniSI=true;
        p.gestOgg.set(0, temp);
    }
    
    public void setNpc() {
        //npc anziano
        p.gestOgg.add(new NPC_Anziano(p,true));
        Entita temp = p.gestOgg.get(0);
        temp.x=p.FinalAP*56;
        temp.y=p.FinalAP*137;
        temp.collisioniSI=true;
        p.gestOgg.set(0, temp);
        
        p.gestOgg.add(new NPC_Anziano(p,false));
        temp = p.gestOgg.get(1);
        temp.x=p.FinalAP*55;
        temp.y=p.FinalAP*93;
        temp.collisioniSI=true;
        p.gestOgg.set(1, temp);
    }
    
    public void setNemici() {
        
        /*p.gestMob.add(new MONslime(p));
        p.nemici[0].x=p.FinalAP*56;
        p.nemici[0].y=p.FinalAP*93;
        
        p.nemici[1] = new MONslime(p);
        p.nemici[1].x = p.FinalAP * 57;
        p.nemici[1].y = p.FinalAP * 93;
        
        p.nemici[2] = new MONape(p);
        p.nemici[2].x = p.FinalAP * 58;
        p.nemici[2].y = p.FinalAP * 93;
        
        p.nemici[3] = new MONape(p);
        p.nemici[3].x = p.FinalAP * 59;
        p.nemici[3].y = p.FinalAP * 93;*/
    }
}
