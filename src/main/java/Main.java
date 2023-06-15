/**
 * Clase Principal de Proyecto Banco
 *
 * @since 06/06/2023
 * @author JonathanBetPer
 * @author carlosaldea3
 * @author AlejandroYgr
 * @version 1.0
 */
public class Main {

    public static Conexion conexion;
    public static Usuario usuarioActual;


    public static void main(String[]args){

        conexion = new Conexion("yoni13ja.ddns.net", 33333, "banco", "postgres", "Smr1234");
        conexion.iniciar();

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LogIn().setVisible(true);
            }
        });

    }
}
