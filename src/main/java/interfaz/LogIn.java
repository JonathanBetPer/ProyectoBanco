package interfaz;


import BaseDeDatos.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

public class LogIn extends JFrame {
    private JPanel panel1;
    private JTextField nombreUsuario;

    private JPasswordField contrasenaUsuario;
    private JButton iniciarSesionButton;
    private JButton registrarseButton;

    private String usuarioDB;
    private String contrasenaDB;

    private tratamientodedatos comprobar;
    private Cuenta cuenta;



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

                comprobar = new tratamientodedatos();

                usuarioDB = nombreUsuario.getText();

                contrasenaDB= String.valueOf(contrasenaUsuario.getPassword());

                if (comprobar.comprobarContrasena(usuarioDB, contrasenaDB)){

                    System.out.println("Ingresado satisfactoriamente");
                    new Cuenta(tratamientodedatos.getNombre()).setVisible(true);
                    cerrarVentana();

                }

            }
        });


    }



}
