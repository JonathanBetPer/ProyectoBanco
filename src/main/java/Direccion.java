public class Direccion {

    private String calle;
    private int num;
    private String localidad;

    public Direccion(){
        calle="";
        num=0;
        localidad="";
    }

    public Direccion(String calle, int num, String localidad) {
        this.calle = calle;
        this.num = num;
        this.localidad = localidad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String concatenar(){
        return calle + ", nº "+num+", "+localidad;
    }
}
