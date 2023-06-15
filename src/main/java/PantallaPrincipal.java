import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PantallaPrincipal extends JFrame{
    private JButton verCuentasButton;
    private JButton nuevaCuentaButton;
    private JLabel labelDer;
    private JPanel panel1;
    private JLabel numeroCuenta;
    private JPanel panel2;
    private JPanel panel3;

    private int numero;

    private String dniCliente;
    private String tipo;
    private double saldo;
    private String fechaAlta;
    private Conexion c;
    private Cuenta infoCuenta;





    public PantallaPrincipal(String nombre){
        initComponents();
        c = Main.conexion;


        labelDer.setText(nombre);

        verCuentasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numeroCuenta.setText(String.valueOf(infoCuenta.getNumero()));
            }
        });
    }

    public void initComponents(){
        this.setContentPane(panel1);
        this.setAlwaysOnTop(true);
        this.setSize(new Dimension(200,300));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
