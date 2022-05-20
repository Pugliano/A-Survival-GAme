/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nemici;

import a.survival.game.Pannello;

/**
 *
 * @author occhiato_andrea
 */
public class Ape extends Mob{   
    
    public Ape(Pannello p) {
       super(p, "Ape", 1);
    }
    
    public void getImage() {
        su1 = setup("/immagini/nemici/agiu1",p.FinalAP,p.FinalAP);
        su2 = setup("/immagini/nemici/agiu2",p.FinalAP,p.FinalAP);
        giu1 = setup("/immagini/nemici/agiu3",p.FinalAP,p.FinalAP);
        giu2 = setup("/immagini/nemici/agiu4",p.FinalAP,p.FinalAP);
        sinistra1 = setup("/immagini/nemici/agiu1",p.FinalAP,p.FinalAP);
        sinistra2 = setup("/immagini/nemici/agiu2",p.FinalAP,p.FinalAP);
        destra1 = setup("/immagini/nemici/agiu3",p.FinalAP,p.FinalAP);
        destra2 = setup("/immagini/nemici/agiu4",p.FinalAP,p.FinalAP);
    }
    
}
