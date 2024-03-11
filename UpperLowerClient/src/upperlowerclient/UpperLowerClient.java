package upperlowerclient;

/**
 *
 * @author chinaglia
 */
public class UpperLowerClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String toUpper = "heitor";
            String upper = paraUpper(toUpper);

            System.out.println("paraUpper: " + upper);

            String toLower = "HEiToR";
            String lower = paraLower(toLower);

            System.out.println("paraLower: " + lower);
        } catch (Exception ex) {
            System.out.println("ex:" + ex);
        }
    }

    private static String paraLower(java.lang.String texto) {
        org.me.upperlower.UpperLowerServicde_Service service = new org.me.upperlower.UpperLowerServicde_Service();
        org.me.upperlower.UpperLowerServicde port = service.getUpperLowerServicdePort();
        return port.paraLower(texto);
    }

    private static String paraUpper(java.lang.String texto) {
        org.me.upperlower.UpperLowerServicde_Service service = new org.me.upperlower.UpperLowerServicde_Service();
        org.me.upperlower.UpperLowerServicde port = service.getUpperLowerServicdePort();
        return port.paraUpper(texto);
    }

}
