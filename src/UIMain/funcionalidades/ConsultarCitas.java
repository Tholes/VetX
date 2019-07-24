package UIMain.funcionalidades;

import BaseDatos.in;
import UIMain.Main;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Usuarios.Cliente;
import gestorAplicacion.Usuarios.Persona;

import java.io.IOException;

public class ConsultarCitas extends OpcionDeMenu {
    @Override
    public void ejecutar() throws IOException, InterruptedException {

        //getCitasSiguientes()
        Persona usuario = Main.getUsuarioActivo();
        listar(usuario);
    }

    public static void listar(Cliente usuario){
        System.out.println(usuario.getCitasSiguientes());
    }

    public static Cliente listar(Persona usuario) throws  IOException{

        if( usuario instanceof Cliente){
            listar((Cliente) usuario);
        }
        else{
            System.out.println("Ingrese el usuario de quien desea ver sus citas: ");
            String username = in.next();
            Cliente cliente = (Cliente) Persona.fromUsuarioGetPersona(username);
            System.out.println(cliente.getCitasSiguientes());
            return cliente;

        }
        return null;
    }

    @Override
    public String toString() {
        return "Consultar citas";
    }
}
