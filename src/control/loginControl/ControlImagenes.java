package control.loginControl;
import java.awt.event.*;

import UIMain.Main;

public class ControlImagenes implements ActionListener {
		int contador = 0;
		public void actionPerformed(ActionEvent evento) {
			contador++;
			if(contador==1) {
				Main.ventanaLogin.cambiarImagen("foto1.jpeg");
			}
			else if(contador==2) {
				Main.ventanaLogin.cambiarImagen("foto2.jpeg");
			}
			else if(contador==3) {
				contador = 0;
				Main.ventanaLogin.cambiarImagen("CLICIMAGEN.PNG");
			}
		}
} 


