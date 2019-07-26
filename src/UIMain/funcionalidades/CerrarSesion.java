package UIMain.funcionalidades;
import UIMain.Main;
import UIMain.OpcionDeMenu;

public class CerrarSesion extends OpcionDeMenu{
    public void ejecutar(){

        System.out.println("Terminando sesión...");
        Main.setUsuarioActivo(null);
    }
    public String toString(){
        return "Cerrar Sesion.";
    }

}