package BaseDeDatos;

import interfaz.LogIn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import PaquetePrincipal.Main;



public class tratamientodedatos {

    private static Conexion c;
    private static LogIn login;
    private static String nombre;
    private static int numero;
    private static String dniCliente;
    private static String tipo;
    private static double saldo;
    private static String fechaAlta;


    public tratamientodedatos() {

        c = Main.conexion;


    }

    public boolean comprobarContrasena(String usuario, String contrasena) {
        if (!Objects.equals(usuario, "")) {

            try {

                String contrasenaResultado = "";
                String nombreResultado = "";


                PreparedStatement sql1 = Conexion.getC().prepareStatement("select contrasena from clientes where dni = ?");
                sql1.setString(1, usuario);
                ResultSet resultContra = sql1.executeQuery();


                PreparedStatement sql2 = Conexion.getC().prepareStatement("select nombre from clientes where dni = ?");
                sql2.setString(1, usuario);
                ResultSet resultNombre = sql2.executeQuery();


                while (resultContra.next()) {
                    contrasenaResultado = resultContra.getString("contrasena");
                }

                while (resultNombre.next()) {
                    nombreResultado = resultNombre.getString("nombre");
                    nombre=nombreResultado;
                }


                if (contrasenaResultado.equals(contrasena)) {
                    System.out.println("todo bien");
                    return true;
                }


            } catch (SQLException j) {
                System.out.println(j.getMessage());

            }
        }
        return false;
    }




    public static String getNombre() {
        return nombre;
    }


}
