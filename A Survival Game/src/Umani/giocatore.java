package Umani;

import a.survival.game.Pannello;
import a.survival.game.Tastiera;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import oggetti.OGGscudo;
import oggetti.OGGspada;

/**
 *
 * @author Denis
 */
public class giocatore extends umani {

    Pannello p;
    Tastiera t;

    public final int schermoX;
    public final int schermoY;

    //public int coltelloSI=0;
    int ContFermo = 0;
    public boolean ContAttacchi = false;

    public giocatore(Pannello p, Tastiera t) {
        super(p);
        this.p=p;
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
        
        AreaAttacco.width=36;
        AreaAttacco.height=36;

        setBasi();
        getImmagineG();
        getImmagineAttaccoG();
    }

    public void setBasi() {
        Mondox = p.FinalAP * 54;
        Mondoy = p.FinalAP * 137;

        velocita = 15;
        direzione = "giu";

        //vita
        livello = 1;
        VitaMax = 6;
        vita = VitaMax;
        forza = 1; //più forza hai, più colpisci forte
        exp = 0;
        soldi = 0;
        spirito = 1; //più spirito hai, più sei invulnerabile
        Arma = new OGGspada(p);
        Scudo = new OGGscudo(p);
        attacco = getAttacco();
        difesa = getDifesa();
    }

    public int getAttacco() {
        return attacco = forza * Arma.attaccoSpada;
    }

    public int getDifesa() {
        return difesa = spirito * Scudo.difesaScudo;
    }

    public void getImmagineG() {
        su1 = setup("/immagini/giocatore/gsu1", p.FinalAP, p.FinalAP);
        su2 = setup("/immagini/giocatore/gsu2", p.FinalAP, p.FinalAP);
        giu1 = setup("/immagini/giocatore/gg1", p.FinalAP, p.FinalAP);
        giu2 = setup("/immagini/giocatore/gg2", p.FinalAP, p.FinalAP);
        sinistra1 = setup("/immagini/giocatore/gs1", p.FinalAP, p.FinalAP);
        sinistra2 = setup("/immagini/giocatore/gs2", p.FinalAP, p.FinalAP);
        destra1 = setup("/immagini/giocatore/gd1", p.FinalAP, p.FinalAP);
        destra2 = setup("/immagini/giocatore/gd2", p.FinalAP, p.FinalAP);
    }

    public void getImmagineAttaccoG() {
        attaccoSu1 = setup("/immagini/giocatore/agsu1", p.FinalAP, p.FinalAP*2);
        attaccoSu2 = setup("/immagini/giocatore/agsu2", p.FinalAP, p.FinalAP * 2);
        attaccoGiu1 = setup("/immagini/giocatore/agg1", p.FinalAP, p.FinalAP * 2);
        attaccoGiu2 = setup("/immagini/giocatore/agg2", p.FinalAP, p.FinalAP * 2);
        attaccoSinistra1 = setup("/immagini/giocatore/ags1", p.FinalAP * 2, p.FinalAP);
        attaccoSinistra2 = setup("/immagini/giocatore/ags2", p.FinalAP * 2, p.FinalAP);
        attaccoDestra1 = setup("/immagini/giocatore/agd1", p.FinalAP * 2, p.FinalAP);
        attaccoDestra2 = setup("/immagini/giocatore/agd2", p.FinalAP * 2, p.FinalAP);
    }

    public void muovi() {

        if (attaccando==true) {
            attaccando();
        } else if (t.su == true || t.giu == true || t.sinistra == true || t.destra == true || t.enterP == true) {
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
            int indNPC = p.collis.ControllaU(this, p.npc);
            interazNPC(indNPC);

            //collisioni con nemici
            int indNemici = p.collis.ControllaU(this, p.nemici);
            contattoNemici(indNemici);

            //controlla azione
            p.azioni.ControllaAzioni();

            t.enterP = false;

            if (collisioniSI == false && t.enterP == false) {
                switch (direzione) {
                    case "su":
                        Mondoy -= velocita;
                        break;
                    case "giu":
                        Mondoy += velocita;
                        break;
                    case "sinistra":
                        Mondox -= velocita;
                        break;
                    case "destra":
                        Mondox += velocita;
                        break;
                }
            }

            t.enterP = false;

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

        if (invincibile == true) {
            invincibileContatore++;
            if (invincibileContatore > 60) {
                invincibile = false;
                invincibileContatore = 0;
            }
        }
        
        if (vita<=0)
        {
            p.state=p.gameover;
        }
    }
    
    private void attaccando() {
        Contat++;
        if (Contat <= 5) {
            Num = 1;
        }
        if (Contat > 5 && Contat <= 25) {
            Num = 2;
            
            //controllo direzione del giocatore per la collisione con la spada
            int mondoXesatto=Mondox;
            int mondoYesatto=Mondoy;
            int SAreaLarghezza=SArea.width;
            int SAreaAltezza=SArea.height;
            switch(direzione) {
                case"su":Mondoy-=AreaAttacco.height;break;
                case "giu":Mondoy += AreaAttacco.height;break;
                case "sinistra":Mondox -= AreaAttacco.width;break;
                case "destra":Mondox += AreaAttacco.width;break;
            }
            //Area d'attacco
            SArea.width=AreaAttacco.width;
            SArea.height = AreaAttacco.height;
            //collisioni tra spada e nemico
            int IndMostri=p.collis.ControllaU(this, p.nemici);
            dannoNemico(IndMostri);
            
            Mondox=mondoXesatto;
            Mondoy=mondoYesatto;
            SArea.width=SAreaLarghezza;
            SArea.height = SAreaAltezza;
        }
        if (Contat > 25) {
            Num = 1;
            Contat = 0;
            attaccando = false;
        }
    }

    public void RaccogliOGG(int i) {
        if (i != 999) {

        }
    }

    public void interazNPC(int i) {
        if (i != 999) {
            if(p.tastiera.enterP==true) {
                p.state = p.dialoghi;
                p.npc[i].parla();
            }
        } else {
            if(p.tastiera.enterP==true) {
                attaccando = true;
            }
        }
    }

    public void contattoNemici(int i) {
        if (i != 999) {
            if (invincibile == false) {
                ContAttacchi = true;
                vita -= 1;
                invincibile = true;
            }

        }
    }
    
    public void dannoNemico(int i) {
        if(i!=999) {
           if(p.nemici[i].invincibile==false) {
               p.nemici[i].vita-=1;
               p.nemici[i].invincibile=true;
               
               if(p.nemici[i].vita<=0) {
                   p.nemici[i]=null;
               }
           }
        }    
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        int tempSX=schermoX;
        int tempSY=schermoY;

        switch (direzione) {
            case "su":
                if (attaccando==false) {
                    if (Num == 1) {image = su1;}
                    if (Num == 2) {image = su2;}
                }
                if (attaccando==true) {
                    
                    if (Num == 1) {image = attaccoSu1;}
                    if (Num == 2) {image = attaccoSu2;}
                }
                break;
            case "giu":
                if (attaccando==false) {
                    if (Num == 1) {image = giu1;}
                    if (Num == 2) {image = giu2;}
                }
                if (attaccando==true) {
                    if (Num == 1) {image = attaccoGiu1;}
                    if (Num == 2) {image = attaccoGiu2;}
                }
                break;
            case "sinistra":
                
                if (attaccando==false) {
                    if (Num == 1) {image = sinistra1;}
                    if (Num == 2) {image = sinistra2;}
                }
                if (attaccando==true) {
                    
                    if (Num == 1) {image = attaccoSinistra1;}
                    if (Num == 2) {image = attaccoSinistra2;}
                }
                break;
            case "destra":
                if (attaccando==false) {
                    if (Num == 1) {image = destra1;}
                    if (Num == 2) {image = destra2;}
                }
                if (attaccando==true) {
                    if (Num == 1) {image = attaccoDestra1;}
                    if (Num == 2) {image = attaccoDestra2;}
                }
                break;
        }
        if (invincibile == true) {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
        }
        if(image!=null)
            g2.drawImage(image, schermoX, schermoY,p.FinalAP,p.FinalAP, null);

        //reset alpha
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

//        //debug
//        g2.setFont(new Font("Arial",Font.PLAIN,26));
//        g2.setColor(Color.white);
//        g2.drawString("Invincibile: "+invincibileContatore,10,400);
    }
}
