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
    public int comandi=0;
    
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
        if(p.pausaG == p.menuS)
        {
            drawMenu();
        }
        if(p.pausaG==p.pausaP) {
            
        }
        if(p.pausaG==p.pausaPa) {
            drawScrittaPausa();
        }   
    }
    
    public void drawMenu(){
        //set e sfondo nero
        g2.setColor(new Color(0,0,0));
        g2.fillRect(0, 0, p.FinestraA , p.FinestraL);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String testo="A Survival Game";
        int x=getXTestoCentrato(testo);
        int y=p.FinalAP*4;
        
        //ombra
        g2.setColor(new Color(181,181,181));
        g2.drawString(testo, x+5, y+5);
        
        //scritta principale
        g2.setColor(Color.white);
        g2.drawString(testo, x, y);
        
        //personaggio
        x= (p.FinestraA/2)-(p.FinalAP*2)/2;
        y+=p.FinalAP*2;
        g2.drawImage(p.player.giu1, x, y, p.FinalAP*2,p.FinalAP*2,null);
        
        //menu
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));
    
        testo = "Nuova partita";
        x=getXTestoCentrato(testo);
        y+=p.FinalAP*4;
        g2.drawString(testo, x, y);
        if (comandi==0){
            g2.drawString(">", x-p.FinalAP, y);
        }
        
        testo = "Carica partita";
        x=getXTestoCentrato(testo);
        y+=p.FinalAP;
        g2.drawString(testo, x, y);
        if (comandi==1){
            g2.drawString(">", x-p.FinalAP, y);
        }
        
        testo = "Esci";
        x=getXTestoCentrato(testo);
        y+=p.FinalAP;
        g2.drawString(testo, x, y);
        if (comandi==2){
            g2.drawString(">", x-p.FinalAP, y);
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
