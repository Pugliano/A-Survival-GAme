package a.survival.game;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author occhiato_andrea
 */
public class Orario extends Thread {

    Pannello p;
    public int ora;
    public int min;

    public Orario(Pannello p, int ora, int min) {
        this.p = p;
        this.ora = ora;
        this.min = min;
    }

    @Override
    public void run() {
        while (true) {
            //if (p.state==p.gioco) {
            aggiornaTempo();
            //}
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

    public void aggiornaTempo() {
        try {
            sleep(125); //1 min di gioco
        } catch (InterruptedException ex) {
            Logger.getLogger(Orario.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (min == 59) {
            min = 0;
            if (ora == 23) {
                ora = 0;
            } else {
                ora++;
            }
        } else {
            min++;
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
