import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public abstract class tratamientoDatos {

    private static LogIn login;



    public static boolean verificarLogIn(Conexion c, String usuario, String contrasena) {

        if (!Objects.equals(usuario, "")) {
            try {

                String contrasenaResultado = "";
                String nombreResultado = "";


                PreparedStatement sql1 = Conexion.getC().prepareStatement("select contrasena from clientes where dni = ?");
                sql1.setString(1, usuario);
                ResultSet resultContra = sql1.executeQuery();


                PreparedStatement sql2 = Conexion.getC().prepareStatement("select (persona).nombre from clientes where dni = ?");
                sql2.setString(1, usuario);
                ResultSet resultNombre = sql2.executeQuery();


                while (resultContra.next()) {
                    contrasenaResultado = resultContra.getString("contrasena");
                }

                while (resultNombre.next()) {
                    nombreResultado = resultNombre.getString("nombre");
                }


                if (contrasenaResultado.equals(contrasena)) {
                    System.out.println("Usuario validado");
                    return true;
                }


            } catch (SQLException j) {
                System.out.println(j.getMessage());
            }
        }
        return false;
    }


    public static boolean usuarioYaExiste(String dni, String correo){

        if (!Objects.equals(dni, "") && !Objects.equals(correo, "")) {
            try {

                String test="";

                PreparedStatement sql1 = Conexion.getC().prepareStatement("select fechaRegistro from clientes where dni = ?");
                sql1.setString(1, dni);
                ResultSet resultado = sql1.executeQuery();

                PreparedStatement sql3 = Conexion.getC().prepareStatement("select fechaRegistro from clientes where correo = ?");
                sql3.setString(1, correo);
                ResultSet resultado2 = sql1.executeQuery();

                while (resultado.next()&&resultado2.next()) {
                    test+=resultado.getString("fechaRegistro");
                    test+=resultado2.getString("fechaRegistro");
                }


                if (test.equals("")){
                    return true;
                }

                return false;

            } catch (SQLException j) {
                System.out.println(j.getMessage());

            }
        }
        return false;
    }

    public static boolean darAltaNuevoUsuario(String nombre, String contrasena, String correo, String DNI, String calle, int numero, String localidad){

        String cadenaNumero = String.valueOf(numero);


        if (!Objects.equals(nombre, "") && !Objects.equals(correo, "") && !Objects.equals(contrasena, "") && !Objects.equals(DNI, "") && !Objects.equals(calle, "") && !Objects.equals(localidad, "") && !Objects.equals(cadenaNumero, "")) {

            try {

                PreparedStatement sql1 = Conexion.getC().prepareStatement("INSERT INTO Clientes VALUES (?, (?, (?, ? , ?)), ?, ?, DEFAULT);");
                sql1.setString(1, DNI);
                sql1.setString(2, nombre);
                sql1.setString(3, calle);
                sql1.setString(4, cadenaNumero);
                sql1.setString(5, localidad);
                sql1.setString(6, correo);
                sql1.setString(7, contrasena);

                ResultSet resultado = sql1.executeQuery();

                return true;

            } catch (SQLException j) {
                System.out.println(j.getMessage());

            }
        }
        return false;
    }



    public static Usuario cargarInformacion(String usuario) {

        if (!Objects.equals(usuario, "")) {
            try {

                String nombre = "", DNI = "", correo = "", contrasena = "", direccion = "", fechaRegistro = "";
                ArrayList<Cuenta> listaCuentas;


                PreparedStatement sql1 = Conexion.getC().prepareStatement("select * from clientes where dni = ?");
                sql1.setString(1, usuario);
                ResultSet resultado = sql1.executeQuery();


                while (resultado.next()) {
                    DNI = resultado.getString("dni");
                    nombre = resultado.getString("(persona).nombre");
                    direccion = resultado.getString("(persona).(direccion).calle") + " nº " +
                            resultado.getString("(persona).(direccion).numero") + ", " +
                            resultado.getString("(persona).(direccion).localidad");
                    contrasena = resultado.getString("contrasena");
                    fechaRegistro = resultado.getString("fechaRegistro");
                    correo = resultado.getString("correo");
                }


                Usuario nuevoUsuario = new Usuario(nombre, DNI, correo, contrasena, direccion, fechaRegistro);


                return nuevoUsuario;

            } catch (SQLException j) {
                System.out.println(j.getMessage());

            }
        }
        return null;

    }

    private static ArrayList<Cuenta> cargarCuentas


}
