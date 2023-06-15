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
