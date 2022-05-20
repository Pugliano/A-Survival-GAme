/**
 * @author Pugliano Denis, Occhiato Andrea
 * @version 1.0
 * @file Suoni.java
 * @brief Classe Per implementare i suoni e gli effetti vocali
 */

package a.survival.game;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * @class Suoni
 */
public class Suoni {
    Clip c;
    URL suonoURL[]=new URL[30];
    
    /**\brief
     * setto i suoni per il gioco creando una matrice da 30 elementi(ho esagerato)
     */
    public Suoni() {
        suonoURL[0] = getClass().getResource("/immagini/suoni/song.wav");
        suonoURL[1] = getClass().getResource("/immagini/suoni/cibo.wav");
        suonoURL[2] = getClass().getResource("/immagini/suoni/coltello.wav");
        suonoURL[3] = getClass().getResource("/immagini/suoni/porta.wav");
        suonoURL[4] = getClass().getResource("/immagini/suoni/casse.wav");
    }
    
    /**\brief
     * uso questo metodo per aprire il file e far partire il suono
     * @param i 
     */
    public void setFile(int i) {
        try{
            AudioInputStream inputA=AudioSystem.getAudioInputStream(suonoURL[i]);
            c=AudioSystem.getClip();
            c.open(inputA);
        }catch(Exception e) {
            
        }
    }
    
    /**\brief
     * faccio partire la musica
     */
    public void vai() {
        c.start();
    }
    
    /**
     * \brief tengo in loop la musica
     */
    public void loop() {
        c.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    /**
     * \brief faccio fermare la musica
     */
    public void stop() {
        c.stop();
    }
}
