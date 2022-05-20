/**
 * @author Pugliano Denis, Occhiato Andrea
 * @version 1.0
 * @file Orario.java
 * @brief Classe Per gestire oarario
 */

package a.survival.game;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @class Orario
 * @brief extends Thread
 */
public class Orario extends Thread {

    Pannello p;
    public int ora;
    public int min;
    public int giorno=0;
    public Interfaccia inter=new Interfaccia(p);

    /**\brief
     * Costruttore Parametrico
     * @param p
     * @param ora
     * @param min 
     */
    public Orario(Pannello p, int ora, int min) {
        this.p = p;
        this.ora = ora;
        this.min = min;
    }

    @Override
    public void run() {
        while (true) {
            aggiornaTempo();
        }
    }

    public String ora() {
        String temp = "Ora: ";
        if (ora < 10) {
            temp += "0" + ora + " : ";
        } else {
            temp += ora + " : ";
        }
        if (min < 10) {
            temp += "0" + min + ".";
        } else {
            temp += min + ".";
        }
        return temp;
    }

    /**\brief
     * Aggiorno le ore nel gioco
     */
    public void aggiornaTempo() {
        try {
            sleep(125); //1 min di gioco
        } catch (InterruptedException ex) {
            Logger.getLogger(Orario.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (min == 59) {
            min = 0;
            if (ora == 23) {
                giorno++;
                ora = 0;
            } else {
                ora++;
            }
        } else {
            min++;
        }
        if(giorno==2) {
            p.messaggi.Fine=true;
            inter.drawFineGioco();
            p.stopMusica();
        }
    }
    
    public int getOra()
    {
        return ora;
    }
    
    public int getMin()
    {
        return min;
    }
}
