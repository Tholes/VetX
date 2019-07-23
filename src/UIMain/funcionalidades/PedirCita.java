package UIMain.funcionalidades;
//Opción de menú 9
import UIMain.Main;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Usuarios.Administrador;
import gestorAplicacion.Usuarios.Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import gestorAplicacion.Usuarios.Persona;

public class PedirCita extends OpcionDeMenu {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    VerDisponibilidad fechasDisponibles = new VerDisponibilidad();

    public void ejecutar()throws IOException {
        Date fecha = pedirFecha(Main.getUsuarioActivo());
        System.out.println("Su cita fue solicitada con exito, se le asignará un veterinario");
    }

    public Date pedirFecha(Cliente cliente) throws IOException {
        System.out.println("Ingrese una fecha que se encuentre disponible: ");
        System.out.print("Ingrese el día: ");
        int dia = Integer.parseInt(br.readLine());
        System.out.print("Ingrese el mes: ");
        int mes = Integer.parseInt(br.readLine());
        System.out.print("Ingrese el año: ");
        int año = Integer.parseInt(br.readLine());

        if(!cliente.pedirCita(año, mes, dia,cliente)){
            System.out.println("La fecha no se encuentra disponible, por favor: ");
            return pedirFecha(cliente);
        }
        return null;
    }

    public Date pedirFecha(Persona admin) throws IOException{

        if(admin instanceof Cliente){
            pedirFecha((Cliente) admin);
        }

        System.out.println("Ingrese el nombre de usuario del cliente: ");
        String usuario = br.readLine();
        System.out.print("Ingrese el día: ");
        int dia = Integer.parseInt(br.readLine());
        System.out.print("Ingrese el mes: ");
        int mes = Integer.parseInt(br.readLine());
        System.out.print("Ingrese el año: ");
        int año = Integer.parseInt(br.readLine());
        Cliente cliente = (Cliente) Persona.fromUsuarioGetPersona(usuario);
        if(!cliente.pedirCita(año, mes, dia,cliente)){
            System.out.println("La fecha no se encuentra disponible, por favor: ");
            return pedirFecha(cliente);
        }
        return null;
    }

    public String toString() {
        return "Pedir cita";
    }
}
