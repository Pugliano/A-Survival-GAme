/**
 * @author Pugliano Denis, Occhiato Andrea
 * @version 1.0
 * @file OGGspada.java
 * @brief
 * Classe per implementare l'immaginr della spada nel gioco
 */

package oggetti;

import Entita.Entita;
import a.survival.game.Pannello;

/**
 * @class OGGspada
 * @brief
 * Classe con extends Entita
 */
public class OGGspada extends Entita{
    
    /**\brief
     * Costruttore parametrico
     * @param p 
     */
    public OGGspada(Pannello p) {
        super(p);

        nome = "Spada";
        giu1 = setup("/immagini/oggetti/spada",p.FinalAP,p.FinalAP);
        attaccoSpada = 4;
    }
}
