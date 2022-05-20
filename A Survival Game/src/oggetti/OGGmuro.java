/**
 * @author Pugliano Denis, Occhiato Andrea
 * @version 1.0
 * @file OGGmuro.java
 * @brief Classe per implementare l'immaginr del muro nel gioco
 */

package oggetti;

import Entita.Entita;
import a.survival.game.Pannello;

/**
 * @class OGGmuro
 * @brief Classe con extends Entita
 */
public class OGGmuro extends Entita{
    
    /**
     * \brief Costruttore parametrico
     *
     * @param p
     */
    public OGGmuro(Pannello p) {
        super(p);
        nome = "muro";
        giu1 = setup("/immagini/oggetti/wall", p.FinalAP, p.FinalAP);
        collisioni = true;
    }
}
