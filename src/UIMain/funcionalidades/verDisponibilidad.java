package UIMain.funcionalidades;
//Opción de menú 14
import UIMain.OpcionDeMenu;
import gestorAplicacion.prestacion.Cita;

public class verDisponibilidad extends OpcionDeMenu{

    public void ejecutar(){
        System.out.println(Cita.getDisponibilidad());
    }
    public String toString(){
        return "a";
    }
}