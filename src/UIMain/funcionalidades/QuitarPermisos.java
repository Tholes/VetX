package UIMain.funcionalidades;
import BaseDatos.Data;
import UIMain.Main;
import UIMain.MenuDeConsola;
import UIMain.OpcionDeMenu;

import java.io.BufferedReader;
import java.io.InputStreamReader;


import gestorAplicacion.Usuarios.Cliente;

import gestorAplicacion.Usuarios.Veterinario;

import java.io.IOException;

public class QuitarPermisos extends OpcionDeMenu {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    @Override
    public void ejecutar() throws IOException {
        System.out.println();
        System.out.println("**********************************************************");
        System.out.println("" +
                "*Para quitar permisos a los Clientes introduzca el 1.               *\n" +
                "*Para quitar permisos a los Veterinarios introduzca el 2.           *\n" +
                "*Para regresar al menu de opciones introduzca cualquier otro número.*");

        int opcion = Integer.parseInt(br.readLine());
        if(opcion == 1){
            modificarCliente();
        }
        else if(opcion == 2){
            modificarVeterinario();
        }
        else
        {
            Main.setUsuarioActivo(Main.getUsuarioActivo());
        }
    }

    public void modificarVeterinario() throws IOException{
        System.out.println();
        System.out.println("******************* Menu Veterinario *************************");
        Veterinario veterinario = new Veterinario();
        Veterinario.getMenu(veterinario).verOpciones();
        System.out.println("**********************************************************");
        System.out.println();
        System.out.println("Introduzca la opción de Menú que desee eliminar: ");
        MenuDeConsola.verOpcionesCompletas();
        System.out.println("Para regresar al menú introduzca el numero 20");
        Integer opcion = Integer.parseInt(br.readLine());

        if(opcion == 20){
            Main.setUsuarioActivo(Main.getUsuarioActivo());
        }
        else if(Data.menuVeterinario.contains(opcion)){
            Data.menuVeterinario.remove(opcion);
            System.out.println("Se ha eliminado la opción "+MenuDeConsola.listaOpciones.get(opcion) +" correctamente.");
        }
        else{
            System.out.println("Los veerinarios no contienen al opción: " + MenuDeConsola.listaOpciones.get(opcion));
        }
        System.out.println("**********************************************************");
    }

    public void modificarCliente() throws  IOException{
        System.out.println();
        System.out.println("******************* Menu Cliente *************************");
        Cliente cliente = new Cliente();
        Cliente.getMenu(cliente).verOpciones();
        System.out.println("**********************************************************");
        System.out.println();
        System.out.println("Introduzca la opción de Menú que desee eliminar: ");
        MenuDeConsola.verOpcionesCompletas();
        System.out.println("Para regresar al menú introduzca el numero 20");
        Integer opcion = Integer.parseInt(br.readLine());

        if(opcion == 20){
            Main.setUsuarioActivo(Main.getUsuarioActivo());
        }
        else if(Data.menuCliente.contains(opcion)){
            Data.menuCliente.remove(opcion);
            System.out.println("Se ha eliminado la opción "+ MenuDeConsola.listaOpciones.get(opcion)+" correctamente.");
        }
        else{
            System.out.println("Los clientes no contienen al opción: " + MenuDeConsola.listaOpciones.get(opcion));
        }
        System.out.println("**********************************************************");
    }
    @Override
    public String toString() {
        return "Quitar permisos a otros usuarios.";
    }
}




