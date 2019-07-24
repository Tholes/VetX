package UIMain.funcionalidades;
//Opción de menú 8
import UIMain.OpcionDeMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import BaseDatos.Data;
import gestorAplicacion.Usuarios.Persona;


public class IniciarSesion extends OpcionDeMenu {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void ejecutar() throws IOException {
        pedirDatos();

    }

    public void pedirDatos() throws IOException{
        System.out.println("Ingrese su usuario: ");
        String usuario = br.readLine();
        System.out.println("Ingrese su contraseña: ");
        String key = br.readLine();
        System.out.println(Persona.login(usuario,key));
    }

    public String toString(){
        return "Iniciar Sesion";
    }
}