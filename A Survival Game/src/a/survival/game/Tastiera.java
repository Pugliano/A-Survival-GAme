package a.survival.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Denis
 */
public class Tastiera implements KeyListener{

    Pannello p;
    public boolean su, giu, sinistra, destra;
    public boolean enterP;

    public Tastiera(Pannello p) {
        this.p = p;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int tasto = e.getKeyCode();
        enterP=false;
        
        //menu
        if (p.state==0)
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
                        p.state=1;
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
        else if (p.state==1) {
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
                p.setPausa(!p.getPausa());
            }
            
            if (tasto == KeyEvent.VK_ESCAPE) {
                p.state=0;
            } 
            if (tasto == KeyEvent.VK_ENTER) {
                enterP=true;
            }
        } 
        
        //parla con npc
        else if(p.state==p.dialoghi) {
            if (tasto == KeyEvent.VK_ENTER) {
                p.state=1;
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
