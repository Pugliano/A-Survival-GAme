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
    private int oraprec;
    public int min;

    public Orario(Pannello p, int ora, int min) {
        this.p = p;
        this.ora = ora;
        this.min = min;
        this.oraprec = ora;
    }

    @Override
    public void run() {
        while (true) {
            //if (p.state==p.gioco) {
            aggiornaTempo();
            p.messaggi.drawOra(ora());
            System.out.println(ora());
            if (oraprec != ora) {
                oraprec = ora;
                aggiornaMappa();
            }
            //}
        }
    }

    private String ora() {
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

    private void aggiornaMappa() {
        switch (ora) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
            case 14:
                break;
            case 15:
                break;
            case 16:
                break;
            case 17:
                break;
            case 18:
                break;
            case 19:
                break;
            case 20:
                break;
            case 21:
                break;
            case 22:
                break;
            case 23:
                break;
        }
    }

}
