/**
 * @author Pugliano Denis, Occhiato Andrea
 * @version 1.0
 * @file Azioni.java
 * @brief Classe Per gestire le azioni fatte dal player
 */

package a.survival.game;

import java.awt.Rectangle;

/**
 * @class Azioni
 */
public class Azioni {
    Pannello p;
    Rectangle AzioniR;
    int AzioniRx,AzioniRy;
    
    /**\brief
     * Costruttore parametrico
     * @param p 
     */
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
    
    /**\brief
     * setto un azione a 54*132 e se vado in quel blocco e premo invio allora printa il messaggio
     */
    public void ControllaAzioni() {
        if (hit(54, 132, "su") == true) {
            //accade qual che accade
            Leggere(p.dialoghi);
            System.out.println("cartello");
        }
    }
    
    /**\brief
     * setto la x e la y dove posizionare l'azione
     * @param Azionicol
     * @param Azionirig
     * @param direzioneRic
     * @return 
     */
    public boolean hit(int Azionicol,int Azionirig,String direzioneRic) {
        boolean hit=false;
        p.player.SArea.x = p.player.x + p.player.SArea.x;
        p.player.SArea.y = p.player.y + p.player.SArea.y;
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
    
    /**\brief
     * Avendo un azione chiamata lava, questo metodo esiste per togliere vita al player se ci vado sopra
     * @param Azione 
     */
    public void dannoP(int Azione) {
        p.state=Azione;
        p.messaggi.Dcorrente="Lava";
        p.player.vita-=1;
    }
    
    /**
     * \brief Avendo un azione chiamata bere, questo metodo esiste per recuperare
     * vita al player se bevo acqua in un determinato punto
     *
     * @param Azione
     */
    public void Bere(int Azione) {
        if(p.tastiera.enterP==true) {
            p.state=Azione;
            p.messaggi.Dcorrente="Hai bevuto dell'acqua, vita ripristinata";
            p.player.vita=p.player.VitaMax;
        }
        p.tastiera.enterP=false;
    }
    
    /**
     * \brief Avendo un azione chiamata cartello, questo metodo esiste per
     * leggere le cose segnate sul oggetto cartello
     *
     * @param Azione
     */
    public void Leggere(int Azione) {
        if (p.tastiera.enterP == true) {
            p.state = Azione;
            p.messaggi.Dcorrente = "Sopravvivi 5 giorni per riuscire a scappare";
        }
        p.tastiera.enterP = false;
    }
}
