package a.survival.game;

import Umani.umani;

/**
 *
 * @author Denis
 */
public class Collisioni {
    Pannello p;
    public Collisioni(Pannello p) {
        this.p=p;
    }
    
    public void Controlla(umani u) {
        int umaniSX=u.Mondox+u.AreaS.x;
        int umaniDX = u.Mondox + u.AreaS.x + u.AreaS.width;
        int umaniSUY = u.Mondoy + u.AreaS.y;
        int umaniGUY = u.Mondoy + u.AreaS.y + u.AreaS.height;
        
        int umaniSC=umaniSX/p.FinalAP;
        int umaniRC = umaniDX / p.FinalAP;
        int umaniSUR = umaniSUY / p.FinalAP;
        int umaniGUR = umaniGUY / p.FinalAP;
        
        int NB1, NB2;
        
        switch(u.direzione) {
            case "su":
                umaniSUR=(umaniSUY-u.velocita)/p.FinalAP;
                NB1=p.GB.Nmappe[umaniSC][umaniSUR];
                NB2=p.GB.Nmappe[umaniRC][umaniSUR];
                if(p.GB.blocchi[NB1].collisioni==true||p.GB.blocchi[NB2].collisioni==true) {
                    u.collisioniSI=true;
                }
                break;
            case "giu":
                umaniGUR = (umaniGUY + u.velocita) / p.FinalAP;
                NB1 = p.GB.Nmappe[umaniSC][umaniGUR];
                NB2 = p.GB.Nmappe[umaniRC][umaniGUR];
                if (p.GB.blocchi[NB1].collisioni == true || p.GB.blocchi[NB2].collisioni == true) {
                    u.collisioniSI = true;
                }
                break;
            case "sinistra":
                umaniSC = (umaniSX - u.velocita) / p.FinalAP;
                NB1 = p.GB.Nmappe[umaniSC][umaniSUR];
                NB2 = p.GB.Nmappe[umaniSC][umaniGUR];
                if (p.GB.blocchi[NB1].collisioni == true || p.GB.blocchi[NB2].collisioni == true) {
                    u.collisioniSI = true;
                }
                break;
            case "destra":
                umaniRC = (umaniDX + u.velocita) / p.FinalAP;
                NB1 = p.GB.Nmappe[umaniRC][umaniSUR];
                NB2 = p.GB.Nmappe[umaniRC][umaniGUR];
                if (p.GB.blocchi[NB1].collisioni == true || p.GB.blocchi[NB2].collisioni == true) {
                    u.collisioniSI = true;
                }
                break;
        }
    }
}
