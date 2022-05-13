package a.survival.game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
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
    public boolean messON=false;
    public String messag="";
    int messT=0;
    double tempoG;    
    DecimalFormat df=new DecimalFormat("#0.00");
    public int comandi=0;
    private Rectangle rettangoloNuovo;
    private Rectangle rettangoloCarica;
    private Rectangle rettangoloEsci;
    public String FraseD="";
    
    
    public Messaggi(Pannello p) {
        this.p=p;
        Arial_40=new Font("Arial", Font.PLAIN, 40);
        Arial_80B = new Font("Arial", Font.BOLD, 80);
        OGGcoltello col=new OGGcoltello(p);
    }
    
    public void PrintMess(String testo) {
        messag=testo;
        messON=true;
    }
    
    public void draw(Graphics2D g2) {
        this.g2=g2;
        g2.setFont(Arial_40);
        g2.setColor(Color.white);
        
        //menu
        if(p.state==0)
        {
            drawMenu();
        }
        //pausa
        else if(p.state==1) {
            if(p.getPausa()) {
                drawScrittaPausa();
            }
        }
        //dialoghi
        if(p.dialoghi==true) {
            drawDialoghi();
        }
    }
    
    public void drawMenu(){
        //set e sfondo nero
        g2.setColor(new Color(0,0,0));
        g2.fillRect(0, 0, p.FinestraL , p.FinestraL);
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
        x= (p.FinestraL/2)-(p.FinalAP*2)/2;
        y+=p.FinalAP*2;
        g2.drawImage(p.player.giu1, x, y, p.FinalAP*2,p.FinalAP*2,null);
        
        //menu
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));
    
        testo = "Nuova partita";
        x=getXTestoCentrato(testo);
        y+=p.FinalAP*4;
        rettangoloNuovo=new Rectangle(x, y-getAltezzaStringa(testo), getLunghezzaStringa(testo), getAltezzaStringa(testo));
        g2.drawString(testo, x, y);
        if (comandi==0){
            g2.drawString(">", x-p.FinalAP, y);
        }
        
        testo = "Carica partita";
        x=getXTestoCentrato(testo);
        y+=p.FinalAP;
        rettangoloCarica=new Rectangle(x, y-getAltezzaStringa(testo), getLunghezzaStringa(testo), getAltezzaStringa(testo));
        g2.drawString(testo, x, y);
        if (comandi==1){
            g2.drawString(">", x-p.FinalAP, y);
        }
        
        testo = "Esci";
        x=getXTestoCentrato(testo);
        y+=p.FinalAP;
        rettangoloEsci=new Rectangle(x, y-getAltezzaStringa(testo), getLunghezzaStringa(testo), getAltezzaStringa(testo));
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
    
    public void drawDialoghi() {
        //finestra
        int x=p.FinalAP*2;
        int y=p.FinalAP/2;
        int larghezza=p.FinestraL-(p.FinalAP*4);
        int altezza=p.FinalAP*4;
        drawDialoghiF(x,y,larghezza,altezza);
        
        //frase
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,32F));
        x+=p.FinalAP;
        y+=p.FinalAP;
        g2.drawString(FraseD,x,y);
    }
    
    public void drawDialoghiF(int x,int y,int larghezza,int altezza) {
        Color c=new Color(0,0,0,210); //nero
        g2.setColor(c);
        g2.fillRoundRect(x, y, larghezza, altezza, 50, 50);
        
        c=new Color(255,255,255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5, larghezza-10, altezza-10, 40, 40);
    }
    
    public int getXTestoCentrato(String testo) {
        return p.FinestraL/2 - getLunghezzaStringa(testo) / 2;
    
    }
    
    public int getLunghezzaStringa(String testo) {
        return (int) g2.getFontMetrics().getStringBounds(testo, g2).getWidth();
    }
    
    public int getAltezzaStringa(String testo) {
        return (int) g2.getFontMetrics().getStringBounds(testo, g2).getHeight();
    }
    
    public void mouseMoved(MouseEvent e) {
        if (rettangoloNuovo.contains(e.getX(),e.getY()))
            comandi=0;
        if (rettangoloCarica.contains(e.getX(),e.getY()))
            comandi=1;
        if (rettangoloEsci.contains(e.getX(),e.getY()))
            comandi=2;
        
    }
    
    public void mouseClicked(MouseEvent e) {
        if (rettangoloNuovo.contains(e.getX(),e.getY()))
            p.state=1;
        if (rettangoloCarica.contains(e.getX(),e.getY()))
            System.out.println("carica partita");
        if (rettangoloEsci.contains(e.getX(),e.getY()))
            System.exit(0);
    }
}
