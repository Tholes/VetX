
package UIMain;

import java.util.ArrayList;
import java.util.Scanner;

import BaseDatos.Data;
import gestorAplicacion.Usuarios.Persona;

public class MenuDeConsola {
	
	private Persona usuario;
	private ArrayList<OpcionDeMenu> opciones = new ArrayList<OpcionDeMenu> ();
	
	public MenuDeConsola(ArrayList<OpcionDeMenu> opciones){
		this.opciones = opciones;
	}
	
	public MenuDeConsola(Persona usuario, ArrayList<OpcionDeMenu> opciones){
		this.usuario = usuario;
		this.opciones = opciones;
	}
	
	public Persona getUser() {
		return usuario;
	}

	public void setUser(Persona usuario) {
		this.usuario = usuario;
	}
	
	public ArrayList<OpcionDeMenu> getOptions() {
		return opciones;
	}

	public void setOptions(ArrayList<OpcionDeMenu> opciones) {
		this.opciones = opciones;
                
	}
	
	public String[] getOperations() {
		String [] opt = new String[opciones.size()];
		int i = 0;
		for (OpcionDeMenu opcionDeMenu : opciones) {
			opt[i] = opcionDeMenu.getKey();
			i++;
		}
		return opt;
	}

	public void lanzarMenu(){
		Scanner leer = new Scanner(System.in);
		
		System.out.println();
		int i = 1;
		for (OpcionDeMenu option : opciones) {
			
			System.out.println(i+" "+option);
			i++;
		}
		//Opcion para terminar el programa, hecho con un try catch.
		System.out.println(i+" Terminar programa");
		
		System.out.print("Ingrese la opcion: ");
		int opt = leer.nextInt();
		opciones.get((opt-1)).ejecutar();
		
	}
	
	public static void newMenu(Persona usuario, String [] funcionalidades) {
		ArrayList<OpcionDeMenu> funcionalidadMenu = new ArrayList<OpcionDeMenu>();
		for (String opt : funcionalidades) {
			funcionalidadMenu.add(Data.funcionalidades.get(opt));
		}
		MenuDeConsola menu = new MenuDeConsola(usuario, funcionalidadMenu);
		usuario.setMenu(menu);
		Data.menus.put(usuario.getUsername(), menu);
	}
	
	public void seeOpt() {
		int i = 1;
		for (OpcionDeMenu opcionDeMenu : opciones) {
			System.out.println(i + " "+opcionDeMenu);
			i++;
		}
	}
	
	public void removeOpt(int index) {
		opciones.remove(index-1);
	}
	
	public void agregarOpcion(String opt) {
		opciones.add(Data.funcionalidades.get(opt));
	}
}