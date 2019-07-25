package UIMain.funcionalidades;
//Opción de menú 8
import UIMain.OpcionDeMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import BaseDatos.in;
import gestorAplicacion.Usuarios.Persona;


public class IniciarSesion extends OpcionDeMenu {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void ejecutar() throws IOException, InterruptedException {
        pedirDatos();

    }

    public void pedirDatos() throws IOException, InterruptedException {
        System.out.print("Ingrese su usuario: ");
        String usuario = in.next();
        System.out.print("Ingrese su contraseña: ");
        String key = in.next();
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println(Persona.login(usuario,key));
    }

    public String toString(){
        return "Iniciar Sesion.";
    }
}