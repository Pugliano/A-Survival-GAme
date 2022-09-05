/**
 * @author Pugliano Denis, Occhiato Andrea
 * @version 1.0
 * @file Tuttecose.java
 * @brief Classe Per piazzare oggetti,mob,npc sulla mappa
 */

package a.survival.game;

import Entita.Ape;
import Entita.Entita;
import Entita.NPC_Anziano;
import Entita.Slime;
import oggetti.OGGcartello;

/**
 * @class Tuttecose
 */
public class Tuttecose {

    Pannello p;

    public Tuttecose(Pannello p) {
        this.p = p;
    }

    public void setoggetto() {
    }

    /**\brief
     * Metodo per mettere gli npc sulla mappa, in questo caso 2 
     */
    public void setNpc() {
        //npc anziano
//        p.gestNPC.add(new NPC_Anziano(p, true));
//        Entita temp = p.gestNPC.get(0);
//        temp.x = p.FinalAP * 56;
//        temp.y = p.FinalAP * 137;
//        temp.collisioniSI = true;
//        p.gestNPC.set(0, temp);
//        
//
//        p.gestNPC.add(new NPC_Anziano(p, false));
//        temp = p.gestNPC.get(1);
//        temp.x = p.FinalAP * 55;
//        temp.y = p.FinalAP * 93;
//        temp.collisioniSI = true;
//        p.gestNPC.set(1, temp);
    }

    /**
     * \brief Metodo per mettere i mob ostili sulla mappa, ogni 30 millisec spawnano tot mob ostili su tutta la mappa
     */
    public void setMob() {

//        Entita temp;
//        int conta = 0;
//
//        for (int i = 125; i < 150; i += 115) {
//            for (int j = 30; j < 150; j += 30) {
//                p.gestMob.add(new Ape(p));
//                temp = p.gestMob.get(conta);
//                temp.x = p.FinalAP * j;
//                temp.y = p.FinalAP * i;
//                temp.collisioniSI = true;
//                p.gestMob.set(conta, temp);
//                conta++;
//            }
//        }
        
//        conta = 0;
        
//        for (int i = 50; i < 150; i += 35) {
//            for (int j = 50; j < 150; j += 35) {
//                p.gestMob.add(new Slime(p));
//                temp = p.gestMob.get(conta);
//                temp.x = p.FinalAP * j;
//                temp.y = p.FinalAP * i;
//                temp.collisioniSI = true;
//                p.gestMob.set(conta, temp);
//                conta++;
//            }
//        }
    }
}
