package UIMain.funcionalidades;
import BaseDatos.Data;
import BaseDatos.in;
import UIMain.Main;
import UIMain.MenuDeConsola;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Usuarios.Cliente;
import gestorAplicacion.Usuarios.Veterinario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class DarPermisos extends OpcionDeMenu{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public void ejecutar() throws Throwable {
        System.out.println();
        System.out.println("**********************************************************");
        System.out.println("" +
                "*Para otorgar permisos a los Clientes introduzca el 1               *\n" +
                "*Para Otorgar permisos a los Veterinarios introduzca el 2           *\n" +
                "*Para regresar al menu de opciones introduzca cualquier otro número.*");

        int opcion =in.nextInt();
        if(opcion == 1){
            modificarCliente();
        }
        else if(opcion == 2){
            modificarVeterinario();
        }
        else
        {
            Main.getMenu().lanzarMenu();
        }

    }

    public void modificarCliente() throws IOException{
        System.out.println();
        System.out.println("******************* Menu Cliente *************************");
        Cliente cliente = new Cliente();
        Cliente.getMenu(cliente).verOpciones();
        System.out.println("**********************************************************");
        System.out.println();
        System.out.println("Introduzca la opción de Menú que desee agregar: ");
        MenuDeConsola.verOpcionesCompletas();

        Integer opcion = in.nextInt();
        if(!Data.menuCliente.contains(opcion)){
            Data.menuCliente.add(opcion);
            System.out.println("Se ha agregado la opción "+ MenuDeConsola.listaOpciones.get(opcion) +" correctamente.");
        }
        else{
            System.out.println("Los clientes ya contienen la opción: "+ MenuDeConsola.listaOpciones.get(opcion));
        }
        System.out.println("**********************************************************");
    }

    public void modificarVeterinario() throws IOException{
        System.out.println();
        System.out.println("******************* Menu Veterinario *************************");
        Veterinario veterinario = new Veterinario();
        Veterinario.getMenu(veterinario).verOpciones();
        System.out.println("**********************************************************");
        System.out.println();
        System.out.println("Introduzca la opción de Menú que desee agregar: ");
        MenuDeConsola.verOpcionesCompletas();
        Integer opcion = in.nextInt();

        System.out.println(MenuDeConsola.listaOpciones.get(opcion));
        if(opcion == 20){
            Main.setUsuarioActivo(Main.getUsuarioActivo());
        }
        else if(!Data.menuVeterinario.contains(opcion)){
            Data.menuVeterinario.add(opcion);
            System.out.println("Se ha agregado la opción "+ MenuDeConsola.listaOpciones.get(opcion)+" correctamente.");
        }
        else{
            System.out.println("Los veterinarios ya contienen la opción: "+ MenuDeConsola.listaOpciones.get(opcion));
        }
        System.out.println("**********************************************************");
    }
    public String toString(){
        return "Dar permisos.";
    }

}