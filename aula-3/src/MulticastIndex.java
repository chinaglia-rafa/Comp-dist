
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author chinaglia
 */
public class MulticastIndex {

    public static void main(String args[]) {
        try {
            int serverPort = 6789;
            ServerSocket socket = new ServerSocket(serverPort);
            while (true) {
                Socket clientSocket = socket.accept();
                Connection c = new Connection(clientSocket);
            }
        }
    }
}

class Connection extends Thread {

    public Connection(Socket aSocket) {

    }
}
