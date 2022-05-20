/**
 * @author Pugliano Denis, Occhiato Andrea
 * @version 1.0
 * @file slime.java
 * @brief Classe per settare gli npc nemici slime
 */

package Entita;

import a.survival.game.Pannello;

/**
 * @class slime
 * @brief Classe con extends Mob
 */
public class Slime extends Mob {
    public Slime(Pannello p) {
        super(p,"Slime",1);
        /**
         * tipo npc
         */
        type = 2;

        nome = "Slime Verde";
        /**
         * velocità slime
         */
        velocita = 4;
        /**
         * vita massima dello slime
         */
        VitaMax = 4;
        vita = VitaMax;

        /**
         * settaggi per Area collisioni
         */
        SArea.x = 3;
        SArea.y = 18;
        SArea.width = 42;
        SArea.height = 30;
        AreaSX = SArea.x;
        AreaSY = SArea.y;
        getImage();
    }

    /**
     * \brief setto le immagini dell'ape
     */
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
