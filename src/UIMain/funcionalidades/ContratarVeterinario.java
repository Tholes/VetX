package UIMain.funcionalidades;

import UIMain.Main;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Usuarios.Administrador;
import java.util.Scanner;

public class ContratarVeterinario extends OpcionDeMenu {
    Scanner entrada = new Scanner(System.in);

    public void ejecutar() throws Throwable {
        System.out.println("POR FAVOR INGRESAR LOS DATOS DEL NUEVO VETERINARIO. \n" +
                "Escriba 'Salir' Para regresar al menú. ");
        System.out.println("Ingrese el nombre: ");
        String nombre = entrada.nextLine();
        if(nombre.equals("salir")){
            System.out.printf("Regresando al menú...");
            Main.getMenu().lanzarMenu();
        }
        System.out.println("Ingrese el correo electronico: ");
        String email = entrada.nextLine();

        System.out.println("Ingrese la especialidad: ");
        String especialidad = entrada.nextLine();

        System.out.println("Ingrese los años de experiencia: ");
        byte experiencia = entrada.nextByte();

        System.out.println("Ingrese el sueldo mensual: ");
        int sueldo = entrada.nextInt();

        System.out.println("Ingrese id de la tarjeta profesional: ");
        long idtajetaProfesional = entrada.nextLong();

        System.out.println("Asignar nombre de usuario: ");
        entrada.nextLine();
        String usuario = entrada.nextLine();

        System.out.println("Asignar contraseña: ");
        String key = entrada.nextLine();

        System.out.println("***Un nuevo veterinario hace parte del personal médico de la clínica.");
        Administrador.contratarVeterinario(nombre, email, especialidad, experiencia, sueldo, idtajetaProfesional, usuario, key);

    }

    public String toString() {
        return "Contratar un nuevo veterinario.";
    }
}