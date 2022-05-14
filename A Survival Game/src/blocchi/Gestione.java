package blocchi;

import a.survival.game.Pannello;
import a.survival.game.UtilityTool;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;

/**
 *
 * @author Denis
 */
public class Gestione {

    Pannello p;
    public Blocchi[] blocco;
    public int Nmappe[][];
//    TileManager tm;
//    int schermoX;
//    int schermoY;
//    

    public Gestione(Pannello p) {
        this.p = p;
        blocco = new Blocchi[50];
        Nmappe=new int [p.AltezzaSMX][p.AltezzaSMY];
        PrendiBlocchi();      
        caricaMappa("/immagini/mappe/wordV2.txt");
    }    

    public void PrendiBlocchi() {
        //inutili
        setup(0, "grass00", false);
        setup(1, "grass00", false);
        setup(2, "grass00", false);
        setup(3, "grass00", false);
        setup(4, "grass00", false);
        setup(5, "grass00", false);
        setup(6, "grass00", false);
        setup(7, "grass00", false);
        setup(8, "grass00", false);
        setup(9, "grass00", false);
        
        setup(10, "grass00", false);
        setup(11, "grass01", false);
        setup(12, "water00", false);
        setup(13, "water01", false);
        setup(14, "water02", false);
        setup(15, "water03", false);
        setup(16, "water04", false);
        setup(17, "water05", false);
        setup(18, "water06", false);
        setup(19, "water07", false);
        setup(20, "water08", false);
        setup(21, "water09", false);
        setup(22, "water10", false);
        setup(23, "water11", false);
        setup(24, "water12", false);
        setup(25, "water13", false);
        setup(26, "road00", false);
        setup(27, "road01", false);
        setup(28, "road02", false);
        setup(29, "road03", false);
        setup(30, "road04", false);
        setup(31, "road05", false);
        setup(32, "road06", false);
        setup(33, "road07", false);
        setup(34, "road08", false);
        setup(35, "road09", false);
        setup(36, "road10", false);
        setup(37, "road11", false);
        setup(38, "road12", false);
        setup(39, "earth", false);
        setup(40, "wall", false);
        setup(41, "tree", false);
    }   
    
    public void setup(int index,String NomeImmagine,boolean collisioni) {
        UtilityTool uTool=new UtilityTool();
        try{
            blocco[index]=new Blocchi();
            blocco[index].image = ImageIO.read(getClass().getResourceAsStream("/immagini/blocchi/"+NomeImmagine+".png"));
            blocco[index].image=uTool.Simm(blocco[index].image, p.FinalAP, p.FinalAP);
            blocco[index].collisioni=collisioni;
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public void caricaMappa(String file) {
        try {
            InputStream is=getClass().getResourceAsStream(file);
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            
            int col=0;
            int rig=0;
            
            while(col<p.AltezzaSMX&&rig<p.AltezzaSMY) {
                String line=br.readLine();
                
                while(col<p.AltezzaSMX) {
                    String numbers[]=line.split(" ");
                    
                    int num=Integer.parseInt(numbers[col]);
                    
                    Nmappe[col][rig]=num;
                    col++;
                }
                if(col==p.AltezzaSMX) {
                    col=0;
                    rig++;
                }
            }
            br.close();
        } catch (Exception e) {
            
        }
    }
    
    public void draw(Graphics2D g2) {

        int col = 0;
        int rig = 0;

        while (col < p.AltezzaSMX && rig < p.AltezzaSMY) {
            int tileNum=Nmappe[col][rig];
            int mondoX=col*p.FinalAP;
            int mondoY=rig*p.FinalAP;
            int schermoX=mondoX-p.player.mondoX+p.player.schermoX;
            int schermoY=mondoY-p.player.mondoY+p.player.schermoY;
            if(mondoX + p.FinalAP > p.player.mondoX - p.player.schermoX &&
               mondoX - p.FinalAP < p.player.mondoX + p.player.schermoX &&
               mondoY + p.FinalAP > p.player.mondoY - p.player.schermoY &&
               mondoY - p.FinalAP < p.player.mondoY + p.player.schermoY) {
                g2.drawImage(blocco[tileNum].image, schermoX, schermoY, null);
            }
            
            col++;
            if(col==p.AltezzaSMY) {
                col=0;
                rig++;
            }
        }
    }
}
