/**
 * @author Pugliano Denis, Occhiato Andrea
 * @version 1.0
 * @file OGGcuore.java
 * @brief Classe per implementare l'immagine del cuore nel gioco
 */

package oggetti;

import Entita.Entita;
import a.survival.game.Pannello;
import a.survival.game.UtilityTool;

/**
 * @class OGGcuore
 * @brief Classe con extends Entita
 */
public class OGGcuore extends Entita{
    UtilityTool uTool=new UtilityTool();
    /**
     * \brief Costruttore parametrico
     *
     * @param p
     */
    public OGGcuore(Pannello p) {
        super(p);
        nome = "cuore";
        /**set immagine per cuore a meta*/
        image1 = setup("/immagini/oggetti/cuore_m",p.FinalAP,p.FinalAP);
        /**
         * set immagine per cuore peino
         */
        image2 = setup("/immagini/oggetti/cuore_p",p.FinalAP,p.FinalAP);
        /**
         * set immagine per cuore bianco
         */
        image3 = setup("/immagini/oggetti/cuore_b",p.FinalAP,p.FinalAP);
        
        
    }
}
