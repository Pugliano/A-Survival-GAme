package a.survival.game;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Denis
 */
public class Suoni {
    Clip c;
    URL suonoURL[]=new URL[30];
    
    public Suoni() {
        suonoURL[0] = getClass().getResource("/immagini/suoni/song.wav");
        suonoURL[1] = getClass().getResource("/immagini/suoni/cibo.wav");
        suonoURL[2] = getClass().getResource("/immagini/suoni/coltello.wav");
        suonoURL[3] = getClass().getResource("/immagini/suoni/porta.wav");
        suonoURL[4] = getClass().getResource("/immagini/suoni/casse.wav");
    }
    
    public void setFile(int i) {
        try{
            AudioInputStream inputA=AudioSystem.getAudioInputStream(suonoURL[i]);
            c=AudioSystem.getClip();
            c.open(inputA);
        }catch(Exception e) {
            
        }
    }
    
    public void vai() {
        c.start();
    }
    
    public void loop() {
        c.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    public void stop() {
        c.stop();
    }
}
