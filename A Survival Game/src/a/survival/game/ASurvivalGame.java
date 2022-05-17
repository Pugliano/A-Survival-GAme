package a.survival.game;

import javax.swing.JFrame;

/**
 *
 * @author Denis
 */
public class ASurvivalGame {

    public static JFrame finestra;
            
    public static void main(String[] args) {
        finestra=new JFrame();
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setResizable(false);
        finestra.setTitle("A Survival Game");
        finestra.setUndecorated(true);
        
        Pannello pannello = new Pannello();
        finestra.add(pannello);
        
        finestra.pack();
        
        finestra.setLocationRelativeTo(null);
        finestra.setVisible(true);
        
        pannello.setGioco();
        pannello.startGameThread();
        
    }
    
}
