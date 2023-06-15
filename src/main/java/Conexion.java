import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Clase Conexión
 * Se coonecta a la BBDD
 *
 * @since 06/06/2023
 * @author JonathanBetPer
 * @author carlosaldea3
 * @author AlejandroYgr
 * @version 1.0
 */
public class Conexion  {

    private static Connection c;
    private String usuario;
    private String password;
    private String url;



    public Conexion(String dominio, int puerto, String db, String usuario, String contrasena) {
        this.url = "jdbc:postgresql://" + dominio + ":" + puerto + "/" + db;
        this.password = contrasena;
        this.usuario = usuario;
    }


    public static Connection getC() {
        return c;
    }

    public Connection iniciar() {

        try {
            c = DriverManager.getConnection(url, usuario, password);
            System.out.println("ÉXITO");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;
    }


    public void close(){

        try {
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
