package BaseDeDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InfoCuenta {

    private int numero;

    private String dniCliente;
    private String tipo;
    private double saldo;
    private String fechaAlta;
    private Conexion c;

    public InfoCuenta(){
        c = Main.conexion;
    }

    public void informacionCuenta (String dniCliente){

        try {

            String numeroResultado = "";
            String dniClienteResultado = "";


            PreparedStatement sql1 = Conexion.getC().prepareStatement("select numero from cuentas where dnicliente = ?");
            sql1.setString(1, dniCliente);
            ResultSet resultNumero = sql1.executeQuery();


            PreparedStatement sql2 = Conexion.getC().prepareStatement("select dnicliente from cuentas where dni = ?");
            sql2.setString(1, dniCliente);
            ResultSet resultDni = sql2.executeQuery();


            while (resultNumero.next()) {
                numero = resultNumero.getInt("numero");
            }

            while (resultDni.next()) {
                dniCliente = resultDni.getString("dnicliente");
            }





        } catch (SQLException j) {
            System.out.println(j.getMessage());

        }
    }

    public int getNumero() {
        return numero;
    }

    public String getDniCliente() {
        return dniCliente;
    }
}
