package UIMain.funcionalidades;

import UIMain.OpcionDeMenu;
import gestorAplicacion.Usuarios.Administrador;
import gestorAplicacion.Usuarios.Cliente;
import gestorAplicacion.Usuarios.Veterinario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Registrarse extends OpcionDeMenu {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    @Override
    public void ejecutar() throws IOException {

        System.out.print("Ingrese su rol dentro de la veterinaria(1: Cliente, 2: Veterinario,3: Administrador): ");
        int rol= Integer.parseInt(br.readLine());
        switch (rol){
            case 1:
                registrarCliente();
            case 2:
                registrarVeterinario();
            case 3:
                registrarAdministrador();
        }
    }

    public void registrarCliente() throws IOException{

        System.out.print("Ingresar tu nombre: ");
        String nombre = br.readLine();
        System.out.print("Ingresa tu email: ");
        String email = br.readLine();
        System.out.print("Ingresa tu usuario: ");
        String usuario = br.readLine();
        System.out.print("Ingresa tu key: ");
        String key = br.readLine();
        System.out.print(Cliente.registrarse(nombre,email,usuario,key));
    }

    public void registrarAdministrador() throws  IOException{
        System.out.print("Ingresar tu nombre: ");
        String nombre = br.readLine();
        System.out.print("Ingresa tu email: ");
        String email = br.readLine();
        System.out.print("Ingresa tu usuario: ");
        String usuario = br.readLine();
        System.out.print("Ingresa tu key: ");
        String key = br.readLine();
        System.out.print(Administrador.registrarse(nombre,email,usuario,key));
    }

    public void registrarVeterinario() throws IOException{

        System.out.print("Ingresar tu nombre: ");
        String nombre = br.readLine();
        System.out.print("Ingresa tu email: ");
        String email = br.readLine();
        System.out.print("Ingresa tu especialidad: ");
        String especialidad = br.readLine();
        System.out.print("Ingresa años de experiencia: ");
        byte experiencia = Byte.parseByte(br.readLine());
        System.out.print("Ingresa tu sueldo: ");
        int sueldo = Integer.parseInt(br.readLine());
        System.out.println("Ingresa el id de tu tarjeta profesional: ");
        long idTarjetaProfesional = Long.parseLong(br.readLine());
        System.out.print("Ingresa tu usuario: ");
        String usuario = br.readLine();
        System.out.print("Ingresa tu key: ");
        String key = br.readLine();
        System.out.print(Veterinario.registrarse(nombre,email,especialidad,experiencia,sueldo,idTarjetaProfesional,usuario,key));

    }
    @Override
    public String toString() {
        return "Registrarse";
    }


}
