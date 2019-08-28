package vista;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;


public class VentanaUsuario extends JFrame{
    public String nombres="Names";
    public String descrip="proceso";
    public String explic="descripcion consulta";
    public static Container contenedor;
    public static JPanel p1= new JPanel();
    public static JPanel p2= new JPanel();
    public static JPanel p3= new JPanel();

    public VentanaUsuario() {
        super("Usuario: ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());
        p1.setLayout(new BorderLayout());
        p2.setLayout(new GridLayout(6,2));
        //creacion del Titulo para el Usuario: var n cambiarla por nombre generico para cada usuario
        JLabel labelTitulo = new JLabel();
        labelTitulo.setFont(new java.awt.Font("Tahoma", 0, 11));
        labelTitulo.setHorizontalAlignment(SwingConstants.LEFT);
        labelTitulo.setText("Usuario: " + nombres);
        labelTitulo.setBounds(100, 100, 5000, 400);
        contenedor.add(labelTitulo, BorderLayout.NORTH);
        JMenuBar barraMenu = new JMenuBar();

        JMenu menu1 = new JMenu("Archivo");
        barraMenu.add(menu1);               //desplegable Archivo
        JMenuItem usuario = new JMenuItem("Usuario");
        menu1.add(usuario);
        JMenuItem salir = new JMenuItem("Salir");
        menu1.add(salir);
        JMenu procesoConsultas = new JMenu("Proceso y Consultas");
        barraMenu.add(procesoConsultas);    //desplegable Porceso y Consultas
        JMenu ayuda = new JMenu("Ayuda");
        barraMenu.add(ayuda);               //desplegable Ayuda
        JMenuItem acerca = new JMenuItem("Acerca de");
        ayuda.add(acerca);

        JLabel descripcion = new JLabel();
        descripcion.setFont(new java.awt.Font("Tahoma", 0, 13));
        descripcion.setHorizontalAlignment(SwingConstants.CENTER);
        descripcion.setText(descrip);
        descripcion.setBorder(javax.swing.BorderFactory.createBevelBorder(BevelBorder.RAISED));
        descripcion.setBounds(480, 120, 200, 25);

        JTextArea textoDescribe = new JTextArea();
        textoDescribe.setText(explic);
        textoDescribe.setBounds(290, 150, 550, 100);

        p1.add(barraMenu,BorderLayout.NORTH);
        p1.add(descripcion,BorderLayout.CENTER);
        p1.add(textoDescribe,BorderLayout.SOUTH);

        JLabel A = new JLabel("(a)");
        A.setBorder(javax.swing.BorderFactory.createBevelBorder(BevelBorder.RAISED));
        JLabel B = new JLabel("(b)");
        B.setBorder(javax.swing.BorderFactory.createBevelBorder(BevelBorder.RAISED));
        JLabel C = new JLabel("(b)");
        C.setBorder(javax.swing.BorderFactory.createBevelBorder(BevelBorder.RAISED));
        JLabel D = new JLabel("(b)");
        D.setBorder(javax.swing.BorderFactory.createBevelBorder(BevelBorder.RAISED));
        p2.add(new JLabel("Criterio"));
        p2.add(new JLabel("Valor"));
        p2.add(new JLabel("Codigo"));
        p2.add(A);
        p2.add(new JLabel("Nombre"));
        p2.add(B);
        p2.add(new JLabel("Descripcion"));
        p2.add(C);
        p2.add(new JLabel("Ubicacion"));
        p2.add(D);
        p2.add(new JButton("Aceptar"));
        p2.add(new JButton("Borrar"));


        contenedor.add(p1,BorderLayout.CENTER);
        contenedor.add(p2,BorderLayout.SOUTH);

    }

    public void arranca() {
        pack();// coloca los componentes
        setLocationRelativeTo(null);// centra la ventana en la pantalla
        setVisible(true);// visualiza la ventana
    }
}