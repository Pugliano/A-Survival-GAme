/**
 * @author Pugliano Denis, Occhiato Andrea
 * @version 1.0
 * @file OGGscudo.java
 * @brief Classe per implementare l'immaginr dello scudo nel gioco
 */

package oggetti;

import Entita.Entita;
import a.survival.game.Pannello;

/**
 * @class OGGscudo
 * @brief Classe con extends Entita
 */
public class OGGscudo extends Entita{
    
    /**
     * \brief Costruttore parametrico
     *
     * @param p
     */
    public OGGscudo(Pannello p) {
        super(p);

        nome = "scudo";
        giu1 = setup("/immagini/oggetti/scudo", p.FinalAP, p.FinalAP);
        difesaScudo = 1;
    }
}
