/**
 * @author Pugliano Denis, Occhiato Andrea
 * @version 1.0
 * @file OGGmela.java
 * @brief Classe per implementare l'immagine di una mela nel gioco
 */

package oggetti;

import Entita.Entita;
import a.survival.game.Pannello;

/**
 * @class OGGmela
 * @brief Classe con extends Entita
 */
public class OGGmela extends Entita{
    
    /**
     * \brief Costruttore parametrico
     *
     * @param p
     */
    public OGGmela(Pannello p) {
        super(p);
        nome = "cassa";
        giu1 = setup("/immagini/oggetti/cassa", p.FinalAP, p.FinalAP);
        collisioni = true;
    }
}
