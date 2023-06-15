import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registrarse extends JFrame{

    private JPanel panel1;
    private JTextField nombreField;
    private JTextField dniField;
    private JTextField correoField;
    private JTextField contrasenaField;
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

                if (nombreField.getText()==null || dniField.getText()==null || correoField.getText()==null || contrasenaField.getText()==null || calleField.getText()==null || numeroField.getText()==null || localidadField.getText()==null) {

                    System.out.println("Algunos de los campos está vacio");


                }
                else {
                    System.out.println("cacaccaca");

                    if (tratamientoDatos.usuarioYaExiste(dniField.getText(), correoField.getText())) {

                        System.out.println("El usuario ya existe");

                    } else {
                        tratamientoDatos.darAltaNuevoUsuario(nombreField.getText(), contrasenaField.getText(), correoField.getText(), dniField.getText(), calleField.getText(), Integer.parseInt(numeroField.getText()), localidadField.getText());
                        System.out.println("Usuario creado!");
                    }

                }
            }
        });
}
}
