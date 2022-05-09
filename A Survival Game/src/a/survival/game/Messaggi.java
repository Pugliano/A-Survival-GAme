package a.survival.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import oggetti.OGGcoltello;

/**
 *
 * @author Denis
 */
public class Messaggi {
    Pannello p;
    Font Arial_40, Arial_80B;
    BufferedImage colIM;
    public boolean messON=false;
    public String messag="";
    public int messT=0;
    double tempoG;    
    DecimalFormat df=new DecimalFormat("#0.00");
    
    public Messaggi(Pannello p) {
        this.p=p;
        Arial_40=new Font("Arial", Font.PLAIN, 40);
        Arial_80B = new Font("Arial", Font.BOLD, 80);
        OGGcoltello col=new OGGcoltello();
        colIM=col.image;
    }
    
    public void PrintMess(String testo) {
        messag=testo;
        messON=true;
    }
    
    public void draw(Graphics2D g2) {
            g2.setFont(Arial_40);
            g2.setColor(Color.white);
            g2.drawImage(colIM, p.FinalAP / 2, p.FinalAP / 2, p.FinalAP, p.FinalAP, null);
            g2.drawString("x " + p.player.coltelloSI, 74, 70);
            
            //Tempo Gioco
            tempoG+=(double)1/60;
            g2.drawString("Tempo: " + df.format(tempoG), p.FinalAP*18, 70);

            //messaggio
            if (messON = true) {
                g2.setFont(g2.getFont().deriveFont(30F));
                g2.drawString(messag, p.FinalAP / 2, p.FinalAP * 14);
                messT++;
                if (messT > 120) {
                    messT = 0;
                    messON = false;
                }
            } 
            
            if(tempoG>180) {
                String testo;
                int LungTesto;
                int x,y;
                g2.setFont(Arial_80B);
                g2.setColor(Color.yellow);
                testo="Sei Sopravissuto";
                LungTesto=(int)g2.getFontMetrics().getStringBounds(testo, g2).getWidth();
                x=p.FinestraA/2-LungTesto/2;
                y=p.FinestraL/2+(p.FinalAP*2);
                g2.drawString(testo, x, y);
                p.gameThread=null;
            }
    }
}
