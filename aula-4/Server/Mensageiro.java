// exemplo de http://www.guj.com.br/articles/37

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Mensageiro extends Remote {

    public void enviarMensagem(String msg) throws RemoteException;

    public String lerMensagem() throws RemoteException;

    public void setTermo1(float termo) throws RemoteException;

    public void setTermo2(float termo) throws RemoteException;

    public void setOperador(char operador) throws RemoteException;

    public float calcular() throws RemoteException;
}
