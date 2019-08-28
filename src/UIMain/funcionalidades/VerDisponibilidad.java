package UIMain.funcionalidades;
import UIMain.OpcionDeMenu;
import modelo.gestorAplicacion.prestacion.Cita;

public class VerDisponibilidad extends OpcionDeMenu{

    public void ejecutar(){
        System.out.println(Cita.getDisponibilidad());
    }
    public String toString(){
        return "Ver fechas no disponibles.";
    }

}