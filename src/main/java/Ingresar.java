import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *  Interfaz: Ingresar
 *
 * @since 06/06/2023
 * @author JonathanBetPer
 * @author carlosaldea3
 * @author AlejandroYgr
 * @version 1.0
 */
public class Ingresar extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JButton continuarButton;

    private int numeroCuentaIngreso;



    public Ingresar(int numeroCuentaIngreso) {
        super("UwU");
        initComponents();


        continuarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Double.parseDouble(textField1.getText())>=0){
                    Main.usuarioActual.getListaCuentas().get(numeroCuentaIngreso).ingresar(Double.parseDouble(textField1.getText()));
                    tratamientoDatos.actualizarCuenta(Main.usuarioActual.getListaCuentas().get(numeroCuentaIngreso).getId(),Double.parseDouble(textField1.getText()));
                }else{
                    JOptionPane.showMessageDialog(null, "Cantidad incorrecta", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }

                cerrarVentana();
                new PantallaPrincipal().setVisible(true);

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

    public void cerrarVentana(){
        this.dispose();
    }


}
