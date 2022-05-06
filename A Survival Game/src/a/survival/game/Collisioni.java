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
    public int ControllaOGG(umani u, boolean giocatore) {
        int ind=999;
        for (int i = 0; i < p.ogg.length; i++) {
            if(p.ogg[i]!=null) {
                u.AreaS.x=u.Mondox+u.AreaS.x;
                u.AreaS.y=u.Mondoy+u.AreaS.y;
                
                p.ogg[i].SArea.x=p.ogg[i].mondox+p.ogg[i].SArea.x;
                p.ogg[i].SArea.y=p.ogg[i].mondoy+p.ogg[i].SArea.y;
                
                switch(u.direzione) {
                    case"su":
                        u.AreaS.y-=u.velocita;
                        if(u.AreaS.intersects(p.ogg[i].SArea)) {
                            System.out.println("su coll");
                        }
                        break;
                    case"giu":
                        u.AreaS.y+=u.velocita;
                        if(u.AreaS.intersects(p.ogg[i].SArea)) {
                            System.out.println("giu coll");
                        }
                        break;
                    case"destra":
                        u.AreaS.x+=u.velocita;
                        if(u.AreaS.intersects(p.ogg[i].SArea)) {
                            System.out.println("destra coll");
                        }
                        break;
                    case"sinistra":
                        u.AreaS.x-=u.velocita;
                        if(u.AreaS.intersects(p.ogg[i].SArea)) {
                            System.out.println("sinistra coll");
                        }
                        break;
                }
            }
        }
        return ind;
    }
}
