package a.survival.game;

import Umani.giocatore;
import blocchi.Gestione;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import oggetti.TuttiOGG;

/**
 *
 * @author Denis
 */
public class Pannello extends JPanel implements Runnable{
    //Impostazioni dello schermo
    final int altezzaP=16; //altezza del personaggio e degli npc fissi
    final int scala=3;
    
    public final int FinalAP=altezzaP*scala; //48*48
    public final int AltezzaSMX=24;
    public final int AltezzaSMY=15;
    public final int FinestraA=FinalAP*AltezzaSMX; //768px->altezza
    public final int FinestraL=FinalAP*AltezzaSMY; //576px->larghezza
    
    //impostazioni mappa
    public final int WordCol=120;
    public final int WordRig=120;
    
    //fps
    int fps=60;
    
    //gioco 
    Gestione GB=new Gestione(this);
    Tastiera tastiera=new Tastiera();
    //Suoni
    Suoni s=new Suoni();
    //collisioni
    public Collisioni collis=new Collisioni(this);
    public SettOgg sett=new SettOgg(this);
    Thread gameThread;
    //umani e oggetti
    public giocatore player=new giocatore(this,tastiera);
    public TuttiOGG ogg[]=new TuttiOGG[10];
    
    
    
    public Pannello() {
        this.setPreferredSize(new Dimension(FinestraA,FinestraL));
        this.setBackground(Color.cyan);
        this.setDoubleBuffered(true);
        this.addKeyListener(tastiera);
        this.setFocusable(true);
    }
    
    public void setGioco() {
        sett.setoggetto();
        
        viaMusica(0);
    }

    public void startGameThred() {
        gameThread=new Thread(this);
        gameThread.start();
    }
    
    @Override
    public void run() {
        
        double intervallo=1000000000/fps;
        double delta=0;
        long rimanente=System.nanoTime();
        long momento;
        long timer=0;
        int conta=0;
        
        while(gameThread!=null) {
            
            momento=System.nanoTime();
            
            delta+=(momento-rimanente)/intervallo;
            timer+=momento-rimanente;
            rimanente=momento;
            
            if(delta>=1) {
                muovi();
                repaint();
                delta--;
                conta++;
            }
            
            if(timer>=1000000000) {
                System.out.println("FPS: "+conta);
                conta=0;
                timer=0;
            }
            
            
        }
    }
    
    public void muovi() {
        player.muovi();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2=(Graphics2D)g;
        
        //blocchi
        GB.draw(g2);
        //oggetti
        for (int i = 0; i < ogg.length; i++) {
            if(ogg[i]!=null) {
                ogg[i].draw(g2, this);
            }
        }
        //giocatore
        player.draw(g2);
        
        g2.dispose();
    }

    public void viaMusica(int i) {
        s.setFile(i);
        s.vai();
        s.loop();
    }
    public void stopMusica() {
        s.stop();
    }
    public void viaEFF(int i) {
        s.setFile(i);
        s.vai();
    }
}
