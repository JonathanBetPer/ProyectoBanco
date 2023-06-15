import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private String DNI;
    private String correo;
    private String contrasena;
    private String direccion;
    private String fechaRegistro;
    private ArrayList<Cuenta> listaCuentas;

    public Usuario(String nombre, String DNI, String correo, String contrasena, String direccion, String fechaRegistro) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.correo = correo;
        this.contrasena = contrasena;
        this.direccion = direccion;
        this.fechaRegistro = fechaRegistro;
        this.listaCuentas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public ArrayList<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(ArrayList<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }

    public void agregarCuenta(Cuenta nuevaCuenta) {
        this.listaCuentas.add(nuevaCuenta);
    }

    public void eliminarCuenta(Cuenta nuevaCuenta) {

    }


}
