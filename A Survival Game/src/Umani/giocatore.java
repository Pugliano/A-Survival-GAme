package Umani;

import a.survival.game.Pannello;
import a.survival.game.Tastiera;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author Denis
 */
public class giocatore extends umani {

    Tastiera t;

    public final int schermoX;
    public final int schermoY;

    //public int coltelloSI=0;
    int ContFermo = 0;

    public giocatore(Pannello p, Tastiera t) {
        super(p);
        this.t = t;

        schermoX = p.FinestraL / 2 - (p.FinalAP / 2);
        schermoY = p.FinestraL / 2 - (p.FinalAP / 2);

        SArea = new Rectangle();
        SArea.x = 8;
        SArea.y = 16;
        AreaSX = SArea.x;
        AreaSY = SArea.y;
        SArea.width = 32;
        SArea.height = 32;

        setBasi();
        getImmagineG();
    }

    public void setBasi() {
        Mondox = p.FinalAP * 54;
        Mondoy = p.FinalAP * 137;
        velocita = 15;
        direzione = "giu";
        
        //vita
        VitaMax=6;
        vita=VitaMax;
    }

    public void getImmagineG() {
        su1 = setup("/immagini/giocatore/gsu1");
        su2 = setup("/immagini/giocatore/gsu2");
        giu1 = setup("/immagini/giocatore/gg1");
        giu2 = setup("/immagini/giocatore/gg2");
        sinistra1 = setup("/immagini/giocatore/gs1");
        sinistra2 = setup("/immagini/giocatore/gs2");
        destra1 = setup("/immagini/giocatore/gd1");
        destra2 = setup("/immagini/giocatore/gd2");
    }

    public void muovi() {

        if (t.su == true || t.giu == true || t.sinistra == true || t.destra == true) {
            if (t.su == true) {
                direzione = "su";
            } else if (t.giu == true) {
                direzione = "giu";
            } else if (t.sinistra == true) {
                direzione = "sinistra";
            } else if (t.destra == true) {
                direzione = "destra";
            }

            //collisioni blocco controlli
            collisioniSI = false;
            p.collis.Controlla(this);

            //collisioni con oggetti o no
            int indOGG = p.collis.ControllaOGG(this, true);
            RaccogliOGG(indOGG);
            
            //collisioni con npc
            int indNPC=p.collis.ControllaU(this, p.npc);
            interazNPC(indNPC);

            if (collisioniSI == false) {
                switch (direzione) {
                    case "su": Mondoy -= velocita; break;
                    case "giu": Mondoy += velocita; break;
                    case "sinistra": Mondox -= velocita; break;
                    case "destra": Mondox += velocita; break;
                }
            }

            Contat++;
            if (Contat > 12) {
                if (Num == 1) {
                    Num = 2;
                } else if (Num == 2) {
                    Num = 1;
                }
                Contat = 0;
            }
        } else {
            ContFermo++;
            if (ContFermo == 20) {
                Num = 1;
                ContFermo = 0;
            }
        }
    }

    public void RaccogliOGG(int i) {
        if (i != 999) {

        }
    }
    
    public void interazNPC(int i) {
        if (i != 999) {
            if(p.tastiera.enterP==true) {
                p.dialoghi = true;
                p.npc[i].parla();
            }
            p.tastiera.enterP=false;
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        switch (direzione) {
            case "su":
                if (Num == 1) {
                    image = su1;
                }
                if (Num == 2) {
                    image = su2;
                }
                break;
            case "giu":
                if (Num == 1) {
                    image = giu1;
                }
                if (Num == 2) {
                    image = giu2;
                }
                break;
            case "sinistra":
                if (Num == 1) {
                    image = sinistra1;
                }
                if (Num == 2) {
                    image = sinistra2;
                }
                break;
            case "destra":
                if (Num == 1) {
                    image = destra1;
                }
                if (Num == 2) {
                    image = destra2;
                }
                break;
        }
        g2.drawImage(image, schermoX, schermoY,p.FinalAP, p.FinalAP, null);
    }
}
