import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
/**
 * Clase Tratamiento De Datos
 * Realiza las operaciones CRUD a la BBDD
 *
 * @since 06/06/2023
 * @author JonathanBetPer
 * @author carlosaldea3
 * @author AlejandroYgr
 * @version 1.0
 */

public abstract class tratamientoDatos {

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

                PreparedStatement sql1 = Conexion.getC().prepareStatement("INSERT INTO Clientes VALUES (?, (?, (?, ?, ?)), ?, ?, DEFAULT);");
                sql1.setString(1, DNI);
                sql1.setString(2, nombre);
                sql1.setString(3, calle);
                sql1.setInt(4, numero);
                sql1.setString(5, localidad);
                sql1.setString(6, correo);
                sql1.setString(7, contrasena);
                ResultSet resultado = sql1.executeQuery();


                nuevaCuenta(DNI);

                return true;

            } catch (SQLException j) {
                System.out.println(j.getMessage());

            }
        }
        return false;
    }



    public static  Usuario cargarInformacion(String dniUsuario) {

        if (!Objects.equals(dniUsuario, "")) {
            try {

                String nombre="",  DNI = "", correo = "", contrasena = "", fechaRegistro = "", direccion="";

                PreparedStatement sql1 = Conexion.getC().prepareStatement("select dni, (persona).nombre, (persona).direccion.calle, (persona).direccion.numero, (persona).direccion.localidad, contrasena, correo, fecharegistro  from clientes where dni = ?;");
                sql1.setString(1, dniUsuario);
                ResultSet resultado = sql1.executeQuery();


                while (resultado.next()) {
                    DNI = resultado.getString("dni");
                    nombre = resultado.getString("nombre");
                    direccion = resultado.getString("calle") + " nº " +
                            resultado.getString("numero") + ", " +
                            resultado.getString("localidad");
                    contrasena = resultado.getString("contrasena");
                    fechaRegistro = resultado.getString("fechaRegistro");
                    correo = resultado.getString("correo");
                }

                //Carga el usuario
                Usuario nuevoUsuario = new Usuario(nombre, DNI, correo, contrasena, direccion, fechaRegistro);



                //Le añade sus cuentas
                nuevoUsuario.setListaCuentas(cargarCuentas(nuevoUsuario));

                //le añade los movimientos a cada una de sus cuentas
                nuevoUsuario.setListaCuentas(cargarMovimientos(nuevoUsuario.getListaCuentas()));

                return nuevoUsuario;

            } catch (SQLException j) {
                System.out.println(j.getMessage());

            }
        }
        return null;

    }

    private static ArrayList<Cuenta> cargarCuentas(Usuario usuario){

        System.out.println(usuario.getDNI());
        ArrayList<Cuenta> listaDeCuentas = new ArrayList<>();
        int id;
        double saldo;
        String fechaAlta;

        try {

            PreparedStatement sql1 = Conexion.getC().prepareStatement("select * from cuentas where dnicliente = ?");
            sql1.setString(1, usuario.getDNI());
            ResultSet resultado = sql1.executeQuery();


            while (resultado.next()) {
                id = Integer.parseInt(resultado.getString("id"));
                saldo = Double.parseDouble(resultado.getString("saldo"));
                fechaAlta = resultado.getString("fechealta");

                Cuenta nuevaCuenta = new Cuenta(id, saldo, fechaAlta);

                listaDeCuentas.add(nuevaCuenta);
            }


            return listaDeCuentas;

        } catch (SQLException j) {
            System.out.println(j.getMessage());
        }

        return listaDeCuentas;

    }


    private static ArrayList<Cuenta> cargarMovimientos(ArrayList<Cuenta> listaCuentas){

        ArrayList<Movimiento> listaMovimientos = new ArrayList<>();
        int idOrigen, idDestino;
        double cantidad;
        String fecha, descripcion;

        try {

            for (Cuenta e:listaCuentas) {

                PreparedStatement sql1 = Conexion.getC().prepareStatement("select * from movimientos where cuentaorigen = ?");
                sql1.setInt(1, e.getId());
                ResultSet resultado = sql1.executeQuery();
                while (resultado.next()) {
                    idOrigen = resultado.getInt("cuentaorigen");
                    idDestino = resultado.getInt("cuentadestino");
                    fecha = resultado.getString("fecha");
                    descripcion = resultado.getString("descripcion");
                    cantidad = resultado.getDouble("cantidad");


                    Movimiento nuevoMovimiento = new Movimiento(idOrigen, idDestino, fecha, descripcion, cantidad);

                    e.agregarMovimiento(nuevoMovimiento);
                }
            }

            return listaCuentas;

        } catch (SQLException j) {
            System.out.println(j.getMessage());
        }

        return listaCuentas;

    }

    public static boolean actualizarCuenta(int idCuenta, double cantidad){
        try {

            PreparedStatement sql1 = Conexion.getC().prepareStatement("UPDATE CUENTAS SET saldo = saldo+? WHERE id = ?");
            sql1.setDouble(1, cantidad);
            sql1.setInt(2,idCuenta);
            ResultSet resultado = sql1.executeQuery();

            return true;

        } catch (SQLException j) {
            System.out.println(j.getMessage());
        }

        return false;

    }

    public static boolean nuevaCuenta(String DNI){
        try {
            PreparedStatement sql2 = Conexion.getC().prepareStatement("INSERT INTO Cuentas VALUES (DEFAULT, ?, 15.95, DEFAULT);");
            sql2.setString(1, DNI);
            ResultSet resultado2 = sql2.executeQuery();
            return true;

        } catch (SQLException j) {
            System.out.println(j.getMessage());
        }

        return false;

    }





}
