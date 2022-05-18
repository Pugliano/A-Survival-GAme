package a.survival.game;

import Umani.umani;
import blocchi.TileManager;
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
    public void Controlla(umani u) {
        int id;
        switch (u.direzione) {
            case "su":
                id = Nmappe[p.player.Mondox / p.FinalAP][p.player.Mondoy / p.FinalAP -1];
                if (tm.getTile(id).getTileType() == 1) {
                    u.collisioniSI = true;
                }
                break;
            case "giu":
                id = Nmappe[p.player.Mondox / p.FinalAP+2][p.player.Mondoy / p.FinalAP+2];
                if (tm.getTile(id).getTileType() == 1) {
                    u.collisioniSI = true;
                }
                break;
            case "sinistra":
                id = Nmappe[p.player.Mondox / p.FinalAP - 1][p.player.Mondoy / p.FinalAP+2];
                if (tm.getTile(id).getTileType() == 1) {
                    u.collisioniSI = true;
                }
                break;
            case "destra":
                id = Nmappe[p.player.Mondox / p.FinalAP + 2][p.player.Mondoy / p.FinalAP+2];
                if (tm.getTile(id).getTileType() == 1) {
                    u.collisioniSI = true;
                }
                break;
        }

    }
    public int ControllaOGG(umani u, boolean giocatore) {
        int ind=999;
        for (int i = 0; i < p.ogg.length; i++) {
            if(p.ogg[i]!=null) {
                u.SArea.x=u.Mondox+u.SArea.x;
                u.SArea.y=u.Mondoy+u.SArea.y;
                
                //vedere posizione degli oggetti piazzati
                p.ogg[i].SArea.x=p.ogg[i].Mondox+p.ogg[i].SArea.x;
                p.ogg[i].SArea.y=p.ogg[i].Mondoy+p.ogg[i].SArea.y;
                
                switch(u.direzione) {
                    case"su": u.SArea.y-=u.velocita;break;
                    case"giu": u.SArea.y+=u.velocita;break;
                    case "sinistra": u.SArea.x -= u.velocita; break;
                    case"destra": u.SArea.x+=u.velocita;break;
                }
                if (u.SArea.intersects(p.ogg[i].SArea)) {
                    if (p.ogg[i].collisioni == true) {
                        u.collisioniSI = true;
                    }
                    if (giocatore == true) {
                        ind = i;
                    }
                }
                
                u.SArea.x=u.AreaSX;
                u.SArea.y=u.AreaSY;
                p.ogg[i].SArea.x=p.ogg[i].AreaSX;
                p.ogg[i].SArea.y = p.ogg[i].AreaSY;
            }
        }
        return ind;
    }
    
    //npc o nemici collisioni
    public int ControllaU(umani u,umani[] target) {
        int ind = 999;
        for (int i = 0; i < target.length; i++) {
            if (target[i] != null) {
                u.SArea.x = u.Mondox + u.SArea.x;
                u.SArea.y = u.Mondoy + u.SArea.y;

                //vedere posizione degli oggetti piazzati
                target[i].SArea.x = target[i].Mondox + target[i].SArea.x;
                target[i].SArea.y = target[i].Mondoy + target[i].SArea.y;

                switch (u.direzione) {
                    case "su": u.SArea.y -= u.velocita;break;
                    case "giu": u.SArea.y += u.velocita;break;
                    case "sinistra": u.SArea.x -= u.velocita;break;
                    case "destra": u.SArea.x += u.velocita;break;
                }
                
                if(u.SArea.intersects(target[i].SArea)) {
                    if(target[i]!=u) {
                        u.collisioniSI = true;
                        ind = i;
                    }
                }
                
                u.SArea.x = u.AreaSX;
                u.SArea.y = u.AreaSY;
                target[i].SArea.x = target[i].AreaSX;
                target[i].SArea.y = target[i].AreaSY;
            }
        }
        return ind;
    }
    
    //collisioni con player da parte di npc
    public boolean ControllaP(umani u) {
        boolean contattoPlayer = false;
        u.SArea.x = u.Mondox + u.SArea.x;
        u.SArea.y = u.Mondoy + u.SArea.y;

        //vedere posizione degli oggetti piazzati
        p.player.SArea.x = p.player.Mondox + p.player.SArea.x;
        p.player.SArea.y = p.player.Mondoy + p.player.SArea.y;

        switch (u.direzione) {
            case "su":u.SArea.y -= u.velocita;break;
            case "giu":u.SArea.y += u.velocita;break;
            case "sinistra":u.SArea.x -= u.velocita;break;
            case "destra":u.SArea.x += u.velocita;break;
        }
        
        if (u.SArea.intersects(p.player.SArea)) {
            u.collisioniSI = true;
            contattoPlayer=true;
        }
        u.SArea.x = u.AreaSX;
        u.SArea.y = u.AreaSY;
        p.player.SArea.x = p.player.AreaSX;
        p.player.SArea.y = p.player.AreaSY;
        
        return contattoPlayer;
    }
}
