/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entita;

import a.survival.game.Pannello;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrea
 */
public class NPC extends Entita {

    String[] dial = new String[20];
    public int Inddialoghi = 0;

    public NPC(Pannello p) {
        super(p);
    }
    
    @Override
    public void parla() {
        if (dial[Inddialoghi] == null) {
            Inddialoghi = 0;
        }
        p.messaggi.Dcorrente = dial[Inddialoghi];
        Inddialoghi++;

        switch (p.player.direzione) {
            case "su":
                direzione = "giu";
                p.player.vita = p.player.VitaMax;
                break;
            case "giu":
                direzione = "su";
                p.player.vita = p.player.VitaMax;
                break;
            case "sinistra":
                direzione = "destra";
                p.player.vita = p.player.VitaMax;
                break;
            case "destra":
                direzione = "sinistra";
                p.player.vita = p.player.VitaMax;
                break;
        }
    }

    @Override
    public void run() {
        while (true) {
            if (p.state != p.gioco) {
                continue;
            }
            muovi();
            try {
                sleep(16);
            } catch (InterruptedException ex) {
                Logger.getLogger(NPC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
