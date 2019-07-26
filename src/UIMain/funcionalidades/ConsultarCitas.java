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

        Persona usuario = Main.getUsuarioActivo();
        listar(usuario);
    }

    public static void listar(Cliente usuario){
        System.out.println(usuario.getCitasSiguientes());
    }

    public static Cliente listar(Persona usuario) throws IOException, InterruptedException {

        if( usuario instanceof Cliente){
            listar((Cliente) usuario);
        }
        else{
            System.out.println("Ingrese el usuario de quien desea ver sus citas: \n" +
                    "Si desea regresar al menú escriba: Salir \n");
            String username = in.next();
            if(username.equals("salir")){
                Main.setUsuarioActivo(Main.getUsuarioActivo());
            }
            Cliente cliente = (Cliente) Persona.fromUsuarioGetPersona(username);
            System.out.println(cliente.getCitasSiguientes());
            Thread.sleep(500);
            return cliente;

        }
        return null;
    }

    @Override
    public String toString() {
        return "Consultar citas.";
    }
}
