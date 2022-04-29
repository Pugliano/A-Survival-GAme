package blocchi;

import a.survival.game.Pannello;
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
    Blocchi[] blocchi;
    int Nmappe[][];
    
    public Gestione(Pannello p) {
        this.p=p;
        blocchi=new Blocchi[10];
        Nmappe=new int[p.WordCol][p.WordRig];
        
        getImmagineB();
        caricaM("/immagini/mappe/word.txt");
    }
    
    public void getImmagineB() {
        try {
            //sabbia
            blocchi[0]=new Blocchi();
            blocchi[0].image=ImageIO.read(getClass().getResourceAsStream("/immagini/blocchi/sabbia.png"));
            
            //terra
            blocchi[1] = new Blocchi();
            blocchi[1].image = ImageIO.read(getClass().getResourceAsStream("/immagini/blocchi/erba.png"));
            
            //acqua
            blocchi[3] = new Blocchi();
            blocchi[3].image = ImageIO.read(getClass().getResourceAsStream("/immagini/blocchi/acqua.png"));
            
            //albero
            blocchi[4] = new Blocchi();
            blocchi[4].image = ImageIO.read(getClass().getResourceAsStream("/immagini/blocchi/albero.png"));
            
            //acqua su
            blocchi[6] = new Blocchi();
            blocchi[6].image = ImageIO.read(getClass().getResourceAsStream("/immagini/blocchi/acqua01.png"));
            
            //acqua giu
            blocchi[7] = new Blocchi();
            blocchi[7].image = ImageIO.read(getClass().getResourceAsStream("/immagini/blocchi/acqua02.png"));
            
            //acqua destra
            blocchi[8] = new Blocchi();
            blocchi[8].image = ImageIO.read(getClass().getResourceAsStream("/immagini/blocchi/acqua03.png"));
            
            //acqua sinistra
            blocchi[9] = new Blocchi();
            blocchi[9].image = ImageIO.read(getClass().getResourceAsStream("/immagini/blocchi/acqua04.png"));
            
            //acqua alto a destra
            blocchi[2] = new Blocchi();
            blocchi[2].image = ImageIO.read(getClass().getResourceAsStream("/immagini/blocchi/acqua05.png"));
            
            //acqua alto a sinistra
            blocchi[5] = new Blocchi();
            blocchi[5].image = ImageIO.read(getClass().getResourceAsStream("/immagini/blocchi/acqua06.png"));
            
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public void caricaM(String file) {
        try{
            InputStream is = getClass().getResourceAsStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col=0;
            int rig=0;
            while(col<p.WordCol && rig<p.WordRig) {
                String linea=br.readLine();
                while(col<p.WordCol) {
                    String numeri[]=linea.split(" ");
                    
                    int num = Integer.parseInt(numeri[col]);
                    Nmappe[col][rig]=num;
                    col++;
                }
                if(col==p.WordCol) {
                    col=0;
                    rig++;
                }
            }
            br.close();
        }catch(Exception e) {
            
        }
    }
    
    public void draw(Graphics2D g2) {
        int col=0;
        int rig=0;
        
        while(col<p.WordCol && rig<p.WordRig) {
            
            int Nblocchi = Nmappe[col][rig];
            
            int mondoX=col * p.FinalAP;
            int mondoY = rig * p.FinalAP;
            int schermoX=mondoX-p.player.Mondox+p.player.schermoX;
            int schermoY = mondoY - p.player.Mondoy + p.player.schermoY;
            
            if(mondoX + p.FinalAP >p.player.Mondox-p.player.schermoX && 
               mondoX - p.FinalAP<p.player.Mondox+p.player.schermoX &&
               mondoY + p.FinalAP>p.player.Mondoy-p.player.schermoY &&
               mondoY - p.FinalAP<p.player.Mondoy+p.player.schermoY) {
                g2.drawImage(blocchi[Nblocchi].image, schermoX, schermoY, p.FinalAP, p.FinalAP, null);
            }
            
            col++;
            
            if(col==p.WordCol) {
                col=0;
                rig++;
                
            }
        }
    }
}
