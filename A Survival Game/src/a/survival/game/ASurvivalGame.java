package a.survival.game;

import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;

/**
 *
 * @author Denis
 */
public class ASurvivalGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame finestra=new JFrame();
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setResizable(false);
        finestra.setTitle("A Survival Game");
        
        Pannello pannello = new Pannello();
        finestra.add(pannello);
        
        finestra.pack();
        
        finestra.setLocationRelativeTo(null);
        finestra.setVisible(true);
        
        pannello.setGioco();
        pannello.startGameThred();
        
    }
    
}
