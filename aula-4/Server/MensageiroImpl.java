
//exemplo de http://www.guj.com.br/articles/37
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MensageiroImpl extends UnicastRemoteObject implements Mensageiro {

    private float termo1;
    private float termo2;
    private char operador;

    public MensageiroImpl() throws RemoteException {
        super();
    }

    public void enviarMensagem(String msg) throws RemoteException {
        System.out.println(msg);
    }

    public String lerMensagem() throws RemoteException {
        return "This is not a Hello World! message";
    }

    public void setTermo1(float termo) throws RemoteException {
        termo1 = termo;
    }

    public void setTermo2(float termo) throws RemoteException {
        termo2 = termo;
    }

    public void setOperador(char operador) throws RemoteException {
        this.operador = operador;
    }

    public float calcular() throws RemoteException {
        switch (this.operador) {
            case '+':
                return termo1 + termo2;
            case '-':
                return termo1 - termo2;
            case '*':
                return termo1 * termo2;
            case '/':
                return termo1 / termo2;
        }

        return 0;
    }
}
