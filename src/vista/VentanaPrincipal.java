
package Vista;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import UIMain.Main;
import Control.Imagen;
import Control.Bienvenidad;

public class VentanaPrincipal  extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel P1;
	private JPanel P2;
	private JPanel P3;
	private JPanel P4;
	private JPanel P5;
	private JPanel P6;
	private JPanel P7; 
	private JPanel P8; 
	
	private JLabel L1;
	private JLabel L2;
	private JLabel L3;
	private JLabel L4;
	
	private JButton B1;
	private JButton B2;
	private JButton B3;
	private JButton B4;

	private JTextArea Tinicial;
	private JScrollPane T1;
	private JTextField T2;
	private JTextField T3;

	private ImageIcon imagen;
	private Icon icono;
	
	public VentanaPrincipal() {
		super("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel Frame = new JPanel();
		Frame.setLayout(new BorderLayout(20,20));
		
		//creación de los paneles principales
		P1 = new JPanel();
		P2 = new JPanel();
		P3 = new JPanel();
		P4 = new JPanel();
		P5 = new JPanel();
		P6 = new JPanel();
		P7 = new JPanel(new BorderLayout(10,10));
		P8 = new JPanel(new GridLayout(2,2,10,10));
		
		//creacion de  Labels Principales
		L1 = new JLabel("Bienvenido a su veterinaria VETX");
		L2 = new JLabel("Ingrese su código de usuario y su clave:");
		L3 = new JLabel("Código de usuario");
		L4 = new JLabel("Clave");
		
		//Creacion de los botones Principales

		B2 = new JButton("Administrador");	
		B3 = new JButton("Usuario común");
		B4 = new JButton("Salir");

		//Imagen del Boton 1
		B1 = new JButton();	
		B1.setBounds(0, 0, 200, 200);
		imagen = new ImageIcon("CLICIMAGEN.PNG");
		icono = new ImageIcon(imagen.getImage().getScaledInstance(B1.getWidth(), B1.getHeight(), Image.SCALE_DEFAULT));
		B1.setIcon(icono);
		
	
		
		//Textos Principales
		JTextArea Tinicial = new JTextArea("VETX es el modelo de una clínica veterinaria, donde puedes llevar a tu mascota y contar con los servicios de medicina general y los mejores veterinarios",10,20);
		Tinicial.setLineWrap(true);
		Tinicial.setEditable(false);
		JScrollPane T1 = new JScrollPane(Tinicial);
		T2 = new JTextField(8);
		T3 = new JTextField(8);
		
		//Action listeners
		B1.addActionListener(new Imagen());
		L1.addMouseListener(new Bienvenidad());

				
		
		//Hagamos el panel izquierdo (P1)
		
		P1.setLayout(new BorderLayout(10,10));
		
		P3.add(L1);
		P4.add(B1);
		
		P1.add(P3,BorderLayout.NORTH);
		P1.add(P4,BorderLayout.CENTER);
		
		
		P2.setLayout(new BorderLayout(10,10));
		
		P5.add(T1, BorderLayout.NORTH);
		P6.setLayout(new BorderLayout(10,10));
		
	
		P7.add(B2,BorderLayout.WEST);
		P7.add(B3,BorderLayout.EAST);
	
		
		JPanel P9 = new JPanel(new BorderLayout(10,10));
		P9.add(P8,BorderLayout.CENTER);
		P9.add(B4,BorderLayout.SOUTH);
		
		P2.add(P5, BorderLayout.NORTH);
		P2.add(P7, BorderLayout.CENTER);
		P2.add(P9, BorderLayout.SOUTH);
		

		
		Frame.add(P1, BorderLayout.WEST);
		Frame.add(P2, BorderLayout.EAST);
		

		Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		Frame.setBorder(padding);
		getContentPane().add(Frame);	
		setVisible(true);
		pack();
		setLocationRelativeTo(null);

	}

	public long getCedula() {
		try {
			
			if(T2.getText().equals("")) {
				return -1;
			}
			
			return Long.parseLong(T2.getText());
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public String getContrasena() {
		return T3.getText();
	}
	
	public int salir() {
		return JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea salir?", "Esta proximo a salir del programa", JOptionPane.YES_NO_OPTION);
	}
	public void borrar(String alert) {
		JOptionPane.showMessageDialog(null, alert, "Error al iniciar sesión" , JOptionPane.WARNING_MESSAGE);
		T3.setText(null);
		T2.setText(null);
	}
	
	public void cambiarImagen(String nombreImagen) {
		B1.setBounds(0, 0, 200, 200);
		imagen = new ImageIcon(nombreImagen);
		icono = new ImageIcon(imagen.getImage().getScaledInstance(B1.getWidth(), B1.getHeight(), Image.SCALE_DEFAULT));
		B1.setIcon(icono);
		pack();
	}
	public void ingresarAdministrador() {
		P7.add(L2, BorderLayout.SOUTH);
		P8.add(L3);
		P8.add(T2);
		P8.add(L4);
		P8.add(T3);
		
		B3.setText("Usuario Común");
		B3.setActionCommand("Usuario Común");
		B2.setText("Administrador Completo y Nuevamente Clic");
		B2.setActionCommand("AdministradorLogin");
		pack();
	}
	public void ingresarUsario() {
		P7.add(L2, BorderLayout.SOUTH);
		P8.add(L3);
		P8.add(T2);
		P8.add(L4);
		P8.add(T3);
		
		B3.setText("Usuario Comun Complete y Nuevamente Clic");
		B3.setActionCommand("Usuario ComunLogin");
		B2.setText("Administrador");
		B2.setActionCommand("Administrador");
		pack();
	}
	public JLabel getL1() {
		return L1;
	}

}
