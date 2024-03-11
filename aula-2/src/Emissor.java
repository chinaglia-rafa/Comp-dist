
import java.io.*;
import java.net.*;

/**
 * Envia uma mensagem para um servidor de distribuição na porta 7896
 *
 * @author chinaglia
 */
public class Emissor {

    public static void main(String args[]) {
        // Argumentos são a mensagem e o nome do host
        Socket s = null;
        try {
            System.out.println("Olá, eu sou um Emissor e vou enviar a mensagem " + args[0]);

            int serverPort = 7896;
            s = new Socket(args[1], serverPort);
            DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
            outputStream.writeUTF(args[0]);
        } catch (UnknownHostException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (EOFException e) {
            System.out.println("EOF: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("readline: " + e.getMessage());
        } finally {
            if (s != null) try {
                s.close();
            } catch (IOException e) {
                System.out.println("close: " + e.getMessage());
            }
        }
    }
}
