package UIMain.funcionalidades;
import UIMain.Main;
import UIMain.OpcionDeMenu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import modelo.BaseDatos.in;
import modelo.gestorAplicacion.Usuarios.Persona;


public class IniciarSesion extends OpcionDeMenu {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void ejecutar() throws Throwable {
        pedirDatos();

    }

    public void pedirDatos() throws Throwable {
        System.out.println("Escriba 'Salir' Para regresar al menú. ");
        System.out.print("Ingrese su usuario: ");
        String usuario = in.next();
        if(usuario.equals("salir")){
            System.out.println("Regresando al menú...");
            Main.getMenu().lanzarMenu();
        }
        System.out.print("Ingrese su contraseña: ");
        String key = in.next();
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println(Persona.login(usuario,key));
    }

    public String toString(){
        return "Iniciar Sesion.";
    }
}