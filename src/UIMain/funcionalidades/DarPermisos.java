package UIMain.funcionalidades;
//Opción de menú 6
import BaseDatos.Data;
import UIMain.Main;
import UIMain.MenuDeConsola;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Usuarios.Cliente;
import gestorAplicacion.Usuarios.Veterinario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

public class DarPermisos extends OpcionDeMenu{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public void ejecutar() throws IOException {
        System.out.println();
        System.out.println("Para otorgar permisos a los Clientes introduzca el 1 " +
                "Para Otorgar permisos a los Veterinarios introduzca el 2 \n" +
                "Para regresar al menu de opciones introduzca cualquier otro número.");
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

    public void modificarCliente() throws IOException{
        System.out.println();
        System.out.println("******************* Menu Cliente *************************");
        Cliente cliente = new Cliente();
        Cliente.getMenu(cliente).verOpciones();
        System.out.println("**********************************************************");
        System.out.println();
        System.out.println("Introduzca la opción de Menú que desee agregar: ");
        System.out.println("" +
                "       1. Iniciar Sesion.\n" +
                "       2. Ver disponinilidad.\n" +
                "       3. Pedir Cita.\n" +
                "       4. Cambiar Fecha de una Cita.\n" +
                "       5. Cancelar cita.\n" +
                "       6. Consultar la nomina de los veterinarios.\n" +
                "       7. Contratar nuevo Veterinario.\n" +
                "       8. Listado de Mascotas.\n" +
                "       9. Registrar Mascota.\n" +
                "       10. Hospitalizar una mascota.\n" +
                "       11. Dar de alta a una mascota.\n" +
                "       12. Dar permisos.\n" +
                "       13. Registrarse.\n" +
                "       14. Cerrar Sesion.\n" +
                "       15. Salir de la aplicación.");
        System.out.println("Para regresar al menú introduzca el numero 20");
        Integer opcion = Integer.parseInt(br.readLine());

        if(opcion == 20){
            Main.setUsuarioActivo(Main.getUsuarioActivo());
        }
        else if(!Data.menuCliente.contains(opcion)){
            Data.menuCliente.add(opcion);
            System.out.println("Se ha agregado la opción correctamente.");
        }
        else{
            System.out.println("Los clientes ya contienen esta opción.");
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
        System.out.println("" +
                "       1. Iniciar Sesion.\n" +
                "       2. Ver disponinilidad.\n" +
                "       3. Pedir Cita.\n" +
                "       4. Cambiar Fecha de una Cita.\n" +
                "       5. Cancelar cita.\n" +
                "       6. Consultar la nomina de los veterinarios.\n" +
                "       7. Contratar nuevo Veterinario.\n" +
                "       8. Listado de Mascotas.\n" +
                "       9. Registrar Mascota.\n" +
                "       10. Hospitalizar una mascota.\n" +
                "       11. Dar de alta a una mascota.\n" +
                "       12. Dar permisos.\n" +
                "       13. Registrarse.\n" +
                "       14. Cerrar Sesion.\n" +
                "       15. Salir de la aplicación.");
        System.out.println("Para regresar al menú introduzca el numero 20");
        Integer opcion = Integer.parseInt(br.readLine());

        if(opcion == 20){
            Main.setUsuarioActivo(Main.getUsuarioActivo());
        }
        else if(!Data.menuVeterinario.contains(opcion)){
            Data.menuVeterinario.add(opcion);
            System.out.println("Se ha agregado la opción correctamente.");
        }
        else{
            System.out.println("Los veterinarios ya contienen esta opción.");
        }
        System.out.println("**********************************************************");
    }
    public String toString(){
        return "Dar permisos";
    }

}