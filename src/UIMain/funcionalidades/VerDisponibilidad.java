package UIMain.funcionalidades;
//Opción de menú 11
import UIMain.OpcionDeMenu;
import gestorAplicacion.prestacion.Cita;

public class VerDisponibilidad extends OpcionDeMenu{

    public void ejecutar(){
        System.out.println(Cita.getDisponibilidad());
    }
    public String toString(){
        return "a";
    }
}