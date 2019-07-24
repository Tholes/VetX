package UIMain.funcionalidades;
import BaseDatos.Data;
import UIMain.Main;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Animales.Mascota;
import gestorAplicacion.Usuarios.Cliente;
import gestorAplicacion.Usuarios.Persona;
import gestorAplicacion.Usuarios.Veterinario;
import gestorAplicacion.prestacion.Cita;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import BaseDatos.in;

public class CambiarFechaCita extends OpcionDeMenu{
    public void ejecutar() throws IOException, InterruptedException {
        Persona usuario = Main.getUsuarioActivo();
        cambiarFecha(usuario);

    }

    public void cambiarFecha(Cliente cliente) throws IOException, InterruptedException {
        System.out.println(cliente.getCitasSiguientes());
        if(cliente.getCitas().size() != 0){
            System.out.print("Ingrese el número de la cita que desee cambiar su fecha: ");
            int opcion = in.nextInt();
            Cita citaAnterior = cliente.getCitas().get(opcion-1);
            System.out.println(Cita.getDisponibilidad());
            System.out.println("Ingrese la nueva fecha: (dia mes año hora separados por un espacio)");
            int dia = in.nextInt();
            int mes = in.nextInt();
            int año = in.nextInt();
            int hora = in.nextInt();

            String fecha = año+"/"+ mes+"/"+ dia+"/" +hora;
            Veterinario veterinario = Veterinario.veterinarioDisponible(fecha);

            if(veterinario == null){
                System.out.println("No tenemos veterinarios disponibles para esa fecha, disculpe.");
                ejecutar();
            }
            else{
                citaAnterior.cambiarCita(fecha,veterinario);
                System.out.println("Cita modificada exitosamente...");
            }

        }
    }

    public void cambiarFecha(Persona usuario) throws IOException, InterruptedException {

        if(usuario instanceof Cliente){
            cambiarFecha((Cliente) usuario);
        }
        else{
            System.out.print("Ingrese el usuario al que le desea cambiar la cita:  ");
            String nombreUsuario = in.next();
            Cliente cliente = (Cliente) Data.usuarios.get(nombreUsuario);
            System.out.println(cliente.getCitasSiguientes());
            if(cliente.getCitasAsignadas().isEmpty()==true){
                System.out.println("Regresando al menú...");
                Thread.sleep(5000);
                Main.setUsuarioActivo(Main.getUsuarioActivo());
            }else{

                System.out.print("Ingrese el número de la cita que desee cambiar su fecha: ");
                int opcion = in.nextInt();
                System.out.println(Cita.getDisponibilidad());
                Cita citaAnterior = cliente.getCitas().get(opcion-1);
                System.out.println("Ingrese la nueva fecha: (dia mes año hora separados por un espacio)");
                int dia = in.nextInt();
                int mes = in.nextInt();
                int año = in.nextInt();
                int hora = in.nextInt();
                String fecha = dia+"/"+mes+"/"+año+"/"+hora;
                Veterinario veterinario = Veterinario.veterinarioDisponible(fecha);

                if(veterinario == null){
                    System.out.println("No tenemos veterinarios disponibles para esa fecha, disculpe.");
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
        return "Cambiar fecha de una cita";
    }
}