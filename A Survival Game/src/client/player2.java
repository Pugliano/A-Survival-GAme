package client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author Denis
 */
public class player2 {
        /**
     * @param args the command line arguments
     */
    
    public boolean pl2;
    
    public static void main(String[] args) {
        try {
            DatagramSocket client = new DatagramSocket();
            
            pl2=true;
            
            byte[] sendBuffer = messaggio.getBytes();
            
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length);
            sendPacket.setAddress(InetAddress.getByName("localhost"));
            sendPacket.setPort(12345);
            client.send(sendPacket);

            byte[] buffer = new byte[1500];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            client.receive(packet);
            byte[] dataReceived = packet.getData(); // copia del buffer dichiarato sopra
            String messaggioRicevuto = new String(dataReceived, 0, packet.getLength());
            System.out.println(messaggioRicevuto);

        } catch (SocketException ex) {
            //Logger.getLogger(TestUDPClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            //Logger.getLogger(TestUDPClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Logger.getLogger(TestUDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
