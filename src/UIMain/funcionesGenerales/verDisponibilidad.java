package UIMain.funcionesGenerales;

import java.util.ArrayList;

import UIMain.OpcionDeMenu;
import gestorAplicacion.prestacion.Cita;
import java.util.Date;

public class verDisponibilidad extends OpcionDeMenu{
    
    public void ejecutar(){
        ArrayList<Date> fechasDisponibles = Cita.getDisponibilidad();
        System.out.println("----------------------------------------------------------");
        for (int i = 0; i < fechasDisponibles.size() ; i++) {
            int año = fechasDisponibles.get(i).getYear();
            int mes = fechasDisponibles.get(i).getMonth();
            int dia = fechasDisponibles.get(i).getDay();
            System.out.println(año+"/"+mes+"/"+dia);
        }
        System.out.println("----------------------------------------------------------");
    }
    public String toString(){
        return "a";
    }
}