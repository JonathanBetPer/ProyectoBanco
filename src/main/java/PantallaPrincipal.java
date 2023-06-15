import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Interfaz PantallaPrincipal
 *
 * @since 06/06/2023
 * @author JonathanBetPer
 * @author carlosaldea3
 * @author AlejandroYgr
 * @version 1.0
 */

public class PantallaPrincipal extends JFrame{
    private JLabel labelDer;
    private JPanel panel1;
    private JButton button1;
    private JButton button2;
    private JButton nuevaCuentaButton;
    private JButton ingresarButton;
    private JButton retirarButton;
    private JLabel labelSaldo;
    private JLabel labelFecha;
    private JLabel labelID;


    private Conexion c;
    private int numeroCuenta;


    public PantallaPrincipal(){
        initComponents();
        numeroCuenta=0;
        c = Main.conexion;
        cambiarCuenta();


        labelDer.setText(Main.usuarioActual.getNombre());

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(numeroCuenta>=0&&(numeroCuenta+1)<Main.usuarioActual.getListaCuentas().size()){
                    numeroCuenta++;
                    cambiarCuenta();
                }
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if((numeroCuenta-1)>=0&&numeroCuenta<Main.usuarioActual.getListaCuentas().size()){
                    numeroCuenta--;
                    cambiarCuenta();
                }
            }
        });
        nuevaCuentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tratamientoDatos.nuevaCuenta(Main.usuarioActual.getDNI());
                Main.usuarioActual = tratamientoDatos.cargarInformacion(Main.usuarioActual.getDNI());
            }
        });
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarVentana();
                new Ingresar(numeroCuenta).setVisible(true);
            }
        });
    }


    public void cambiarCuenta(){
        labelID.setText(String.valueOf(Main.usuarioActual.getListaCuentas().get(numeroCuenta).getId()));
        labelSaldo.setText(String.valueOf(Main.usuarioActual.getListaCuentas().get(numeroCuenta).getSaldo()));
        labelFecha.setText(String.valueOf(Main.usuarioActual.getListaCuentas().get(numeroCuenta).getFechaAlta()));

    }

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
}
