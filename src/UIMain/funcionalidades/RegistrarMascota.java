package UIMain.funcionalidades;
//Opción de menú 13
import BaseDatos.Data;
import BaseDatos.in;
import UIMain.Main;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Usuarios.Persona;
import gestorAplicacion.Usuarios.Cliente;

import java.io.IOException;
import java.util.Scanner;


import java.util.Date;
public class RegistrarMascota extends OpcionDeMenu {

    @Override
    public void ejecutar() throws IOException {
        Persona usuario = Main.getUsuarioActivo();
        registrar(usuario);

        /*
        Para registrarlo primero tendríamos que saber
        quien está activo
        */
    }

    public void registrar(Cliente cliente) throws IOException {
        System.out.println("POR FAVOR INGRESE LOS SIGUIENTES DATOS DE LA MASCOTA. ");
        System.out.println("Ingrese el nombre de la mascota: ");
        String nombre = in.nextLine();

        System.out.println("Ingrese la fecha de nacimiento de su mascota(dia mes año separados por un espacio: ");
        int dia = in.nextInt();
        int mes = in.nextInt();
        int año = in.nextInt();
        String fechaNacimiento = dia+"/"+mes+"/"+año;

        System.out.println("Ingrese el sexo de su mascota(M/H): ");
        char genero = in.next().charAt(0);

        System.out.println("Ingrese la especie de su mascota: ");
        String especie = in.nextLine();

        System.out.println("Ingrese la raza de su mascota: ");
        String raza = in.nextLine();

        System.out .println("Ingrese dueño de la mascota: ");
        String nombreUsuario = in.nextLine();

        Persona.registrarMascota(nombre, fechaNacimiento, genero, especie, raza, cliente);

        System.out.println("La mascota fue registrada.");
    }

    public void registrar(Persona admin) throws IOException {

        System.out.println("POR FAVOR INGRESE LOS SIGUIENTES DATOS DE LA MASCOTA. ");
        System.out.println("Ingrese el nombre de la mascota: ");
        String nombre = in.nextLine();

        System.out.println("Ingrese la fecha de nacimiento de su mascota(Año mes dia separados por un espacio: ");
        int año = in.nextInt();
        int mes = in.nextInt();
        int dia = in.nextInt();
        String fechaNacimiento = dia+"/"+mes+"/"+año;

        System.out.println("Ingrese el sexo de su mascota(M/H): ");
        char genero = in.next().charAt(0);

        System.out.println("Ingrese la especie de su mascota: ");
        in.nextLine();
        String especie = in.nextLine();

        System.out.println("Ingrese la raza de su mascota: ");
        String raza = in.nextLine();

        System.out .println("Ingrese dueño de la mascota: ");
        String nombreUsuario = in.nextLine();

        System.out.println("*** Un nueva mascota a ingresado como paciente a la clínica.");

        Cliente amo = (Cliente) Data.usuarios.get(nombreUsuario);
        Persona.registrarMascota(nombre, fechaNacimiento, genero, especie, raza, amo);
    }

    @Override
    public String toString() {
        return "registrar una nueva mascota";
    }
}
