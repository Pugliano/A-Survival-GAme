package a.survival.game;

import Umani.giocatore;
import Umani.umani;
import blocchi.Gestione;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import oggetti.TuttiOGG;

/**
 *
 * @author Denis
 */
public class Pannello extends JPanel implements Runnable{
    final int altezzaP=32; //altezza del personaggio e degli npc fissi
    final int scala=2;
    //Impostazioni dello schermo
    public final int FinalAP=altezzaP*scala; //64*64
    public final int AltezzaSMX=24;
    public final int AltezzaSMY=15;
    public final int FinestraA=FinalAP*AltezzaSMX; //768px->altezza
    public final int FinestraL=FinalAP*AltezzaSMY; //576px->larghezza
    
    //impostazioni mappa
    public final int WordCol=150;
    public final int WordRig=150;
    
    //fps
    int fps=60;
    
    //gioco 
    Gestione GB=new Gestione(this);
    Tastiera tastiera=new Tastiera(this);
    Mouse mouse=new Mouse(this);
    //Suoni
    Suoni musica=new Suoni();
    Suoni effs = new Suoni();
    //collisioni
    public Collisioni collis=new Collisioni(this);
    public SettOgg sett=new SettOgg(this);
    //messaggi
    public Messaggi messaggi=new Messaggi(this);
    
    Thread gameThread;
    //umani e oggetti
    public giocatore player=new giocatore(this,tastiera);
    public umani npc[]=new umani[10];
    public TuttiOGG ogg[]=new TuttiOGG[10];
    
    //pausa
    public boolean pausa=false;
    public int state;
    
    public Pannello() {
        this.setPreferredSize(new Dimension(FinestraA,FinestraL));
        this.setBackground(new Color(87, 165, 224, 206));
        this.setDoubleBuffered(true);
        this.addKeyListener(tastiera);
        this.addMouseListener(mouse);
        this.addMouseMotionListener(mouse);
        this.setFocusable(true);
    }
    
    public void setGioco() {
        sett.setoggetto();
        sett.setNpc();
        viaMusica(0);
        state=0;
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
        if(pausa==false) {
            //giocatore
            player.muovi();
            //npc
            for (int i = 0; i < npc.length; i++) {
                if(npc[i]!=null) {
                    npc[i].muovi();
                }
            }
        }
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D)g;
       
        //Menu
        if(state==0)
        {
            messaggi.draw(g2);
        }
        //altro
        else if(state==1){
            //blocchi
            GB.draw(g2);
            
            //giocatore
            player.draw(g2);
            
            //npc
            for (int i = 0; i < npc.length; i++) {
                if (npc[i] != null) {
                    npc[i].draw(g2);
                }
            }
            
            //messaggi
            messaggi.draw(g2);
            
            //oggetti
            for (int i = 0; i < ogg.length; i++) {
                if(ogg[i]!=null) {
                    ogg[i].draw(g2, this);
                }
            }
            
            
        }
       
        g2.dispose();
    }

    public void viaMusica(int i) {
        musica.setFile(i);
        musica.vai();
        musica.loop();
    }
    public void stopMusica() {
        musica.stop();
    }
    public void viaEFF(int i) {
        effs.setFile(i);
        effs.vai();
    }
    
    public void setPausa(boolean p) {
        pausa=p;
    }
    
    public boolean getPausa() {
        return pausa;
    }
    
    public void mouseMoved(MouseEvent e) {
        if(state==0) {
            messaggi.mouseMoved(e);
        }
    }
    
    public void mouseClicked(MouseEvent e) {
        if(state==0) {
            messaggi.mouseClicked(e);
        }
    }
}
