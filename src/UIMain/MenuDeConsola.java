
package uiMain;

import java.util.ArrayList;
import java.util.Scanner;

import BaseDatos.Data;
import gestorAplicacion.Usuarios.Persona;

public class MenuDeConsola {
	
	private Persona user;
	private ArrayList<OpcionDeMenu> options = new ArrayList<OpcionDeMenu> ();
	
	public MenuDeConsola(ArrayList<OpcionDeMenu> options){
		this.options = options;
	}
	
	public MenuDeConsola(Persona user, ArrayList<OpcionDeMenu> options){
		this.user = user;
		this.options = options;
	}
	
	public Persona getUser() {
		return user;
	}

	public void setUser(Persona user) {
		this.user = user;
	}
	
	public ArrayList<OpcionDeMenu> getOptions() {
		return options;
	}

	public void setOptions(ArrayList<OpcionDeMenu> options) {
		this.options = options;
	}
	
	public String[] getOperations() {
		String [] opt = new String[options.size()];
		int i = 0;
		for (OpcionDeMenu opcionDeMenu : options) {
			opt[i] = opcionDeMenu.getKey();
			i++;
		}
		return opt;
	}

	public void lanzarMenu(){
		Scanner leer = new Scanner(System.in);
		
		System.out.println();
		int i = 1;
		for (OpcionDeMenu option : options) {
			
			System.out.println(i+" "+option);
			i++;
		}
		//Opcion para terminar el programa, hecho con un try catch.
		System.out.println(i+" Terminar programa");
		
		System.out.print("Ingrese la opcion: ");
		int opt = leer.nextInt();
		options.get((opt-1)).ejecutar();
		
	}
	
	public static void newMenu(Persona user, String [] operations) {
		ArrayList<OpcionDeMenu> operationsMenu = new ArrayList<OpcionDeMenu>();
		for (String opt : operations) {
			operationsMenu.add(Data.operations.get(opt));
		}
		MenuDeConsola menu = new MenuDeConsola(user, operationsMenu);
		user.setMenu(menu);
		Data.menus.put(user.getUsername(), menu);
	}
	
	public void seeOpt() {
		int i = 1;
		for (OpcionDeMenu opcionDeMenu : options) {
			System.out.println(i + " "+opcionDeMenu);
			i++;
		}
	}
	
	public void removeOpt(int index) {
		options.remove(index-1);
	}
	
	public void añadirOpcion(String opt) {
		options.add(Data.operations.get(opt));
	}
}