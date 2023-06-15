import java.util.ArrayList;

public class Cuenta {

    private int id;
    private double saldo;
    private String fechaAlta;
    private ArrayList<Movimiento > historialMovimiento;


    public Cuenta(int id, double saldo, String fechaAlta) {
        this.id = id;
        this.saldo = saldo;
        this.fechaAlta = fechaAlta;
        this.historialMovimiento = new ArrayList<Movimiento>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public ArrayList<Movimiento> getHistorialMovimiento() {
        return historialMovimiento;
    }

    public void agregarMovimiento(Movimiento nuevoMovimiento) {
        this.historialMovimiento.add(nuevoMovimiento);
    }

    public boolean ingresar(double cantidad){
        if(cantidad>0){
            saldo+=cantidad;
            return true;
        }
        System.out.println("No se puede ingresar cantidades negativas");
        return false;

    }

    public boolean retirar(double cantidad){

        if(cantidad<=0){
            System.out.println("No se puede retirar cantidades negativas");
            return false;
        }else if (cantidad>saldo){
            System.out.println("Saldo insuficiente");
            return false;
        }else {
            saldo-=cantidad;
            return true;
        }

    }

   // public boolean transferencia(int idCuentaDestino, String descripcion, int cantidad){}

}
