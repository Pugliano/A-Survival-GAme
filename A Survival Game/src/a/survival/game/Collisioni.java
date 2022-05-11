package a.survival.game;

import Umani.umani;
import blocchi.TileMenager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author Denis
 */
public class Collisioni {
    Pannello p;
    public int Nmappe[][];
    TileMenager tm;
    
    public Collisioni(Pannello p) {
        this.p=p;
        tm=new TileMenager();
        Nmappe=new int[p.WordCol][p.WordRig];
        for (int i = 0; i < Nmappe.length; i++) {
            for (int j = 0; j < Nmappe.length; j++) {
                Nmappe[i][j]=0;
            }
        }
        caricaM("/immagini/mappe/ban.txt");
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
    public void Controlla(umani u) {
        int umaniSX=u.Mondox+u.AreaS.x;
        int umaniDX = u.Mondox + u.AreaS.x + u.AreaS.width;
        int umaniSUY = u.Mondoy + u.AreaS.y;
        int umaniGUY = u.Mondoy + u.AreaS.y + u.AreaS.height;
        
        int umaniSC=umaniSX/p.FinalAP;
        int umaniRC = umaniDX / p.FinalAP;
        int umaniSUR = umaniSUY / p.FinalAP;
        int umaniGUR = umaniGUY / p.FinalAP;
        
        int NB1, NB2;
        int id;
        switch(u.direzione) {
            case "su":
                id = Nmappe[p.player.Mondoy/p.FinalAP-1][p.player.Mondox/p.FinalAP];
                if(tm.getTile(id).getTileType()==1)
                    u.collisioniSI=true;
                break;
            case "giu":
                id = Nmappe[p.player.Mondoy/p.FinalAP+2][p.player.Mondox/p.FinalAP];
                if(tm.getTile(id).getTileType()==1)
                    u.collisioniSI=true;
                break;
            case "sinistra":
                id = Nmappe[p.player.Mondoy/p.FinalAP][p.player.Mondox/p.FinalAP-1];
                if(tm.getTile(id).getTileType()==1)
                    u.collisioniSI=true;
                break;
            case "destra":
                id = Nmappe[p.player.Mondoy/p.FinalAP][p.player.Mondox/p.FinalAP+2];
                if(tm.getTile(id).getTileType()==1)
                    u.collisioniSI=true;
                break;
        }
    }
    public int ControllaOGG(umani u, boolean giocatore) {
        int ind=999;
        for (int i = 0; i < p.ogg.length; i++) {
            if(p.ogg[i]!=null) {
                u.AreaS.x=u.Mondox+u.AreaS.x;
                u.AreaS.y=u.Mondoy+u.AreaS.y;
                
                //vedere posizione degli oggetti piazzati
                p.ogg[i].SArea.x=p.ogg[i].mondox+p.ogg[i].SArea.x;
                p.ogg[i].SArea.y=p.ogg[i].mondoy+p.ogg[i].SArea.y;
                
                switch(u.direzione) {
                    case"su":
                        u.AreaS.y-=u.velocita;
                        if(u.AreaS.intersects(p.ogg[i].SArea)) {
                            if(p.ogg[i].collisioni==true) {
                                u.collisioniSI=true;
                            }
                            if(giocatore==true) {
                                ind=i;
                            }
                        }
                        break;
                    case"giu":
                        u.AreaS.y+=u.velocita;
                        if(u.AreaS.intersects(p.ogg[i].SArea)) {
                            if (p.ogg[i].collisioni == true) {
                                u.collisioniSI = true;
                            }
                            if (giocatore == true) {
                                ind = i;
                            }
                        }
                        break;
                    case "sinistra":
                        u.AreaS.x -= u.velocita;
                        if (u.AreaS.intersects(p.ogg[i].SArea)) {
                            if (p.ogg[i].collisioni == true) {
                                u.collisioniSI = true;
                            }
                            if (giocatore == true) {
                                ind = i;
                            }
                        }
                        break;
                    case"destra":
                        u.AreaS.x+=u.velocita;
                        if(u.AreaS.intersects(p.ogg[i].SArea)) {
                            if (p.ogg[i].collisioni == true) {
                                u.collisioniSI = true;
                            }
                            if (giocatore == true) {
                                ind = i;
                            }
                        }
                    break;
                }
                u.AreaS.x=u.AreaSX;
                u.AreaS.y=u.AreaSY;
                p.ogg[i].SArea.x=p.ogg[i].AreaSX;
                p.ogg[i].SArea.y = p.ogg[i].AreaSY;
            }
        }
        return ind;
    }
}
