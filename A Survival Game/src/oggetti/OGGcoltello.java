/**
 * @author Pugliano Denis, Occhiato Andrea
 * @version 1.0
 * @file OGGcoltello.java
 * @brief Classe per implementare l'immagine del coltellino svizzero nel gioco
 */

package oggetti;

import Entita.Entita;
import a.survival.game.Pannello;


/**
 * @class OGGcoltello
 * @brief Classe con extends Entita
 */
public class OGGcoltello extends Entita{
    
    /**
     * \brief Costruttore parametrico
     *
     * @param p
     */
    public OGGcoltello(Pannello p) {
        super(p);
        nome="coltello";
        giu1=setup("/immagini/oggetti/cs",p.FinalAP,p.FinalAP);
    }
}
