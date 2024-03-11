
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chinaglia
 */
public class Distribuidor {

    public static void main(String args[]) {
        System.out.println("Olá, eu sou o Distribuidor e estou rodando a partir de... Agora!");
        try {
            int serverPort = 7896;
            ServerSocket listenSocket = new ServerSocket(serverPort);
            while (true) {
                Socket clientSocket = listenSocket.accept();
                Connection c = new Connection(clientSocket);
            }
        } catch (IOException e) {
            System.out.println("Listen socket: " + e.getMessage());
        }
    }
}

class Connection extends Thread {

    DataInputStream inputStream;
    DataOutputStream outputStream;
    Socket clientSocket;

    List<UDPSender> receptores = new ArrayList<>();

    public Connection(Socket aClientSocket) {
        try {
            clientSocket = aClientSocket;
            inputStream = new DataInputStream(clientSocket.getInputStream());
            outputStream = new DataOutputStream(clientSocket.getOutputStream());

            receptores.add(new UDPSender("localhost", 6787));
            receptores.add(new UDPSender("localhost", 6788));
            receptores.add(new UDPSender("localhost", 6789));

            this.start();

        } catch (IOException e) {
            System.out.println("Listen socket: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            String data = inputStream.readUTF();
            System.out.println("Recebido: " + data);
//            outputStream.writeUTF("Recebido: " + data);

            for (int i = 0; i < receptores.size(); i++) {
                UDPSender current = receptores.get(i);
                System.out.println("Publicando para " + current.getHost() + " na porta " + current.getServerPort());
                current.send(data);
            }

        } catch (EOFException e) {
            System.out.println("EOF: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("readline: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.out.println("Closing failed: " + e.getMessage());
            }
        }
    }
}

/**
 * Envia uma mensagem UDP para uma dada porta de um host
 *
 * @author chinaglia
 */
class UDPSender {

    private int serverPort;
    private String host;

    public UDPSender(String hostname, int portToSend) {
        serverPort = portToSend;
        host = hostname;
    }

    public void send(String message) {
        DatagramSocket aSocket = null;
        try {
            aSocket = new DatagramSocket();
            byte[] m = message.getBytes();
            InetAddress aHost = InetAddress.getByName(getHost());
            DatagramPacket request = new DatagramPacket(m, m.length, aHost, getServerPort());
            aSocket.send(request);
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

    /**
     * @return the serverPort
     */
    public int getServerPort() {
        return serverPort;
    }

    /**
     * @param serverPort the serverPort to set
     */
    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    /**
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }
}
