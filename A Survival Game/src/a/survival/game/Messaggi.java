package a.survival.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.text.DecimalFormat;
import oggetti.OGGcoltello;

/**
 *
 * @author Denis
 */
public class Messaggi {
    Pannello p;
    Graphics2D g2;
    Font Arial_40, Arial_80B;
    //BufferedImage colIM;
    public boolean messON=false;
    public String messag="";
    int messT=0;
    double tempoG;    
    DecimalFormat df=new DecimalFormat("#0.00");
    
    public Messaggi(Pannello p) {
        this.p=p;
        Arial_40=new Font("Arial", Font.PLAIN, 40);
        Arial_80B = new Font("Arial", Font.BOLD, 80);
        OGGcoltello col=new OGGcoltello();
        //colIM=col.image;
    }
    
    public void PrintMess(String testo) {
        messag=testo;
        messON=true;
    }
    
    public void draw(Graphics2D g2) {
        this.g2=g2;
        g2.setFont(Arial_40);
        g2.setColor(Color.white);
        if(p.pausaG==p.pausaP) {
            
        }
        if(p.pausaG==p.pausaPa) {
            drawScrittaPausa();
        }   
    }
    
    public void drawScrittaPausa() {
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
        String testo="PAUSA";
        int x=getXTestoCentrato(testo);
        int y=p.FinestraL/3;
        g2.drawString(testo, x, y);
    }
    
    public int getXTestoCentrato(String testo) {
        int lunghezza = (int) g2.getFontMetrics().getStringBounds(testo, g2).getWidth();
        int x = p.FinestraA/2 - lunghezza / 2;
        return x;
    }
}
