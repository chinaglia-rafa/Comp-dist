package entappclient;

import ejb.MySessionRemote;
import javax.ejb.EJB;

/**
 *
 * @author chinaglia
 */
public class Main {

    @EJB
    private static MySessionRemote mySession;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        System.out.println("result = " + mySession.getResult());

        double a = 8.0;
        double b = 0.5;
        System.out.println("Soma de " + a + " + " + b + " = " + mySession.getSoma(a, b));

        System.out.println("Produto de " + a + " * " + b + " = " + mySession.getProduto(a, b));
    }

}
