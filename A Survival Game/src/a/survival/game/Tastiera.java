package a.survival.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Denis
 */
public class Tastiera implements KeyListener{

    Pannello p;
    public boolean su,giu,sinistra,destra;
    
    public Tastiera(Pannello p) {
        this.p=p;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int tasto=e.getKeyCode();
        
        if(tasto == KeyEvent.VK_W) {
            su=true;
        }
        
        if (tasto == KeyEvent.VK_S) {
            giu=true;
        }
        
        if (tasto == KeyEvent.VK_A) {
            sinistra=true;
        }
        
        if (tasto == KeyEvent.VK_D) {
            destra=true;
        }
        
        if (tasto == KeyEvent.VK_P) {
            if(p.pausaG==p.pausaP) {
                p.pausaG=p.pausaPa;
            }else if(p.pausaG==p.pausaPa) {
                p.pausaG=p.pausaP;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int tasto=e.getKeyCode();
        
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
