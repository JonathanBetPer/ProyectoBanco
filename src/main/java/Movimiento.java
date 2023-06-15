/**
 * Clase Movimiento
 * Guarda la información de las transferencias entre las distintas cuentas.
 *
 * @since 06/06/2023
 * @author JonathanBetPer
 * @author carlosaldea3
 * @author AlejandroYgr
 * @version 1.0
 */
public class Movimiento {

    private int idCuentaOrigen;
    private int idCuentaDestino;
    private String fecha;
    private String descripcion;
    private double cantidad;

    public Movimiento(int idCuentaOrigen, int idCuentaDestino, String fecha, String descripcion, double cantidad) {
        this.idCuentaOrigen = idCuentaOrigen;
        this.idCuentaDestino = idCuentaDestino;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return fecha +": desde idCuentaOrigen=" + idCuentaOrigen +
                " a idCuentaDestino=" + idCuentaDestino +
                ", con un total de " + cantidad + "€"+
                ", descripcion: '" + descripcion;
    }

}
