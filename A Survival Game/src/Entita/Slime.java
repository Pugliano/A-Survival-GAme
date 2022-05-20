/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entita;

import a.survival.game.Pannello;

/**
 *
 * @author occhiato_andrea
 */
public class Slime extends Mob {

    public Slime(Pannello p) {
        super(p, "Slime", 2);
        type = 2;
        velocita = 1;
        VitaMax = 4;
        vita = VitaMax;
        SArea.x = 5;
        SArea.y = 18;
        SArea.width = 2;
        SArea.height = 2;
        AreaSX = SArea.x;
        AreaSY = SArea.y;
        getImage();
    }

    public void getImage() {
        su1 = setup("/immagini/nemici/slime_giu1", p.FinalAP, p.FinalAP);
        su2 = setup("/immagini/nemici/slime_giu2", p.FinalAP, p.FinalAP);
        giu1 = setup("/immagini/nemici/slime_giu1", p.FinalAP, p.FinalAP);
        giu2 = setup("/immagini/nemici/slime_giu2", p.FinalAP, p.FinalAP);
        sinistra1 = setup("/immagini/nemici/slime_giu1", p.FinalAP, p.FinalAP);
        sinistra2 = setup("/immagini/nemici/slime_giu2", p.FinalAP, p.FinalAP);
        destra1 = setup("/immagini/nemici/slime_giu1", p.FinalAP, p.FinalAP);
        destra2 = setup("/immagini/nemici/slime_giu2", p.FinalAP, p.FinalAP);
    }

}
