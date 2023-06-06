package org.example;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Cuenta extends JFrame{
    private JButton verCuentasButton;
    private JButton nuevaCuentaButton;
    private JLabel labelDer;
    private JPanel panel1;

    private static Connection c;

    private String usuario = "postgres";

    private String password = "asdasd123";


    public void initConection() {

        try {

            c = DriverManager.getConnection("jdbc:postgresql://localhost:5433/Banco", usuario, password);
            System.out.println("ÉXITO");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void initComponents(){
        this.setContentPane(panel1);
        this.setAlwaysOnTop(true);
        this.setSize(new Dimension(200,300));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public Cuenta(String nombre){

        labelDer.setText(nombre);
        initComponents();
        initConection();

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
