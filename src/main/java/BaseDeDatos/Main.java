package BaseDeDatos;

import interfaz.Cuenta;
import interfaz.LogIn;

public class Main {

    public static Conexion conexion;

    private static String nombre;


    public static void main(String[]args){

        conexion = new Conexion("localhost", 5433, "Banco", "postgres", "asdasd123");
        conexion.initConection();

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LogIn().setVisible(true);
            }
        });

    }
}
