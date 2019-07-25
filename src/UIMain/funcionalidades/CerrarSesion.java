package UIMain.funcionalidades;
//Opción de menú 3
import UIMain.Main;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Usuarios.Persona;

public class CerrarSesion extends OpcionDeMenu{
    public void ejecutar(){

        System.out.println("Terminando sesión...");
        Main.setUsuarioActivo(null);
    }
    public String toString(){
        return "Cerrar Sesion.";
    }

}