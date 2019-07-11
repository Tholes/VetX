package UIMain.registrados.cliente;

import UIMain.OpcionDeMenu;
import UIMain.funcionesGenerales.verDisponibilidad;
import gestorAplicacion.prestacion.Cita;
import java.util.Date;
import java.util.Scanner;

public class pedirCita extends OpcionDeMenu {

    Scanner in = new Scanner(System.in);
    verDisponibilidad fechasDisponibles = new verDisponibilidad();
    public void ejecutar() {
        Date fechaCandidata = pedirFecha();
    }

    public Date pedirFecha() {
        fechasDisponibles.ejecutar();
        System.out.println("Ingrese una fecha que se encuentre disponible: ");
        System.out.print("Ingrese el año: ");
        int año = in.nextInt();
        System.out.print("Ingrese el mes: ");
        int mes = in.nextInt();
        System.out.print("Ingrese el día: ");
        int dia = in.nextInt();
        Date fechaCandidata = new Date(año, mes, dia);

        if (Cita.getDisponibilidad().contains(fechaCandidata)) {
            return fechaCandidata;
        } else {
            System.out.println("Fecha no disponible, por favor: ");
            return pedirFecha();
        }
    }

    public String toString() {
        return "a";
    }
}
