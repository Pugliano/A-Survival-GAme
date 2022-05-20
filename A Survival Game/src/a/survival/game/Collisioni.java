package a.survival.game;

import Entita.Entita;
import blocchi.TileManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Denis
 */
public class Collisioni {
    Pannello p;
    public int Nmappe[][];
    TileManager tm;
    
    public Collisioni(Pannello p) {
        this.p=p;
        tm=new TileManager();
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
    public void Controlla(Entita e) {
        int id;
        switch (e.direzione) {
            case "su":
                id = Nmappe[p.player.x / p.FinalAP][p.player.y / p.FinalAP -1];
                if (tm.getTile(id).getTileType() == 1) {
                    e.collisioniSI = true;
                }
                break;
            case "giu":
                id = Nmappe[p.player.x / p.FinalAP+2][p.player.y / p.FinalAP+2];
                if (tm.getTile(id).getTileType() == 1) {
                    e.collisioniSI = true;
                }
                break;
            case "sinistra":
                id = Nmappe[p.player.x / p.FinalAP - 1][p.player.y / p.FinalAP+2];
                if (tm.getTile(id).getTileType() == 1) {
                    e.collisioniSI = true;
                }
                break;
            case "destra":
                id = Nmappe[p.player.x / p.FinalAP + 2][p.player.y / p.FinalAP+2];
                if (tm.getTile(id).getTileType() == 1) {
                    e.collisioniSI = true;
                }
                break;
        }

    }
    public int ControllaOGG(Entita u, boolean giocatore) {
        int ind=999;
        for (int i = 0; i < p.gestOgg.size(); i++) {
            if(p.gestOgg.get(i)!=null) {
                u.SArea.x=u.x+u.SArea.x;
                u.SArea.y=u.y+u.SArea.y;
                
                //vedere posizione degli oggetti piazzati
                p.gestOgg.get(i).SArea.x=p.gestOgg.get(i).x+p.gestOgg.get(i).SArea.x;
                p.gestOgg.get(i).SArea.y=p.gestOgg.get(i).y+p.gestOgg.get(i).SArea.y;
                
                switch(u.direzione) {
                    case"su": u.SArea.y-=u.velocita;break;
                    case"giu": u.SArea.y+=u.velocita;break;
                    case "sinistra": u.SArea.x -= u.velocita; break;
                    case"destra": u.SArea.x+=u.velocita;break;
                }
                if (u.SArea.intersects(p.gestOgg.get(i).SArea)) {
                    if (p.gestOgg.get(i).collisioni == true) {
                        u.collisioniSI = true;
                    }
                    if (giocatore == true) {
                        ind = i;
                    }
                }
                
                u.SArea.x=u.AreaSX;
                u.SArea.y=u.AreaSY;
                p.gestOgg.get(i).SArea.x = p.gestOgg.get(i).AreaSX;
                p.gestOgg.get(i).SArea.y = p.gestOgg.get(i).AreaSY;
            }
        }
        return ind;
    }
    
    //npc o nemici collisioni
    public int ControllaU(Entita u, ArrayList<Entita> target) {
        int ind = 999;
        for (int i = 0; i < target.size(); i++) {
            if (target.get(i) != null) {
                u.SArea.x = u.x + u.SArea.x;
                u.SArea.y = u.y + u.SArea.y;

                //vedere posizione degli oggetti piazzati
                Entita temp = target.get(i);
                temp.SArea.x = temp.x + temp.SArea.x;
                temp.SArea.y = temp.y + temp.SArea.y;
                target.set(i, temp);

                switch (u.direzione) {
                    case "su": u.SArea.y -= u.velocita;break;
                    case "giu": u.SArea.y += u.velocita;break;
                    case "sinistra": u.SArea.x -= u.velocita;break;
                    case "destra": u.SArea.x += u.velocita;break;
                }
                
                if(u.SArea.intersects(target.get(i).SArea)) {
                    if(target.get(i)!=u) {
                        u.collisioniSI = true;
                        ind = i;
                    }
                }
                
                u.SArea.x = u.AreaSX;
                u.SArea.y = u.AreaSY;
                temp = target.get(i);
                temp.SArea.x = temp.AreaSX;
                temp.SArea.y = temp.AreaSY;
                target.set(i, temp);
            }
        }
        return ind;
    }
    
    //collisioni con player da parte di npc
    public boolean ControllaP(Entita e) {
        boolean contattoPlayer = false;
        e.SArea.x = e.x + e.SArea.x;
        e.SArea.y = e.y + e.SArea.y;

        //vedere posizione degli oggetti piazzati
        p.player.SArea.x = p.player.x + p.player.SArea.x;
        p.player.SArea.y = p.player.y + p.player.SArea.y;

        switch (e.direzione) {
            case "su":e.SArea.y -= e.velocita;break;
            case "giu":e.SArea.y += e.velocita;break;
            case "sinistra":e.SArea.x -= e.velocita;break;
            case "destra":e.SArea.x += e.velocita;break;
        }
        
        if (e.SArea.intersects(p.player.SArea)) {
            e.collisioniSI = true;
            contattoPlayer=true;
        }
        e.SArea.x = e.AreaSX;
        e.SArea.y = e.AreaSY;
        p.player.SArea.x = p.player.AreaSX;
        p.player.SArea.y = p.player.AreaSY;
        
        return contattoPlayer;
    }
}
