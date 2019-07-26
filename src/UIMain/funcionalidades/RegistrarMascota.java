package UIMain.funcionalidades;
import BaseDatos.Data;
import BaseDatos.in;
import UIMain.Main;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Usuarios.Persona;
import gestorAplicacion.Usuarios.Cliente;


import java.io.IOException;
import java.util.Date;
public class RegistrarMascota extends OpcionDeMenu {

    @Override
    public void ejecutar() throws Throwable {
        Persona usuario = Main.getUsuarioActivo();
        registrar(usuario);

    }

    public void registrar(Cliente cliente) throws Throwable {
        System.out.println("POR FAVOR INGRESE LOS SIGUIENTES DATOS DE LA MASCOTA. \n" +
                       "Escriba 'Salir' Para regresar al menú. ");
        System.out.println("Ingrese el nombre de la mascota: ");
        String nombre = in.nextLine();
        if(nombre.equals("salir")){
            Main.getMenu().lanzarMenu();
        }
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
        Persona.registrarMascota(nombre, fechaNacimiento, genero, especie, raza, cliente);
        System.out.println("La mascota fue registrada.");
    }

    public void registrar(Persona admin) throws Throwable {

        System.out.println("POR FAVOR INGRESE LOS SIGUIENTES DATOS DE LA MASCOTA. \n" +
                "Para regresar escriba 'salir'.");
        System.out.println("Ingrese el nombre de la mascota: ");
        String nombre = in.nextLine();

        if(nombre.equals("salir")){
            Main.getMenu().lanzarMenu();
            System.out.println("Regresando al menú...");
        }
        System.out.println("Ingrese la fecha de nacimiento de su mascota(Año mes dia separados por un espacio: ");
        int año = in.nextInt();
        int mes = in.nextInt();
        int dia = in.nextInt();
        String fechaNacimiento = dia+"/"+mes+"/"+año;

        //System.out.println("Ingrese el sexo de su mascota(M/H): ");
        char genero = pedirElSexo().charAt(0);

        System.out.println("Ingrese la especie de su mascota: ");
        String especie = in.nextLine();

        System.out.println("Ingrese la raza de su mascota: ");
        String raza = in.nextLine();

        System.out .println("Ingrese el nombre de usuario del dueño de la mascota: ");
        String nombreUsuario = in.nextLine();


        Cliente amo = (Cliente) Data.usuarios.get(nombreUsuario);
        if(amo != null){
            Persona.registrarMascota(nombre, fechaNacimiento, genero, especie, raza, amo);
            System.out.println("*** Un nueva mascota a ingresado como paciente a la clínica.");
            System.out.println("Regresando al menú...");
        }
        else{
            ejecutar();
        }
    }

    public String pedirElSexo() throws IOException {
        System.out.println("Ingrese el sexo de su mascota(M/H): ");
        String sexo = in.next();
        if(sexo.equals("h") || sexo.equals("m")){
            return sexo;
        }
        System.out.println("caracter incorrecto.");
        return pedirElSexo();
    }

    @Override
    public String toString() {
        return "registrar una nueva mascota.";
    }
}
