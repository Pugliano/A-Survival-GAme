/**
 * @author Pugliano Denis, Occhiato Andrea
 * @version 1.0
 * @file ASurvivalGame.java
 * @brief Classe Main
 */

package a.survival.game;

import javax.swing.JFrame;

/**
 * @class ASurvivalGame
 */
public class ASurvivalGame {

    /**Creo JFrame*/
    public static JFrame finestra;
            
    /**\brief
     * Classe main dove creo una JFrame con titolo e passo tutti i metodi che servono per avviare il gioco
     * @param args 
     */
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
