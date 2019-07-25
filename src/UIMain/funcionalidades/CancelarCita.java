package UIMain.funcionalidades;
//Opción de menú 2
import BaseDatos.Data;
import UIMain.Main;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Usuarios.Cliente;
import gestorAplicacion.Usuarios.Persona;
import gestorAplicacion.prestacion.Cita;

import java.io.IOException;
import java.util.Scanner;

public class CancelarCita extends OpcionDeMenu{
    Scanner in = new Scanner(System.in);
    public void ejecutar() throws Throwable {
        Persona cliente = Main.getUsuarioActivo();
        eliminar(cliente);
    }

    public void eliminar(Cliente cliente) throws Throwable{
        ConsultarCitas.listar(cliente);
        System.out.println("Ingrese el número de la cita: ");
        int opcion = in.nextInt()-1;
        Cita cita = cliente.getCitas().get(opcion);
        if(cita != null){
            cliente.cancelarCita(cita);
            System.out.println("¡Se ha borrado exitosamente!");
            Thread.sleep(3000);
        }else{
            System.out.println("El número ingresado no es correcto.");
            ejecutar();
        }
    }

    public void eliminar(Persona usuario) throws IOException, Throwable {

        if(usuario instanceof Cliente){
            eliminar((Cliente) usuario);
        }

        else{
            Cliente cliente = ConsultarCitas.listar(usuario);
            System.out.println("Ingrese el número de la cita: ");
            int opcion = in.nextInt()-1;
            Cita cita = cliente.getCitas().get(opcion);
            if(cita != null){
                cliente.cancelarCita(cita);
                System.out.println("Se ha borrado exitosamente...");
                Thread.sleep(5000);
            }else{
                System.out.println("El número ingresado no es correcto.");
                ejecutar();
            }

        }
    }

    public String toString(){
        return "Cancelar cita.";
    }

}