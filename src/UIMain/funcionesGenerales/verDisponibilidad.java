package UIMain.funcionesGenerales;

import java.util.ArrayList;

import UIMain.OpcionDeMenu;
import gestorAplicacion.prestacion.Cita;
import java.util.Date;

public class verDisponibilidad extends OpcionDeMenu{

    public void ejecutar(){
        System.out.println(Cita.getDisponibilidad());
    }
    public String toString(){
        return "a";
    }
}