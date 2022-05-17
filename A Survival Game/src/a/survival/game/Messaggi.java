package a.survival.game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import oggetti.OGGcoltello;
import oggetti.OGGcuore;
import oggetti.TuttiOGG;

/**
 *
 * @author Denis
 */
public class Messaggi {

    Pannello p;
    Graphics2D g2;
    Font Arial_40, Arial_80B;
    BufferedImage cuore_b, cuore_p, cuore_m;
    public boolean messON = false;
    public String messag = "";
    int messT = 0;
    double tempoG;
    DecimalFormat df = new DecimalFormat("#0.00");
    public int comandi = 0;
    private Rectangle rettangoloNuovo;
    private Rectangle rettangoloCarica;
    private Rectangle rettangoloEsci;
    public String Dcorrente = "";

    public Messaggi(Pannello p) {
        this.p = p;
        Arial_40 = new Font("Cambria", Font.PLAIN, 40);
        Arial_80B = new Font("Arial", Font.BOLD, 80);

        TuttiOGG cuore = new OGGcuore(p);
        cuore_m = cuore.image;
        cuore_p = cuore.image2;
        cuore_b = cuore.image3;
    }

    public void PrintMess(String testo) {
        messag = testo;
        messON = true;
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(Arial_40);
        g2.setColor(Color.white);

        //menu
        if (p.state == p.menu) {
            drawMenu();
        } //pausa
        else if (p.state == p.gioco) {
            drawVitaPlayer();
            if (p.getPausa()) {
                drawScrittaPausa();
            }
        }
        //dialoghi
        if (p.state == p.dialoghi) {
            drawVitaPlayer();
            drawDialoghi();
        }
    }

    public void drawVitaPlayer() {
        //p.player.vita=2;

        int x = p.FinalAP / 2;
        int y = p.FinalAP / 2;
        int i = 0;

        //vita max
        while (i < p.player.VitaMax / 2) {
            g2.drawImage(cuore_b, x, y, null);
            i++;
            x += p.FinalAP;
        }

        //reset
        x = p.FinalAP / 2;
        y = p.FinalAP / 2;
        i = 0;

        //vita 
        while (i < p.player.vita) {
            g2.drawImage(cuore_m, x, y, null);
            i++;
            if (i < p.player.vita) {
                g2.drawImage(cuore_p, x, y, null);
            }
            i++;
            x += p.FinalAP;
        }
    }

    public void drawMenu() {
        //set e sfondo nero
        g2.setColor(new Color(0, 0, 0));
        g2.fillRect(0, 0, p.FinestraL, p.FinestraL);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));
        String testo = "A Survival Game";
        int x = getXTestoCentrato(testo);
        int y = p.FinalAP * 4;

        //ombra
        g2.setColor(new Color(181, 181, 181));
        g2.drawString(testo, x + 5, y + 5);

        //scritta principale
        g2.setColor(Color.white);
        g2.drawString(testo, x, y);

        //personaggio
        x = (p.FinestraL / 2) - (p.FinalAP * 2) / 2;
        y += p.FinalAP * 2;
        g2.drawImage(p.player.giu1, x, y, p.FinalAP * 2, p.FinalAP * 2, null);

        //menu
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48F));

        testo = "Nuova partita";
        x = getXTestoCentrato(testo);
        y += p.FinalAP * 4;
        rettangoloNuovo = new Rectangle(x, y - getAltezzaStringa(testo), getLunghezzaStringa(testo), getAltezzaStringa(testo));
        g2.drawString(testo, x, y);
        if (comandi == 0) {
            g2.drawString(">", x - p.FinalAP, y);
        }

        testo = "Carica partita";
        x = getXTestoCentrato(testo);
        y += p.FinalAP;
        rettangoloCarica = new Rectangle(x, y - getAltezzaStringa(testo), getLunghezzaStringa(testo), getAltezzaStringa(testo));
        g2.drawString(testo, x, y);
        if (comandi == 1) {
            g2.drawString(">", x - p.FinalAP, y);
        }

        testo = "Esci";
        x = getXTestoCentrato(testo);
        y += p.FinalAP;
        rettangoloEsci = new Rectangle(x, y - getAltezzaStringa(testo), getLunghezzaStringa(testo), getAltezzaStringa(testo));
        g2.drawString(testo, x, y);
        if (comandi == 2) {
            g2.drawString(">", x - p.FinalAP, y);
        }

    }

    public void drawScrittaPausa() {
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80F));
        String testo = "PAUSA";
        int x = getXTestoCentrato(testo);
        int y = p.FinestraL / 3;
        g2.drawString(testo, x, y);
    }

    public void drawDialoghi() {
        //finestra
        int x = p.FinalAP * 2;
        int y = p.FinalAP / 2;
        int larghezza = p.FinestraL - (p.FinalAP * 4);
        int altezza = p.FinalAP * 5;
        drawDialoghiF(x, y, larghezza, altezza);

        //frase
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 28F));
        x += p.FinalAP;
        y += p.FinalAP;

        g2.drawString(Dcorrente, x, y);

        //ferma giocatore
        p.tastiera.destra=false;
        p.tastiera.sinistra=false;
        p.tastiera.su=false;
        p.tastiera.giu=false;
    }

    public void drawDialoghiF(int x, int y, int larghezza, int altezza) {
        Color c = new Color(0, 0, 0); //nero
        g2.setColor(c);
        g2.fillRoundRect(x, y, larghezza, altezza, 50, 50);

        c = new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x + 5, y + 5, larghezza - 10, altezza - 10, 40, 40);
    }

    public int getXTestoCentrato(String testo) {
        return p.FinestraL / 2 - getLunghezzaStringa(testo) / 2;

    }

    public int getLunghezzaStringa(String testo) {
        return (int) g2.getFontMetrics().getStringBounds(testo, g2).getWidth();
    }

    public int getAltezzaStringa(String testo) {
        return (int) g2.getFontMetrics().getStringBounds(testo, g2).getHeight();
    }

    public void mouseMoved(MouseEvent e) {
        if (rettangoloNuovo.contains(e.getX(), e.getY())) {
            comandi = 0;
        }
        if (rettangoloCarica.contains(e.getX(), e.getY())) {
            comandi = 1;
        }
        if (rettangoloEsci.contains(e.getX(), e.getY())) {
            comandi = 2;
        }

    }

    public void mouseClicked(MouseEvent e) {
        if (rettangoloNuovo.contains(e.getX(), e.getY())) {
            p.state = p.gioco;
        }
        if (rettangoloCarica.contains(e.getX(), e.getY())) {
            System.out.println("carica partita");
        }
        if (rettangoloEsci.contains(e.getX(), e.getY())) {
            System.exit(0);
        }
    }
}
