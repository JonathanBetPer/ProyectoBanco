import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registrarse extends JFrame{

    private JFrame panel1;
    private JTextField nombreField;
    private JTextField dniField;
    private JTextField correoField;
    private JPasswordField contrasenaField;
    private JButton registrarseButton;
    private JTextField calleField;
    private JTextField numeroField;
    private JTextField localidadField;


    public void initComponents(){
        this.setContentPane(panel1);
        this.setAlwaysOnTop(true);
        this.setSize(new Dimension(200,300));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public Registrarse() {

    initComponents();



    registrarseButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {


            if (nombreField!=null){



            } else if (dniField==null) {

            } else if (correoField==null) {

            } else if (contrasenaField==null) {

            } else {






                new PantallaPrincipal(dniField.getText()).setVisible(true);


            }


        }
    });
}
}
