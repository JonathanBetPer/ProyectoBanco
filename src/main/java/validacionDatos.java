import java.util.regex.Pattern;

public interface validacionDatos {

    static boolean verificarDNI(String dni) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";

        if (dni.length() != 9) {
            return false;
        }

        String numeroStr = dni.substring(0, 8);
        char letra = Character.toUpperCase(dni.charAt(8));

        try {
            int numero = Integer.parseInt(numeroStr);
        } catch (NumberFormatException e) {
            return false;
        }

        int resto = Integer.parseInt(numeroStr) % 23;
        char letraCalculada = letras.charAt(resto);

        if (letra != letraCalculada) {
            return false;
        }

        return true;
    }

    public static boolean verificarCorreo(String correo) {
        // Patrón de expresión regular para verificar el correo electrónico
        String patron = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        // Compilamos el patrón en un objeto Pattern
        Pattern pattern = java.util.regex.Pattern.compile(patron);

        // Verificamos si el correo coincide con el patrón
        return pattern.matcher(correo).matches();
    }

}
