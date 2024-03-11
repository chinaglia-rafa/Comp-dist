
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

/**
 *
 * @author chinaglia
 */
public class MulticastPeer {

    public static void main(String args[]) {
        // argumentos são conteúdo da mensagem e o destino do grupo multicast
        // por exemplo 228.5.6.7

        MulticastSocket socket = null;

        int port = 6789;

        try {
            InetAddress group = InetAddress.getByName(args[1]);
            socket = new MulticastSocket(port);
            System.out.println("Time to live: " + socket.getTimeToLive());
            socket.setTimeToLive(0);
            System.out.println("TTL: " + socket.getTimeToLive());

            socket.joinGroup(group);

            byte[] message = args[0].getBytes();

            DatagramPacket messageOut = new DatagramPacket(message, message.length, group, port);

            socket.send(messageOut);

            byte[] buffer = new byte[1000];
            for (int i = 0; i < 3; i++) {
                buffer = new byte[1000];
                DatagramPacket messageIn = new DatagramPacket(buffer, buffer.length);
                socket.receive(messageIn);
                String mensagem = new String(messageIn.getData());
                mensagem = mensagem.trim();
                System.out.println("Mensagem recebida (" + mensagem.length() + "): " + mensagem);
                System.out.println("TTL: " + socket.getTimeToLive());
            }

            socket.leaveGroup(group);

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
