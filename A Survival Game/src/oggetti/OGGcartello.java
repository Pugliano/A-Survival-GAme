/**
 * @author Pugliano Denis, Occhiato Andrea
 * @version 1.0
 * @file OGGcartello.java
 * @brief Classe per implementare l'immagine di un cartello nel gioco
 */

package oggetti;

import Entita.Entita;
import a.survival.game.Pannello;

/**
 * @class OGGcoltello
 * @brief Classe con extends Entita
 */
public class OGGcartello extends Entita{
    /**
     * \brief Costruttore parametrico + set area collisioni
     *
     * @param p
     */
    public OGGcartello(Pannello p) {
        super(p);
        nome = "cartello";
        giu1 = setup("/immagini/oggetti/cartello",p.FinalAP,p.FinalAP);
        collisioni = true;

        SArea.x = 1;
        SArea.y = 0;
        SArea.width = 31;
        SArea.height = 15;
        AreaSX = SArea.x;
        AreaSY = SArea.y;
    }
}
