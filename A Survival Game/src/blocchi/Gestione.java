package blocchi;

import a.survival.game.Pannello;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author Denis
 */
public class Gestione {
    Pannello p;
    public int Nmappe[][];
    TileManager tm;
    int schermoX;
    int schermoY;
    
    public Gestione(Pannello p) {
        tm=new TileManager();
        this.p=p;
        Nmappe=new int[p.WordCol][p.WordRig];
        for (int i = 0; i < Nmappe.length; i++) {
            for (int j = 0; j < Nmappe.length; j++) {
                Nmappe[i][j]=0;
            }
        }
       
        caricaM("/immagini/mappe/word.txt");
        
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
    
    public void draw(Graphics2D g2) {
        int col=0;
        int rig=0;
        
        while(col<p.WordCol && rig<p.WordRig) {
            
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
