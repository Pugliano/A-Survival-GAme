/**
 * @author Pugliano Denis, Occhiato Andrea
 * @version 1.0
 * @file Ape.java
 * @brief Classe per settare l'immagine dell'ape
 */

package Entita;

import a.survival.game.Pannello;

/**
 * @class Ape
 * @brief Classe con extends Mob
 */
public class Ape extends Mob {

    /**\brief
     * Costruttore parametrico
     * @param p 
     */
    public Ape(Pannello p) {
        super(p, "Ape", 1);
        /**tipo npc*/
        type = 2;
        /**velocità ape*/
        velocita = 3;
        /**vita massima dell'ape*/
        VitaMax = 4;
        vita = VitaMax;
        /**settaggi per Area collisioni*/
        SArea.x = 5;
        SArea.y = 18;
        SArea.width = 2;
        SArea.height = 2;
        AreaSX = SArea.x;
        AreaSY = SArea.y;
        /**richiamo metodo getImage*/
        getImage();
    }

    /**\brief
     * setto le immagini dell'ape
     */
    public void getImage() {
        su1 = setup("/immagini/nemici/agiu1", p.FinalAP, p.FinalAP);
        su2 = setup("/immagini/nemici/agiu2", p.FinalAP, p.FinalAP);
        giu1 = setup("/immagini/nemici/agiu3", p.FinalAP, p.FinalAP);
        giu2 = setup("/immagini/nemici/agiu4", p.FinalAP, p.FinalAP);
        sinistra1 = setup("/immagini/nemici/agiu1", p.FinalAP, p.FinalAP);
        sinistra2 = setup("/immagini/nemici/agiu2", p.FinalAP, p.FinalAP);
        destra1 = setup("/immagini/nemici/agiu3", p.FinalAP, p.FinalAP);
        destra2 = setup("/immagini/nemici/agiu4", p.FinalAP, p.FinalAP);
    }

}
