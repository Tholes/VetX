package UIMain.registrados.cliente;

import UIMain.OpcionDeMenu;
import UIMain.funcionesGenerales.verDisponibilidad;
import gestorAplicacion.Usuarios.Administrador;
import gestorAplicacion.Usuarios.Cliente;
import gestorAplicacion.prestacion.Cita;
import java.util.Date;
import java.util.Scanner;

public class pedirCita extends OpcionDeMenu {

    Scanner in = new Scanner(System.in);
    verDisponibilidad fechasDisponibles = new verDisponibilidad();

    public void ejecutar() {
        Date fecha = pedirFecha();
        System.out.println("Su cita fue solicitada con exito, se le asignará un veterinario");
        /*
        Cree el método estatico asignarVeterinario() por comodidad,
        luego deberemos re pensar cómo asignaremos un veterinario 
        */
        Veterinario veterinarioAsignado = Administrador.asignarVeterinario();
        Cita cita = new Cita(fecha, veterinarioAsginado, cliente);
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
        Cliente cliente = new Cliente();//Ejemplo
        if(!cliente.pedirCita(año, mes, dia)){
            System.out.println("La fecha no se encuentra disponible, por favor: ");
            return pedirFecha();
        }
        
    }

    public String toString() {
        return "a";
    }
}
