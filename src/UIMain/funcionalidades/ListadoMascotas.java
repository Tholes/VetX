package UIMain.funcionalidades;

import BaseDatos.in;
import UIMain.Main;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Usuarios.Cliente;
import gestorAplicacion.Usuarios.Persona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ListadoMascotas extends OpcionDeMenu {

    @Override
    public void ejecutar() throws IOException {
        listado(Main.getUsuarioActivo());
    }

    public static Cliente listado(Cliente usuario){
        System.out.println(usuario.mascotasRegistradas());
        return usuario;
    }

    public static Cliente listado(Persona usuario) throws IOException{

        if(usuario instanceof Cliente){
            listado((Cliente) usuario);
        }

        System.out.println();
        System.out.println("Ingrese el usuario de la persona: ");
        String username = in.next();
        Cliente cliente = (Cliente) Cliente.fromUsuarioGetPersona(username);
        System.out.println(cliente.mascotasRegistradas());
        return cliente;
    }

    @Override
    public String toString() {
        return "Ver listado de mascotas";
    }
}
