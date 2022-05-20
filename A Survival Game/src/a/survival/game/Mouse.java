/**
 * @author Pugliano Denis, Occhiato Andrea
 * @version 1.0
 * @file Mouse.java
 * @brief Classe Per gestire mouse
 */

package a.survival.game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * @class Mouse
 * @brief implements MouseListener e MouseMotionListener
 */
public class Mouse implements MouseListener, MouseMotionListener{

    Pannello p;

    public Mouse(Pannello p) {
        this.p = p;
    }
    
    /**\brief
     * Al click del mouse se nel menù vai nel gioco in base al tasto selezionato con mause Moved
     * @param e 
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (p.state == p.menu) {
            p.messaggi.mouseClicked(e);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (p.state == p.menu) {
            p.messaggi.mouseMoved(e);
        }
    }
    
}
