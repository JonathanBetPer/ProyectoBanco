import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Interfaz LogIn
 *
 * @since 06/06/2023
 * @author JonathanBetPer
 * @author carlosaldea3
 * @author AlejandroYgr
 * @version 1.0
 */
public class LogIn extends JFrame {
    private JPanel panel1;
    private JTextField nombreUsuario;
    private JPasswordField contrasenaUsuario;
    private JButton iniciarSesionButton;
    private JButton registrarseButton;
    private String usuarioDB;
    private String contrasenaDB;



    public void initComponents(){
        this.setContentPane(panel1);
        this.setAlwaysOnTop(true);
        this.setSize(new Dimension(200,300));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void cerrarVentana(){
        this.dispose();
    }


    public LogIn() {

        initComponents();

        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                usuarioDB = nombreUsuario.getText();
                contrasenaDB= String.valueOf(contrasenaUsuario.getPassword());


                if (tratamientoDatos.verificarLogIn(Main.conexion, usuarioDB, contrasenaDB)){
                    System.out.println("Ingresado satisfactoriamente");
                    Main.usuarioActual= tratamientoDatos.cargarInformacion(usuarioDB);
                    cerrarVentana();
                    new PantallaPrincipal().setVisible(true);
                }
            }
        });


        registrarseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent j) {
                cerrarVentana();
                new Registrarse().setVisible(true);

            }
        });
    }



}
