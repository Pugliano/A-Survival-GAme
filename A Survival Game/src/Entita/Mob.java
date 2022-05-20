/**
 * @author Pugliano Denis, Occhiato Andrea
 * @version 1.0
 * @file Mob.java
 * @brief Classe per settare Tutte le impostazione dei mob ostili
 */

package Entita;

import a.survival.game.Pannello;
import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @class Mob
 * @brief Classe con extends Entita
 */
public class Mob extends Entita {

    int danno;

    /**\brief
     * Costruttore parametrico
     * @param p
     * @param nome
     * @param danno 
     */
    public Mob(Pannello p, String nome, int danno) {
        super(p);
        this.nome = nome;
        this.danno = danno;
        type = 2;
        velocita = 5;
        VitaMax = 4;
        vita = VitaMax;
    }

    /**\brief
     * Metod run per tutti i mob
     */
    @Override
    public void run() {
        while (true) {
            if (p.state != p.gioco) {
                continue;
            }
            muovi();
            try {
                sleep(16);
            } catch (InterruptedException ex) {
                Logger.getLogger(NPC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**\brief
     * Metodo per far muovere random tutti i mob nella mappa
     */
    @Override
    public void setMove() {
        VelocitaM++;
        if (VelocitaM == 50) {
            Random random = new Random();
            int i = random.nextInt(100) + 1;

            if (i <= 25) {
                direzione = "su";
            }
            if (i > 25 && i <= 50) {
                direzione = "giu";
            }
            if (i > 50 && i <= 75) {
                direzione = "sinistra";
            }
            if (i > 75 && i <= 100) {
                direzione = "destra";
            }
            VelocitaM = 0;
        }
    }
    
    public int calcoloDistanzaX() {
        return (int) abs(p.player.x - x);
    }

    public int calcoloDistanzaY() {
        return (int) abs(p.player.y - y);
    }

    public int calcoloDistanza() {
        return (int) sqrt((calcoloDistanzaX() * calcoloDistanzaX()) + (calcoloDistanzaY() * calcoloDistanzaY()));
    }

    /**\brief
     * Metodo per mandare tutti i mob verso il giocatore
     */
    public void versoGiocatore() {
        if ((p.player.x - x) > 1) {
            direzione = "destra";
        } else if ((p.player.x - x) < 1) {
            direzione = "sinistra";
        } else if ((p.player.y - y) > 1) {
            direzione = "giu";
        } else if ((p.player.y - y) < 1) {
            direzione = "su";
        }
    }
}
