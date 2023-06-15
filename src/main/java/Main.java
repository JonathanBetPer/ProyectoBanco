import BaseDeDatos.Conexion;

public class Main {

    public static Conexion conexion;
    private static String nombre;


    public static void main(String[]args){

        conexion = new Conexion("yoni13ja", 33333, "banco", "postgres", "Smr1234");
        conexion.initConection();

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LogIn().setVisible(true);
            }
        });

    }
}
