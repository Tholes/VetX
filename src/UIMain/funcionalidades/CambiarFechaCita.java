package UIMain.funcionalidades;
import BaseDatos.Data;
import UIMain.Main;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Usuarios.Cliente;
import gestorAplicacion.Usuarios.Persona;
import gestorAplicacion.Usuarios.Veterinario;
import gestorAplicacion.prestacion.Cita;

import BaseDatos.in;

public class CambiarFechaCita extends OpcionDeMenu{
    public void ejecutar() throws Throwable {
        Persona usuario = Main.getUsuarioActivo();
        cambiarFecha(usuario);
    }

    public void cambiarFecha(Cliente cliente) throws Throwable {
        System.out.println(cliente.getCitasSiguientes());
        if(cliente.getCitas().size() != 0){
            int opcion=0;
            System.out.print("Ingrese el número de la cita que desee cambiar su fecha: \n" +
                    "Escriba 'Salir' Para regresar al menú. ");

            opcion = in.nextInt();
            Cita citaAnterior = cliente.getCitas().get(opcion-1);
            if(citaAnterior != null){
                System.out.println(Cita.getDisponibilidad());
                System.out.println("Ingrese la nueva fecha: (dia mes año hora separados por un espacio)");
                int dia = in.nextInt();
                int mes = in.nextInt();
                int año = in.nextInt();
                int hora = in.nextInt();
                String fecha = dia+"/"+ mes+"/"+ año+"/" +hora;
                Veterinario veterinario = Veterinario.veterinarioDisponible(fecha);

                if(veterinario == null){
                    System.out.println("Cita no disponible.");
                    ejecutar();
                }

                else{
                    citaAnterior.cambiarCita(fecha,veterinario);
                    System.out.println("Cita modificada exitosamente...");
                    Thread.sleep(2000);
                }
            }
            else{
                System.out.println("Número incorrecto.");
                ejecutar();
            }
        }
    }

    public void cambiarFecha(Persona usuario) throws Throwable {

        if(usuario instanceof Cliente){
            cambiarFecha((Cliente) usuario);
        }
        else{

            System.out.println("Ingrese el usuario al que le desea cambiar la cita: \n" +
                            "Para regresar escriba 'salir'." );
            String nombreUsuario = in.next();

            if(nombreUsuario.equals("salir")){
                Main.getMenu().lanzarMenu();
            }

            Cliente cliente = (Cliente) Data.usuarios.get(nombreUsuario);
            System.out.println(cliente.getCitasSiguientes());
            if(cliente == null){
                System.out.println("El usuario que ingresó no existe.");
                Thread.sleep(2000);
                ejecutar();
            }else{
                System.out.print("Ingrese el número de la cita que desee cambiar su fecha: ");
                int opcion = in.nextInt();
                System.out.println(Cita.getDisponibilidad());
                Cita citaAnterior = cliente.getCitas().get(opcion-1);
                System.out.println("Ingrese la nueva fecha: (dia mes año hora (0-24)) separados por un espacio)");
                int dia = in.nextInt();
                int mes = in.nextInt();
                int año = in.nextInt();
                int hora = in.nextInt();
                String fecha = dia+"/"+mes+"/"+año+"/"+hora;
                Veterinario veterinario = Veterinario.veterinarioDisponible(fecha);

                if(veterinario == null){
                    System.out.println("Cita no disponible.");
                    ejecutar();
                }

                else{
                    citaAnterior.cambiarCita(fecha,veterinario);
                    System.out.println("Cita modificada exitosamente...");
                }

            }
        }
    }

    public String toString(){
        return "Cambiar fecha de una cita.";
    }

}