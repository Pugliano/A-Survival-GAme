package a.survival.game;

import Umani.umani;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author Denis
 */
public class Collisioni {
    Pannello p;
    
    public Collisioni(Pannello p) {
        this.p=p;
    }

    public void controllaCollisioni(umani u) {
        int USMX=u.mondoX+u.SArea.x; //set bordo sinistro degli umani per le collisioni
        int UDMX=u.mondoX+u.SArea.x+u.SArea.width; //set bordo destro degli umani per le collisioni
        int UTMY=u.mondoY+u.SArea.y; //set bordo in alto degli umani per le collisioni
        int UGMY=u.mondoY+u.SArea.y+u.SArea.height; //set bordo in basso degli umani per le collisioni
    
        int USCol=USMX/p.FinalAP; 
        int UDCol=UDMX/p.FinalAP;
        int UTRig=UTMY/p.FinalAP;
        int UGRig=UGMY/p.FinalAP;
        
        int tileN1,tileN2;
        
        switch(u.direzione) {
            case "su":
//                UTRig=(UTMY-u.velocita)/p.FinalAP;
//                tileN1=p.gestione.Nmappe[USCol][UTRig];
//                tileN2=p.gestione.Nmappe[UDCol][UTRig];
//                if(p.gestione.blocco[tileN1].collisioni==true||p.gestione.blocco[tileN2].collisioni==true) {
//                    u.collisioniOn=true;
//                }
                break;
            case "giu":
//                UGRig = (UGMY + u.velocita) / p.FinalAP;
//                tileN1 = p.gestione.Nmappe[USCol][UGRig];
//                tileN2 = p.gestione.Nmappe[UDCol][UGRig];
//                if (p.gestione.blocco[tileN1].collisioni == true || p.gestione.blocco[tileN2].collisioni == true) {
//                    u.collisioniOn = true;
//                }
                break;
            case "sinistra":
//                USCol = (USMX - u.velocita) / p.FinalAP;
//                tileN1 = p.gestione.Nmappe[USCol][UTRig];
//                tileN2 = p.gestione.Nmappe[USCol][UGRig];
//                if (p.gestione.blocco[tileN1].collisioni == true || p.gestione.blocco[tileN2].collisioni == true) {
//                    u.collisioniOn = true;
//                }
                break;
            case "destra":
//                UDCol = (UDMX - u.velocita) / p.FinalAP;
//                tileN1 = p.gestione.Nmappe[UDCol][UTRig];
//                tileN2 = p.gestione.Nmappe[UDCol][UGRig];
//                if (p.gestione.blocco[tileN1].collisioni == true || p.gestione.blocco[tileN2].collisioni == true) {
//                    u.collisioniOn = true;
//                }
                break;
        }
    }
    public int ControllaOGG(umani u, boolean giocatore) {
        int ind=999;
        for (int i = 0; i < p.ogg.length; i++) {
            if(p.ogg[i]!=null) {
                u.SArea.x=u.mondoX+u.SArea.x;
                u.SArea.y=u.mondoY+u.SArea.y;
                
                //vedere posizione degli oggetti piazzati
                p.ogg[i].SArea.x=p.ogg[i].mondox+p.ogg[i].SArea.x;
                p.ogg[i].SArea.y=p.ogg[i].mondoy+p.ogg[i].SArea.y;
                
                switch(u.direzione) {
                    case"su":
                        u.SArea.y-=u.velocita;
                        if(u.SArea.intersects(p.ogg[i].SArea)) {
                            if(p.ogg[i].collisioni==true) {
                                u.collisioniOn=true;
                            }
                            if(giocatore==true) {
                                ind=i;
                            }
                        }
                        break;
                    case"giu":
                        u.SArea.y+=u.velocita;
                        if(u.SArea.intersects(p.ogg[i].SArea)) {
                            if (p.ogg[i].collisioni == true) {
                                u.collisioniOn = true;
                            }
                            if (giocatore == true) {
                                ind = i;
                            }
                        }
                        break;
                    case "sinistra":
                        u.SArea.x -= u.velocita;
                        if (u.SArea.intersects(p.ogg[i].SArea)) {
                            if (p.ogg[i].collisioni == true) {
                                u.collisioniOn = true;
                            }
                            if (giocatore == true) {
                                ind = i;
                            }
                        }
                        break;
                    case"destra":
                        u.SArea.x+=u.velocita;
                        if(u.SArea.intersects(p.ogg[i].SArea)) {
                            if (p.ogg[i].collisioni == true) {
                                u.collisioniOn = true;
                            }
                            if (giocatore == true) {
                                ind = i;
                            }
                        }
                    break;
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
                u.SArea.x = u.mondoX + u.SArea.x;
                u.SArea.y = u.mondoY + u.SArea.y;

                //vedere posizione degli oggetti piazzati
                target[i].SArea.x = target[i].mondoX + target[i].SArea.x;
                target[i].SArea.y = target[i].mondoY + target[i].SArea.y;

                switch (u.direzione) {
                    case "su":
                        u.SArea.y -= u.velocita;
                        if (u.SArea.intersects(target[i].SArea)) {
                            u.collisioniOn = true;
                            ind = i;   
                        }
                        break;
                    case "giu":
                        u.SArea.y += u.velocita;
                        if (u.SArea.intersects(target[i].SArea)) {
                            u.collisioniOn = true;
                            ind = i;
                        }
                        break;
                    case "sinistra":
                        u.SArea.x -= u.velocita;
                        if (u.SArea.intersects(target[i].SArea)) {
                            u.collisioniOn = true;
                            ind = i;
                        }
                        break;
                    case "destra":
                        u.SArea.x += u.velocita;
                        if (u.SArea.intersects(target[i].SArea)) {
                            u.collisioniOn = true;
                            ind = i;
                        }
                        break;
                }
                u.SArea.x = u.AreaSX;
                u.SArea.y = u.AreaSY;
                target[i].SArea.x = target[i].AreaSX;
                target[i].SArea.y = target[i].AreaSY;
            }
        }
        return ind;
    }
    
    public void ControllaP(umani u) {
        u.SArea.x = u.mondoX + u.SArea.x;
        u.SArea.y = u.mondoY + u.SArea.y;

        //vedere posizione degli oggetti piazzati
        p.player.SArea.x = p.player.mondoX + p.player.SArea.x;
        p.player.SArea.y = p.player.mondoY + p.player.SArea.y;

        switch (u.direzione) {
            case "su":
                u.SArea.y -= u.velocita;
                if (u.SArea.intersects(p.player.SArea)) {
                    u.collisioniOn = true;
                }
                break;
            case "giu":
                u.SArea.y += u.velocita;
                if (u.SArea.intersects(p.player.SArea)) {
                    u.collisioniOn = true;
                }
                break;
            case "sinistra":
                u.SArea.x -= u.velocita;
                if (u.SArea.intersects(p.player.SArea)) {
                    u.collisioniOn = true;
                }
                break;
            case "destra":
                u.SArea.x += u.velocita;
                if (u.SArea.intersects(p.player.SArea)) {
                    u.collisioniOn = true;
                }
                break;
        }
        u.SArea.x = u.AreaSX;
        u.SArea.y = u.AreaSY;
        p.player.SArea.x = p.player.AreaSX;
        p.player.SArea.y = p.player.AreaSY;
    }
}
