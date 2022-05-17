package a.survival.game;

import java.awt.Rectangle;

/**
 *
 * @author Denis
 */
public class Azioni {
    Pannello p;
    Rectangle AzioniR;
    int AzioniRx,AzioniRy;
    
    public Azioni(Pannello p) {
        this.p=p;
        
        AzioniR=new Rectangle();
        AzioniR.x=23;
        AzioniR.y=23;
        AzioniR.width=2;
        AzioniR.height=2;
        AzioniRx=AzioniR.x;
        AzioniRy = AzioniR.y;
    }
    
    public void ControllaAzioni() {
        if(hit(54,135,"su")==true) {
            //accade qual che accade
            dannoP(p.dialoghi);
            System.out.println("cade");
        }
        if (hit(51, 137, "sinistra") == true) {
            //accade qual che accade
            Bere(p.dialoghi);
            System.out.println("Acqua");
        }
    }
    
    public boolean hit(int Azionicol,int Azionirig,String direzioneRic) {
        boolean hit=false;
        p.player.SArea.x = p.player.Mondox + p.player.SArea.x;
        p.player.SArea.y = p.player.Mondoy + p.player.SArea.y;
        AzioniR.x = Azionicol * p.FinalAP + AzioniR.x;
        AzioniR.y = Azionirig * p.FinalAP + AzioniR.y;
        
        if(p.player.SArea.intersects(AzioniR)) {
            if(p.player.direzione.contentEquals(direzioneRic) || direzioneRic.contentEquals("any")) {
                hit=true;
            }
        }
        
        p.player.SArea.x=p.player.AreaSX;
        p.player.SArea.y = p.player.AreaSY;
        AzioniR.x = AzioniRx;
        AzioniR.y = AzioniRy;
        
        return hit;
    }
    
    public void dannoP(int Azione) {
        p.state=Azione;
        p.messaggi.Dcorrente="Lava";
        p.player.vita-=1;
    }
    
    public void Bere(int Azione) {
        if(p.tastiera.enterP==true) {
            p.state=Azione;
            p.messaggi.Dcorrente="Hai bevuto dell'acqua, vita ripristinata";
            p.player.vita=p.player.VitaMax;
        }
        p.tastiera.enterP=false;
    }
}
