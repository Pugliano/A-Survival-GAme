/**
 * @author Pugliano Denis, Occhiato Andrea
 * @version 1.0
 * @file OGGcassa.java
 * @brief Classe per implementare l'immagine di una cassa del tesoro nel gioco
 */

package oggetti;

import Entita.Entita;
import a.survival.game.Pannello;

/**
 * @class OGGcassa
 * @brief Classe con extends Entita
 */
public class OGGcassa extends Entita{
    
    /**
     * \brief Costruttore parametrico
     *
     * @param p
     */
    public OGGcassa(Pannello p) {
        super(p);
        nome = "cassa";
        giu1 = setup("/immagini/oggetti/cassa",p.FinalAP,p.FinalAP);
        collisioni=true;
    }
}
