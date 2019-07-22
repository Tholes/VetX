package UIMain.funcionalidades;
//Opción de menú 8
import UIMain.OpcionDeMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import BaseDatos.Data;


public class IniciarSesion extends OpcionDeMenu {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void ejecutar() throws IOException {
        pedirDatos();

    }

    public void pedirDatos() throws IOException{
        System.out.print("Ingrese su usuario: ");
        String usuario = br.readLine();
        System.out.print("Ingrese su contraseña: ");
        String contraseña = br.readLine();
        if(Data.usuarios.containsKey(usuario)){
            if(Data.usuarios.get(usuario).getKey().equals(contraseña)){

            }
            else{
                System.out.println("¡datos incorrectos!");
                pedirDatos();
            }
        }
        else{
            System.out.println("¡datos incorrectos!");
            pedirDatos();
        }
    }
    public String toString(){
        return "Iniciar Sesion";
    }
}