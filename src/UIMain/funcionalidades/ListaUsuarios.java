package UIMain.funcionalidades;

import UIMain.OpcionDeMenu;
import gestorAplicacion.Usuarios.Persona;

public class ListaUsuarios extends OpcionDeMenu {
    @Override
    public void ejecutar() throws Throwable {
        System.out.println(Persona.listaUsuarios());
    }

    @Override
    public String toString() {
        return "Lista de usuarios registrado.";
    }
}
