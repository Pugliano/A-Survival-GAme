package a.survival.game;

import oggetti.OGGcoltello;

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
      p.ogg[0]=new OGGcoltello(p);
      p.ogg[0].mondox=54*p.FinalAP;
      p.ogg[0].mondoy=135*p.FinalAP;
    }
}
