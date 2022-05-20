/**
 * @author Pugliano Denis, Occhiato Andrea
 * @version 1.0
 * @file Giocatore.java
 * @brief Classe per settare player
 */
package Entita;

import a.survival.game.Pannello;
import a.survival.game.Tastiera;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import oggetti.OGGscudo;
import oggetti.OGGspada;

/**
 * @class Giocatore
 * @brief Classe con extends Entita
 */
public class Giocatore extends Entita{
    
    /**setto immagi per quando attacca ill giocatore*/
    public BufferedImage attaccoSu1, attaccoSu2, attaccoGiu1, attaccoGiu2, attaccoSinistra1, attaccoSinistra2, attaccoDestra1, attaccoDestra2;
    
    /**statistiche giocatore*/
    public int livello;
    public int forza;
    public int attacco;
    public int difesa;
    public int spirito;
    public int exp;
    public int soldi;
    public Entita Arma;
    public Entita Scudo;
    
    /**statistiche armi*/
    public int attaccoSpada;
    public int difesaScudo;                       
    
    boolean attaccando=false;
    
    public final int schermoX;
    public final int schermoY;

    /**public int coltelloSI=0;*/
    int ContFermo = 0;
    public boolean ContAttacchi = false;

    /**\brief
     * Metodo per caricare immagine del giocatore nel gioco
     * @param p
     * @param t 
     */
    public Giocatore(Pannello p, Tastiera t) {
        super(p,t);

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

    /**\brief
     * Metodo per settare i valori base del giocatore
     */
    public void setBasi() {
        /**x dove spawna*/
        x = p.FinalAP * 54;
        /**y dove spawna*/
        y = p.FinalAP * 137;

        /**velocita*/
        velocita = 4;
        /**direzione fissa quando spawna*/
        direzione = "giu";

        /**vita*/
        livello = 1;
        VitaMax = 6;
        vita = VitaMax;
        /**
         * più forza hai, più colpisci forte
         */
        forza = 1; 
        exp = 0;
        soldi = 0;
        /**
         * più spirito hai, più sei invulnerabile
         */
        spirito = 1; 
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

    /**\brief
     * setto le immagini quando cammino
     */
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

    /**\brief
     * setto le immagini quando attacco
     */
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

    /**\brief
     * Metodo per far muovere il player e per caricare in base la direzione l'immagine giusta
     */
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
            int indNPC = p.collis.ControllaU(this, p.gestNPC);
            interazNPC(indNPC);

            //collisioni con nemici
            int indNemici = p.collis.ControllaU(this, p.gestMob);
            contattoNemici(indNemici);

            //controlla azione
            p.azioni.ControllaAzioni();

            t.enterP = false;

            if (collisioniSI == false && t.enterP == false) {
                switch (direzione) {
                    case "su":
                        y -= velocita;
                        break;
                    case "giu":
                        y += velocita;
                        break;
                    case "sinistra":
                        x -= velocita;
                        break;
                    case "destra":
                        x += velocita;
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
    
    /**\brief
     * Metodo per caricare le immagini quando attacco
     */
    private void attaccando() {
        Contat++;
        if (Contat <= 5) {
            Num = 1;
        }
        if (Contat > 5 && Contat <= 25) {
            Num = 2;
            
            //controllo direzione del giocatore per la collisione con la spada
            int mondoXesatto=x;
            int mondoYesatto=y;
            int SAreaLarghezza=SArea.width;
            int SAreaAltezza=SArea.height;
            switch(direzione) {
                case"su":y-=AreaAttacco.height;break;
                case "giu":y += AreaAttacco.height;break;
                case "sinistra":x -= AreaAttacco.width;break;
                case "destra":x += AreaAttacco.width;break;
            }
            //Area d'attacco
            SArea.width=AreaAttacco.width;
            SArea.height = AreaAttacco.height;
            //collisioni tra spada e nemico
            int IndMostri=p.collis.ControllaU(this, p.gestMob);
            dannoNemico(IndMostri);
            
            x=mondoXesatto;
            y=mondoYesatto;
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
                p.gestNPC.get(i).parla();
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
    
    /**\brief
     * quando attacco i nemici diventano involnerabili per breve tempo
     * @param i 
     */
    public void dannoNemico(int i) {
        if(i!=999) {
           if(p.gestMob.get(i).invincibile==false) {
               Entita temp = p.gestMob.get(i);
               temp.vita-=1;
               temp.invincibile=true;
               if(temp.vita<=0) {
                   temp=null;
               }
               p.gestMob.set(i,temp);
           }
        }    
    }

    /**\brief
     * Metodo draw per printare sullo schermo tali immagini
     * @param g2 
     */
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
        
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
    }
    
    
}
