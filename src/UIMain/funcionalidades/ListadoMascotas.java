package UIMain.funcionalidades;

import modelo.BaseDatos.in;
import UIMain.Main;
import UIMain.OpcionDeMenu;
import modelo.gestorAplicacion.Usuarios.Cliente;
import modelo.gestorAplicacion.Usuarios.Persona;


public class ListadoMascotas extends OpcionDeMenu {

    @Override
    public void ejecutar() throws Throwable {
        listado(Main.getUsuarioActivo());
    }

    public static Cliente listado(Cliente usuario){
        System.out.println(usuario.mascotasRegistradas());
        return usuario;
    }

    public static Cliente listado(Persona usuario) throws Throwable {

        if(usuario instanceof Cliente){
            listado((Cliente) usuario);
        }

        else{

            System.out.print("Ingrese el usuario de la persona:\n" +
                    "Escriba 'Salir' Para regresar al menú. \n");
            String username = in.next();

            if(username.equals("salir")){
                System.out.println("Regresando al menú...");
                Main.getMenu().lanzarMenu();
            }

            Cliente cliente = (Cliente) Cliente.fromUsuarioGetPersona(username);
            if(cliente != null){
                System.out.println(cliente.mascotasRegistradas());
                Thread.sleep(1000);
                return cliente;
            }
            else{
                System.out.println("Usuario no encontrado.");
                ListadoMascotas.listado(Main.getUsuarioActivo());
            }
            return null;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Ver listado de mascotas.";
    }
}
