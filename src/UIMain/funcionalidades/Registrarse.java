package UIMain.funcionalidades;

import BaseDatos.in;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Usuarios.Administrador;
import gestorAplicacion.Usuarios.Cliente;
import gestorAplicacion.Usuarios.Veterinario;

import java.io.IOException;

public class Registrarse extends OpcionDeMenu {

    @Override
    public void ejecutar() throws IOException {

        System.out.print("Ingrese su rol dentro de la veterinaria(1: Cliente, 2: Veterinario,3: Administrador): \n" +
                "Escriba 'Salir' Para regresar al menú. ");
        int rol= in.nextInt();

        if(rol == 1){
            registrarCliente();
        }
        else if(rol == 2){
            registrarVeterinario();
        }
        else if(rol == 3){
            registrarAdministrador();
        }

    }

    public void registrarCliente() throws IOException{

        System.out.print("Ingresar tu nombre: ");
        String nombre = in.nextLine();
        System.out.print("Ingresa tu email: ");
        String email = in.nextLine();
        System.out.print("Ingresa tu usuario: ");
        String usuario = in.nextLine();
        System.out.print("Ingresa tu key: ");
        String key = in.nextLine();
        System.out.print(Cliente.registrarse(nombre,email,usuario,key));
    }

    public void registrarAdministrador() throws  IOException{
        System.out.print("Ingresar tu nombre: ");
        String nombre = in.nextLine();
        System.out.print("Ingresa tu email: ");
        String email = in.nextLine();
        System.out.print("Ingresa tu usuario: ");
        String usuario = in.nextLine();
        System.out.print("Ingresa tu key: ");
        String key = in.nextLine();
        System.out.print(Administrador.registrarse(nombre,email,usuario,key));
    }

    public void registrarVeterinario() throws IOException{

        System.out.print("Ingresar tu nombre: ");
        String nombre = in.nextLine();
        System.out.print("Ingresa tu email: ");
        String email = in.nextLine();
        System.out.print("Ingresa tu especialidad: ");
        String especialidad = in.nextLine();
        System.out.print("Ingresa años de experiencia: ");
        byte experiencia = (byte) in.nextInt();
        System.out.print("Ingresa tu sueldo: ");
        int sueldo = in.nextInt();
        System.out.print("Ingresa el id de tu tarjeta profesional: ");
        long idTarjetaProfesional = (long) in.nextInt();
        System.out.print("Ingresa tu usuario: ");
        String usuario = in.nextLine();
        System.out.print("Ingresa tu key: ");
        String key = in.nextLine();
        System.out.print(Veterinario.registrarse(nombre,email,especialidad,experiencia,sueldo,idTarjetaProfesional,usuario,key));
    }
    @Override
    public String toString() {
        return "Registrarse.";
    }


}
