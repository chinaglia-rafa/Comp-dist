
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author chinaglia
 */
public class Receptor {

    public static void main(String args[]) {
        // argumento é a porta que o receptor estará ouvindo
        DatagramSocket aSocket = null;
        try {
            int serverPort = Integer.parseInt(args[0]);
            System.out.println("Olá, eu sou um Receptor, e estou aguardando mensagens serem enviadas para a porta " + serverPort + "!");

            aSocket = new DatagramSocket(serverPort);
            byte[] buffer = new byte[1000];

            while (true) {
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(request);
                // Trunca a request para conter apenas o conteúdo
                String message = new String(request.getData(), request.getOffset(), request.getLength());
                System.out.println("request is: " + message);
            }
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (aSocket != null) {
                aSocket.close();
            }
        }
    }
}
