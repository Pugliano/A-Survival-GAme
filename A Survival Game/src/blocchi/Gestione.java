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
    public Blocchi[] blocchi;
    public int Nmappe[][];
    TileMenager tm;
    
    public Gestione(Pannello p) {
        tm=new TileMenager();
        this.p=p;
        blocchi=new Blocchi[50];
        Nmappe=new int[p.WordCol][p.WordRig];
        for (int i = 0; i < Nmappe.length; i++) {
            for (int j = 0; j < Nmappe.length; j++) {
                Nmappe[i][j]=0;
            }
        }
        
        //getImmagineB();
        caricaM("/immagini/mappe/ban.txt");
        
    }

    
    
    /**public void getImmagineB() {
        try {
            //sabbia
            blocchi[0]=new Blocchi();
            blocchi[0].image=ImageIO.read(getClass().getResourceAsStream("/immagini/blocchi/sabbia.png"));
            
            //erba
            blocchi[1] = new Blocchi();
            blocchi[1].image = ImageIO.read(getClass().getResourceAsStream("/immagini/blocchi/erba.png"));
            
            //acqua --> solida
            blocchi[3] = new Blocchi();
            blocchi[3].image = ImageIO.read(getClass().getResourceAsStream("/immagini/blocchi/acqua.png"));
            //blocchi[3].collisioni=true;
            
            //albero --> solida
            blocchi[4] = new Blocchi();
            blocchi[4].image = ImageIO.read(getClass().getResourceAsStream("/immagini/blocchi/albero.png"));
            //blocchi[4].collisioni = true;
            
            //acqua su
            blocchi[6] = new Blocchi();
            blocchi[6].image = ImageIO.read(getClass().getResourceAsStream("/immagini/blocchi/acqua01.png"));
            //blocchi[6].collisioni = true;
            
            //acqua giu
            blocchi[7] = new Blocchi();
            blocchi[7].image = ImageIO.read(getClass().getResourceAsStream("/immagini/blocchi/acqua02.png"));
            //blocchi[7].collisioni = true;
            
            //acqua destra
            blocchi[8] = new Blocchi();
            blocchi[8].image = ImageIO.read(getClass().getResourceAsStream("/immagini/blocchi/acqua03.png"));
            //blocchi[8].collisioni = true;
            
            //acqua sinistra
            blocchi[9] = new Blocchi();
            blocchi[9].image = ImageIO.read(getClass().getResourceAsStream("/immagini/blocchi/acqua04.png"));
            //blocchi[9].collisioni = true;
            
            //acqua alto a destra
            blocchi[2] = new Blocchi();
            blocchi[2].image = ImageIO.read(getClass().getResourceAsStream("/immagini/blocchi/acqua05.png"));
            //blocchi[2].collisioni = true;
            
            //acqua alto a sinistra
            blocchi[5] = new Blocchi();
            blocchi[5].image = ImageIO.read(getClass().getResourceAsStream("/immagini/blocchi/acqua06.png"));
            //blocchi[5].collisioni = true;
            
            //acqua basso a destra
            blocchi[10] = new Blocchi();
            blocchi[10].image = ImageIO.read(getClass().getResourceAsStream("/immagini/blocchi/acqua08.png"));
            //blocchi[10].collisioni = true;
            
            //acqua basso a sinistra
            blocchi[11] = new Blocchi();
            blocchi[11].image = ImageIO.read(getClass().getResourceAsStream("/immagini/blocchi/acqua07.png"));
            //blocchi[11].collisioni = true;
            
            //muro
            blocchi[12] = new Blocchi();
            blocchi[12].image = ImageIO.read(getClass().getResourceAsStream("/immagini/blocchi/muro.png"));
            //blocchi[12].collisioni = true;
            
            //terra
            blocchi[13] = new Blocchi();
            blocchi[13].image = ImageIO.read(getClass().getResourceAsStream("/immagini/blocchi/terra.png"));
            
        }catch(IOException e) {
            e.printStackTrace();
        }
    }**/
    
    public void caricaM(String file) {
        try{
            InputStream is = getClass().getResourceAsStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col=0;
            int rig=0;
            while(col<p.WordCol && rig<p.WordRig) {
                String linea=br.readLine();
                while(col<p.WordCol) {
                    String numeri[]=linea.split(",");
                    
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
    int schermoX;
    int schermoY;
    public void draw(Graphics2D g2) {
        int col=0;
        int rig=0;
        
        while(col<p.WordCol && rig<p.WordRig) {
            
            int Nblocchi = Nmappe[col][rig];
            
            int mondoX=col * p.FinalAP;
            int mondoY = rig * p.FinalAP;
            schermoX=mondoX-p.player.Mondox+p.player.schermoX;
            schermoY = mondoY - p.player.Mondoy + p.player.schermoY;
            
            if(mondoX + p.FinalAP >p.player.Mondox-p.player.schermoX && 
               mondoX - p.FinalAP<p.player.Mondox+p.player.schermoX &&
               mondoY + p.FinalAP>p.player.Mondoy-p.player.schermoY &&
               mondoY - p.FinalAP<p.player.Mondoy+p.player.schermoY) {
               //g2.drawImage(blocchi[Nblocchi].image, schermoX, schermoY, p.FinalAP, p.FinalAP, null);
               int id = Nmappe[col][rig];
               g2.drawImage(tm.getSprite(id-1), schermoX, schermoY, p.FinalAP, p.FinalAP, null);
            }
            
            col++;
            
            if(col==p.WordCol) {
                col=0;
                rig++;
                
            }
        }
    }
}
