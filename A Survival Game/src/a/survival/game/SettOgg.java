package a.survival.game;

import oggetti.OGGcassa;
import oggetti.OGGcoltello;
import oggetti.OGGmela;
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
        p.ogg[0]=new OGGcoltello();
        p.ogg[0].mondox= 23*p.FinalAP;
        p.ogg[0].mondoy= 13*p.FinalAP;
        
        p.ogg[1] = new OGGporta();
        p.ogg[1].mondox = 59 * p.FinalAP;
        p.ogg[1].mondoy = 58 * p.FinalAP;
        
        p.ogg[3] = new OGGporta();
        p.ogg[3].mondox = 58 * p.FinalAP;
        p.ogg[3].mondoy = 58 * p.FinalAP;
        
        p.ogg[2] = new OGGcassa();
        p.ogg[2].mondox = 62 * p.FinalAP;
        p.ogg[2].mondoy = 62 * p.FinalAP;
        
        p.ogg[4] = new OGGmela();
        p.ogg[4].mondox = 24 * p.FinalAP;
        p.ogg[4].mondoy = 13 * p.FinalAP;
        
        p.ogg[5] = new OGGcoltello();
        p.ogg[5].mondox = 23 * p.FinalAP;
        p.ogg[5].mondoy = 14 * p.FinalAP;
        
    }
}
