/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entita;

import a.survival.game.Pannello;
import java.util.Random;

/**
 *
 * @author Andrea
 */
public class NPC_Anziano extends NPC{
    boolean tutorial;

    public NPC_Anziano(Pannello p,boolean tutorial) {
        super(p);
        direzione = "giu";
        velocita = 1;
        this.tutorial=tutorial;

        getImmagineV();
        setDialoghi();
    }

    public void getImmagineV() {
        su1 = setup("/immagini/npc/Vsu1",p.FinalAP,p.FinalAP);
        su2 = setup("/immagini/npc/vsu2",p.FinalAP,p.FinalAP);
        giu1 = setup("/immagini/npc/vgiu1",p.FinalAP,p.FinalAP);
        giu2 = setup("/immagini/npc/vgiu2",p.FinalAP,p.FinalAP);
        sinistra1 = setup("/immagini/npc/vsinistra1",p.FinalAP,p.FinalAP);
        sinistra2 = setup("/immagini/npc/vsinistra2",p.FinalAP,p.FinalAP);
        destra1 = setup("/immagini/npc/vdestra1",p.FinalAP,p.FinalAP);
        destra2 = setup("/immagini/npc/vdestra2",p.FinalAP,p.FinalAP);
    }

    public void setDialoghi() {
        if (tutorial)
        {
            dial[0] = "Ciao, sono un fantasma. Sono morto qui 27 anni fa";
            dial[1] = "Per muoverti usa WASD.\nPer attaccare un mostro usa INVIO\nPer parlare con un NPC usa INVIO\nPer visualizzare le tue statistiche usa C";
            dial[2] = "Spero di esserti stato utile";
            dial[3] = "Non so se ci rivedremo in questa forma";
        }
        else{
            dial[0] = "Ciao";
            dial[1] = "Sono un fantasma";
            dial[2] = "Ma sono anche un mago, quindi tieni";
        }
    }

    @Override
    public void setMove() {
        if (p.state == p.dialoghi) {
            
        } 
        else if (tutorial)
        {
            
        }
        else {
            VelocitaM++;
            if (VelocitaM == 150) {
                Random random = new Random();
                int i = random.nextInt(100) + 1;

                if (i <= 25) {
                    direzione = "su";
                }
                if (i > 25 && i <= 50) {
                    direzione = "giu";
                }
                if (i > 50 && i <= 75) {
                    direzione = "sinistra";
                }
                if (i > 75 && i <= 100) {
                    direzione = "destra";
                }
                VelocitaM = 0;
            }
        }
    }

    public void parla() {
        super.parla();
        if(p.gestNPC.get(0).Inddialoghi==4)
        {
            p.gestNPC.remove(0);
        }
    }
}
