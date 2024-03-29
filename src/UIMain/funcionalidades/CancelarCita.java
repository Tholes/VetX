package UIMain.funcionalidades;

import UIMain.Main;
import UIMain.OpcionDeMenu;
import modelo.gestorAplicacion.Usuarios.Cliente;
import modelo.gestorAplicacion.Usuarios.Persona;
import modelo.gestorAplicacion.prestacion.Cita;

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
        System.out.println("Ingrese el número de la cita: \n" +
                "Escriba 'Salir' Para regresar al menú.");
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
            System.out.println("Ingrese el número de la cita: \n" +
                    "Escriba 'Salir' Para regresar al menú.");
            int opcion = in.nextInt()-1;
            Cita cita = cliente.getCitas().get(opcion);
            if(cita != null){
                cliente.cancelarCita(cita);
                System.out.println("Se ha borrado exitosamente...");
                System.out.println("Regresando al menú...");
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