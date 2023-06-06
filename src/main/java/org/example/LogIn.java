package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Arrays;
import java.util.Objects;

public class LogIn extends JFrame {
    private JPanel panel1;
    private JTextField nombreUsuario;

    private JPasswordField contrasenaUsuario;
    private JButton iniciarSesionButton;
    private JButton registrarseButton;

    private String usuario = "postgres";
    private String password = "asdasd123";

    private String usuarioDB;
    private String contrasenaDB;

    private static Connection c;


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


    public void initConection() {

        try {

            c = DriverManager.getConnection("jdbc:postgresql://localhost:5433/Banco", usuario, password);
            System.out.println("ÉXITO");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public LogIn() {

        initComponents();
        initConection();

        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                usuarioDB = nombreUsuario.getText();

                contrasenaDB= String.valueOf(contrasenaUsuario.getPassword());

                try {

                    String contrasenaResultado = "";
                    String nombreResultado = "";

                    PreparedStatement sql1 = c.prepareStatement("select contrasena from clientes where dni = ?");
                    sql1.setString(1, usuarioDB);
                    ResultSet resultContra = sql1.executeQuery();



                    PreparedStatement sql2 = c.prepareStatement("select nombre from clientes where dni = ?");
                    sql2.setString(1, usuarioDB);
                    ResultSet resultNombre = sql2.executeQuery();


                    while (resultContra.next()){
                        contrasenaResultado = resultContra.getString("contrasena");
                    }

                    while (resultNombre.next()){
                        nombreResultado = resultNombre.getString("nombre");
                    }


                    if (!Objects.equals(contrasenaDB, "")){


                        if (contrasenaResultado.equals(contrasenaDB)){

                            System.out.println("Ingresado satisfactoriamente");
                            new Cuenta(nombreResultado).setVisible(true);
                            cerrarVentana();


                        }

                    }

                } catch (SQLException j) {
                    System.out.println(j.getMessage());

                }


            }
        });
    }

        public static void main(String[] args) {

            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new LogIn().setVisible(true);
                }
            });

        }

}
