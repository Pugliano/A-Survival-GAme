package a.survival.game;

import Umani.giocatore;
import Umani.umani;
import blocchi.Gestione;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import oggetti.TuttiOGG;

/**
 *
 * @author Denis
 */
public class Pannello extends JPanel implements Runnable {

    final int altezzaP = 16; //altezza del personaggio e degli npc fissi
    final int scala = 3;

    //Impostazioni dello schermo
    public final int FinalAP = altezzaP * scala; //64*64
    public final int AltezzaSMX = 20;
    public final int AltezzaSMY = 12;
    public final int FinestraL = FinalAP * AltezzaSMX;
    public final int FinestraA = FinalAP * AltezzaSMY;
    
    //schermo intero
    int IntFinestraL=FinestraL;
    int IntFinestraA=FinestraA;
    BufferedImage schermoTemp;
    Graphics2D g2;

    //impostazioni mappa
    public final int WordCol = 150;
    public final int WordRig = 150;

    //fps
    int fps = 60;

    //gioco 
    Gestione GB = new Gestione(this);
    public Tastiera tastiera = new Tastiera(this);
    Mouse mouse = new Mouse(this);

    //Suoni
    Suoni musica = new Suoni();
    Suoni effs = new Suoni();

    //collisioni
    public Collisioni collis = new Collisioni(this);
    public SettOgg sett = new SettOgg(this);

    //messaggi
    public Messaggi messaggi = new Messaggi(this);
    public Azioni azioni = new Azioni(this);

    Thread gameThread;

    //umani e oggetti
    public giocatore player = new giocatore(this, tastiera);
    public umani npc[] = new umani[10];
    public TuttiOGG ogg[] = new TuttiOGG[50];

    //stato del gioco
    public boolean pausa = false;
    public int state;
    public final int menu = 0;
    public final int gioco = 1;
    public final int dialoghi = 2;

    public Pannello() {
        this.setPreferredSize(new Dimension(FinestraL, FinestraL));
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
        state = menu;
        schermoTemp = new BufferedImage(FinestraL,FinestraA,BufferedImage.TYPE_INT_ARGB);
        g2 = (Graphics2D)schermoTemp.getGraphics();
    }

    public void startGameThred() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double intervallo = 1000000000 / fps;
        double delta = 0;
        long rimanente = System.nanoTime();
        long momento;
        long timer = 0;
        int conta = 0;

        while (gameThread != null) {

            momento = System.nanoTime();

            delta += (momento - rimanente) / intervallo;
            timer += momento - rimanente;
            rimanente = momento;

            if (delta >= 1) {
                muovi();
                drawSchermoTemp();
                drawSchermo();
                delta--;
                conta++;
            }

            if (timer >= 1000000000) {
                System.out.println("FPS: " + conta);
                conta = 0;
                timer = 0;
            }
        }
    }

    public void muovi() {
        if (pausa == false) {
            //giocatore
            player.muovi();
            //npc
            for (int i = 0; i < npc.length; i++) {
                if (npc[i] != null) {
                    npc[i].muovi();
                }
            }
        }
    }
    
    public void drawSchermoTemp(){
        //Menu
        if (state == menu) {
            messaggi.draw(g2);
        } //altro
        else {
            //blocchi
            GB.draw(g2);

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
                if (ogg[i] != null) {
                    ogg[i].draw(g2, this);
                }
            }

            //giocatore
            player.draw(g2);
        }
    }
    
    public void drawSchermo(){
        Graphics g = getGraphics();
        g.drawImage(schermoTemp,0,0,IntFinestraL,IntFinestraA,null);
        g.dispose();
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
        pausa = p;
    }

    public boolean getPausa() {
        return pausa;
    }
}
