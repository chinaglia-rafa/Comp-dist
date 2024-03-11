
// exemplo de http://www.guj.com.br/articles/37
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class MensageiroClient {

    public static void main(String args[]) {
        try {
            Mensageiro mref = (Mensageiro) Naming.lookup("rmi://localhost:1099/MensageiroService");
            System.out.println(mref.lerMensagem());
            mref.enviarMensagem("Hello World!");
            mref.setTermo1(10);
            mref.setTermo2(5);
            mref.setOperador('+');
            System.out.println(mref.calcular());
        } catch (MalformedURLException e) {
            System.out.println();
            System.out.println("MalformedURLException: " + e.toString());
        } catch (RemoteException e) {
            System.out.println();
            System.out.println("RemoteException: " + e.toString());
        } catch (NotBoundException e) {
            System.out.println();
            System.out.println("NotBoundException: " + e.toString());
        } catch (Exception e) {
            System.out.println();
            System.out.println("Exception: " + e.toString());
        }
    }
}
