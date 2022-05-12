package a.survival.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Denis
 */
public class Tastiera implements KeyListener {

    Pannello p;
    public boolean su, giu, sinistra, destra;

    public Tastiera(Pannello p) {
        this.p = p;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int tasto = e.getKeyCode();

        //menu
        
        if (p.pausaG == p.menuS)
        {
            if (tasto == KeyEvent.VK_UP) {
                if (p.messaggi.comandi!=0)
                {
                    p.messaggi.comandi--;
                }
            }
            if (tasto == KeyEvent.VK_DOWN) {
                if (p.messaggi.comandi!=2)
                {
                    p.messaggi.comandi++;
                }
            }
            if (tasto == KeyEvent.VK_ENTER) {
                switch(p.messaggi.comandi)
                {
                    case 0:
                        System.out.println("nuova partita");
                        p.pausaG=p.pausaP;
                        break;
                    case 1:
                        System.out.println("carica partita");
                        break;
                    case 2:
                        System.out.println("esci");
                        System.exit(0);
                        break;
                    default:
                        break;
                }
            }
        }
        
        //gioco
        
        if (p.pausaG == p.pausaP) {
            if (tasto == KeyEvent.VK_W) {
                su = true;
            }

            if (tasto == KeyEvent.VK_S) {
                giu = true;
            }

            if (tasto == KeyEvent.VK_A) {
                sinistra = true;
            }

            if (tasto == KeyEvent.VK_D) {
                destra = true;
            }

            if (tasto == KeyEvent.VK_P) {
                if (p.pausaG == p.pausaP) {
                    p.pausaG = p.pausaPa;
                } else if (p.pausaG == p.pausaPa) {
                    p.pausaG = p.pausaP;
                }
            }
            
            if (tasto == KeyEvent.VK_ESCAPE) {
                p.pausaG=p.menuS;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int tasto = e.getKeyCode();

        if (tasto == KeyEvent.VK_W) {
            su = false;
        }

        if (tasto == KeyEvent.VK_S) {
            giu = false;
        }

        if (tasto == KeyEvent.VK_A) {
            sinistra = false;
        }

        if (tasto == KeyEvent.VK_D) {
            destra = false;
        }
    }

}
