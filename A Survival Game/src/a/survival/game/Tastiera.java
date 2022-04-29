package a.survival.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Denis
 */
public class Tastiera implements KeyListener{

    public boolean su,giu,sinistra,destra;
    
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
