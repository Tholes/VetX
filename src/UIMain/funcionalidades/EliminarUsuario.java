package UIMain.funcionalidades;

import BaseDatos.Data;
import BaseDatos.in;
import UIMain.Main;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Usuarios.Persona;

public class EliminarUsuario extends OpcionDeMenu {
    @Override
    public void ejecutar() throws Throwable {
        System.out.println(Persona.listaUsuarios());
        System.out.println("Ingresa el nombre de usuario que desees eliminar: \n" +
                "Escriba 'Salir' Para regresar al menú. \n");
        String opcion = in.next();
        if(opcion.equals("salir")){
            Main.getMenu().lanzarMenu();
        }
        Persona usuario = Data.usuarios.get(opcion);
        if(usuario == null){
            System.out.println("Usuario incorrecto. ");
            ejecutar();
        }
        else{
            usuario.eliminarme();
            System.out.println("Usuario eliminado.");
        }

    }

    @Override
    public String toString() {
        return "Eliminar usuario";
    }
}
