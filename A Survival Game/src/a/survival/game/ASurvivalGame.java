/**
 * @author Pugliano Denis, Occhiato Andrea
 * @version 1.0
 * @file ASurvivalGame.java
 * @brief Classe Main
 */

package a.survival.game;

import javax.swing.JFrame;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @class ASurvivalGame
 */
public class ASurvivalGame {

    /**Creo JFrame*/
    public static JFrame finestra;
            
    /**\brief
     * Classe main dove creo una JFrame con titolo e passo tutti i metodi che servono per avviare il gioco
     * @param args 
     */
    public static void main(String[] args) {
        finestra=new JFrame();
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setResizable(false);
        finestra.setTitle("A Survival Game");
        finestra.setUndecorated(true);
        
        Pannello pannello = new Pannello();
        finestra.add(pannello);
        
        finestra.pack();
        
        finestra.setLocationRelativeTo(null);
        finestra.setVisible(true);
        
        pannello.setGioco();
        pannello.startGameThread();
        
        //prova server
        try {

            DatagramSocket server = new DatagramSocket(12345);
            byte[] buffer = new byte[1500];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            server.receive(packet);
            byte[] dataReceived = packet.getData(); // copia del buffer dichiarato sopra
            String messaggioRicevuto = new String(dataReceived, 0, packet.getLength());
            System.out.println(messaggioRicevuto);

            String messaggio = "CIAO CLIENT!";
            byte[] sendBuffer = messaggio.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length);
            sendPacket.setAddress(packet.getAddress());
            sendPacket.setPort(packet.getPort());
            server.send(sendPacket);

        } catch (SocketException ex) {
            //Logger.getLogger(TestUDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Logger.getLogger(TestUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
