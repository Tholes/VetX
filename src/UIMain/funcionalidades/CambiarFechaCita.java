package UIMain.funcionalidades;
//Opción de menú 1
import BaseDatos.Data;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Animales.Mascota;
import gestorAplicacion.Usuarios.Cliente;
import gestorAplicacion.Usuarios.Veterinario;
import gestorAplicacion.prestacion.Cita;

import java.util.Date;
import java.util.Scanner;

public class CambiarFechaCita extends OpcionDeMenu{
    Scanner in = new Scanner(System.in);
    public void ejecutar(){
        System.out.println("POR FAVOR INGRESAR USUARIO ");
        String nombreUsuario = in.nextLine();
        Cliente cliente = (Cliente) Data.usuarios.get(nombreUsuario);
        if(cliente.getCitasAsignadas().isEmpty()==true){
            System.out.println("No tenia citas");
        }else{
            cliente.getCitasAsignadas().clear();
        }
        System.out.println("Ingrese la fecha de su nueva cita(Año mes dia hora minuto separados por un espacio: ");
        int año = in.nextInt();
        int mes = in.nextInt();
        int dia = in.nextInt();
        int hora = in.nextInt();
        int min = in.nextInt();
        Date fecha = new Date(año, mes, dia, hora, min);
        Veterinario veterinario=null;
        veterinario.vetDiponible(fecha);
        Cita cita = new Cita(fecha,veterinario,cliente);
        System.out.println("Ingrese nombre la mascota");
        String nombreMascota = in.nextLine();
        Mascota mascota = (Mascota) Data.mascotas.get(nombreMascota);
        cliente.getCitasAsignadas().put(cita,mascota);
    }

    public String toString(){
        return "Cambiar fecha de una cita";
    }
}