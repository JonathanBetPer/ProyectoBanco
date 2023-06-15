public class Movimiento {

    private int idCuentaOrigen;
    private int idCuentaDestino;
    private int fecha;
    private String descripcion;
    private double cantidad;

    public Movimiento(int idCuentaOrigen, int idCuentaDestino, int fecha, String descripcion, double cantidad) {
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
