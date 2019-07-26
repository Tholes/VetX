package UIMain.funcionalidades;
import BaseDatos.in;
import UIMain.Main;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Animales.Mascota;
import gestorAplicacion.Usuarios.Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import gestorAplicacion.Usuarios.Persona;
import gestorAplicacion.Usuarios.Veterinario;
import gestorAplicacion.prestacion.Cita;

public class PedirCita extends OpcionDeMenu {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    VerDisponibilidad fechasDisponibles = new VerDisponibilidad();

    public void ejecutar() throws Throwable {
        pedirFecha(Main.getUsuarioActivo());
        System.out.println("Su cita fue solicitada con exito, se le asignará un veterinario");
    }

    public void pedirFecha(Cliente cliente) throws IOException, InterruptedException {
        System.out.println(Cita.getDisponibilidad());
        ListadoMascotas.listado(cliente);
        System.out.println("Ingrese el número de la mascota a la cual le desea pedir cita: \n" +
                "Escriba 'Salir' Para regresar al menú. ");
        int opcion = in.nextInt()-1;
        Mascota mascota = cliente.getMascotas().get(opcion);
        System.out.println("Ingrese los datos de la nueva cita: ");
        System.out.print("Ingrese el día: ");
        int dia = in.nextInt();
        System.out.print("Ingrese el mes: ");
        int mes = in.nextInt();
        System.out.print("Ingrese el año: ");
        int año = in.nextInt();
        System.out.print("Ingrese la hora: ");
        int hora = in.nextInt();

        String fecha = dia+"/"+mes+"/"+año+"/"+hora+"/";
        if(Cita.getDisponibilidad(fecha)){
            System.out.println("La fecha no se encuentra disponible, por favor: ");
            pedirFecha(cliente);
        }

        Veterinario veterinario = Veterinario.veterinarioDisponible(fecha);
        Cita.nuevaCita(fecha,veterinario,cliente,mascota);
    }
    public void pedirFecha(Persona admin) throws Throwable {

        if(admin instanceof Cliente){
            pedirFecha((Cliente) admin);
        }
        else
        {
            Cliente cliente = ListadoMascotas.listado(admin);
            System.out.println("Ingrese el número de la mascota a la cual le desea pedir cita: " +
                    " Escriba 'Salir' Para regresar al menú. ");
            int opcion = in.nextInt()-1;
            Mascota mascota = cliente.getMascotas().get(opcion);
            System.out.println("Ingrese los datos de la nueva cita: ");
            System.out.print("Ingrese el día: ");
            int dia = in.nextInt();
            System.out.print("Ingrese el mes: ");
            int mes = in.nextInt();
            System.out.print("Ingrese el año: ");
            int año = in.nextInt();
            System.out.print("Ingrese la hora: ");
            int hora = in.nextInt();

            String fecha = dia+"/"+mes+"/"+año+"/"+hora+"/";
            if(Cita.getDisponibilidad(fecha)){
                System.out.println("La fecha no se encuentra disponible, por favor: ");
                pedirFecha(cliente);
            }
            Veterinario veterinario = Veterinario.veterinarioDisponible(fecha);
            Cita.nuevaCita(fecha,veterinario,cliente,mascota);

        }
            }

    public String toString() {
        return "Pedir cita.";
    }
}
