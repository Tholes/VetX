package UIMain.funcionalidades;

import UIMain.Main;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Usuarios.Cliente;
import gestorAplicacion.Usuarios.Persona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ListadoMascotas extends OpcionDeMenu {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    @Override
    public void ejecutar() throws IOException {
        listado(Main.getUsuarioActivo());
    }

    public void listado(Cliente usuario){
        System.out.println(usuario.mascotasRegistradas());
    }

    public void listado(Persona usuario) throws IOException{

        if(usuario instanceof Cliente){
            listado((Cliente) usuario);
        }

        System.out.println();
        System.out.println("Ingrese el usuario de la persona: ");
        String username = br.readLine().trim().toLowerCase();
        Cliente cliente = (Cliente) Cliente.fromUsuarioGetPersona(username);
        System.out.println(cliente.mascotasRegistradas());

    }

    @Override
    public String toString() {
        return "Ver listado de mascotas";
    }
}
