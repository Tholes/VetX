package UIMain.funcionalidades;
//Opción de menú 13
import BaseDatos.Data;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Usuarios.Persona;
import gestorAplicacion.Usuarios.Cliente;
import java.util.Scanner;


import java.util.Date;
public class RegistrarMascota extends OpcionDeMenu {

    Scanner in = new Scanner(System.in);

    /**
     *
     */
    @Override
    public void ejecutar() {

        System.out.println("POR FAVOR INGRESE LOS SIGUIENTES DATOS DE LA MASCOTA. ");

        System.out.println("Ingrese el nombre de la mascota: ");
        String nombre = in.nextLine();

        System.out.println("Ingrese la fecha de nacimiento de su mascota(Año mes dia separados por un espacio: ");
        int año = in.nextInt();
        int mes = in.nextInt();
        int dia = in.nextInt();
        Date fechaNacimiento = new Date(año, mes, dia);

        System.out.println("Ingrese el sexo de su mascota(M/H): ");
        char genero = in.next().charAt(0);

        System.out.println("Ingrese la especie de su mascota: ");
        String especie = in.nextLine();

        System.out.println("Ingrese la raza de su mascota: ");
        String raza = in.nextLine();

        System.out .println("Ingrese dueño de la mascota: ");
        String nombreUsuario = in.nextLine();

        Cliente amo = (Cliente) Data.usuarios.get(nombreUsuario);


        Persona.registrarMascota(nombre, fechaNacimiento, genero, especie, raza, amo);

        /*

        Para registrarlo primero tendríamos que saber
        quien está activo

        */
    }

    @Override
    public String toString() {
        return "registrar una nueva mascota";
    }
}
