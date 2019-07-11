package UIMain.registrados.cliente;

import UIMain.OpcionDeMenu;
import java.util.Scanner;

public class registrarMascota extends OpcionDeMenu {

    Scanner in = new Scanner(System.in);

    public void ejecutar() {
        
        System.out.println("----------------------------------------------------------");
        System.out.print("Ingrese el nombre de la mascota: ");
        String nombre = in.nextLine();
        System.out.print("Ingrese la edad de su mascota: ");
        int edad = in.nextInt();
        System.out.print("Ingrese el genero de su mascota(M/H): ");
        char genero = in.next().charAt(0);
        System.out.print("Ingrese la especie de su mascota: ");
        String especie = in.nextLine();
        System.out.print("Ingrese la raza de su mascota: ");
        String raza = in.nextLine();
        
        /*
        
        Para registrarlo primero tendríamos que saber
        quien está activo
        
        */
    }

    public String toString() {
        return "a";
    }
}
