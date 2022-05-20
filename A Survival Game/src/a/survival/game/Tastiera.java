/**
 * @author Pugliano Denis, Occhiato Andrea
 * @version 1.0
 * @file Tastiera.java
 * @brief Classe Per implementare i tasti
 */

package a.survival.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @class Tastiera
 * @brief extends KeyListener
 */
public class Tastiera implements KeyListener {

    Pannello p;
    public boolean su, giu, sinistra, destra;
    public boolean enterP;

    public Tastiera(Pannello p) {
        this.p = p;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**\brief
     * metodo per settare i tasti quando li premo
     * @param e 
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int tasto = e.getKeyCode();
        enterP = false;

        /**settaggio tasti nel menu*/
        if (p.state == p.menu) {
            menu(tasto);
        } /**settaggio tasti nel gioco*/
        else if (p.state == p.gioco) {
            gioco(tasto);
        } /**
         * settaggio tasto nel gioco quando premo P
         */
        else if (p.pausa == true) {
            pausa(tasto);
        } /**
         * settaggio tasto nel gioco quando premo ENTER vicino a un npc
         */
        else if (p.state == p.dialoghi) {
            dialogo(tasto);
        } /**
         * settaggio tasto nel gioco quando premo C
         */
        else if (p.state == p.dati) {
            datiPlayer(tasto);
            /**
             * settaggio tasto nel gioco quando perdo
             */
        } else if (p.state == p.gameover) {
            gameover(tasto);
        }

    }

    public void menu(int tasto) {
        if (tasto == KeyEvent.VK_UP) {
            if (p.messaggi.comandi != 0) {
                p.messaggi.comandi--;
            }
        }
        if (tasto == KeyEvent.VK_DOWN) {
            if (p.messaggi.comandi != 1) {
                p.messaggi.comandi++;
            }
        }
        if (tasto == KeyEvent.VK_ENTER) {
            switch (p.messaggi.comandi) {
                case 0:
                    System.out.println("gioca");
                    p.state = p.gioco;
                    break;
                case 1:
                    System.out.println("esci");
                    System.exit(0);
                    break;
                default:
                    break;
            }
            p.messaggi.comandi = 0;
        }
    }

    public void gioco(int tasto) {
        if (tasto == KeyEvent.VK_W) {
            su = true;
        }

        if (tasto == KeyEvent.VK_S) {
            giu = true;
        }

        if (tasto == KeyEvent.VK_A) {
            sinistra = true;
        }

        if (tasto == KeyEvent.VK_D) {
            destra = true;
        }

        if (tasto == KeyEvent.VK_P) {
            p.setPausa(!p.getPausa());
        }

        if (tasto == KeyEvent.VK_ESCAPE) {
            p.state = p.menu;
        }
        if (tasto == KeyEvent.VK_ENTER) {
            enterP = true;
        }

        if (tasto == KeyEvent.VK_C) {
            p.state = p.dati;
        }

        if (tasto == KeyEvent.VK_K) {
            p.player.vita = 0;
        }
    }

    public void pausa(int tasto) {
        if (tasto == KeyEvent.VK_P) {
            p.setPausa(!p.getPausa());
        }
    }

    public void dialogo(int tasto) {
        if (tasto == KeyEvent.VK_ENTER) {
            p.state = p.gioco;
        }
    }

    public void datiPlayer(int tasto) {
        if (tasto == KeyEvent.VK_C) {
            p.state = p.gioco;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int tasto = e.getKeyCode();

        if (tasto == KeyEvent.VK_W) {
            su = false;
        }

        if (tasto == KeyEvent.VK_S) {
            giu = false;
        }

        if (tasto == KeyEvent.VK_A) {
            sinistra = false;
        }

        if (tasto == KeyEvent.VK_D) {
            destra = false;
        }
    }

    public void gameover(int tasto) {
        if (tasto == KeyEvent.VK_UP) {
            if (p.messaggi.comandigo != 0) {
                p.messaggi.comandigo--;
            }
        }
        if (tasto == KeyEvent.VK_DOWN) {
            if (p.messaggi.comandigo != 1) {
                p.messaggi.comandigo++;
            }
        }
        if (tasto == KeyEvent.VK_ENTER) {
            switch (p.messaggi.comandigo) {
                case 0:
                    System.out.println("rigenera");
                    p.player.vita = p.player.VitaMax;
                    p.state = p.gioco;
                    break;
                case 1:
                    System.out.println("torna al menu");
                    p.player.vita = p.player.VitaMax;
                    p.state = p.menu;

                    break;
                default:
                    break;
            }

            p.messaggi.comandigo = 0;
        }
    }
}
