package UIMain.funcionalidades;
import BaseDatos.in;
import UIMain.Main;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Animales.Mascota;
import gestorAplicacion.Usuarios.Administrador;
import gestorAplicacion.Usuarios.Cliente;
import gestorAplicacion.Usuarios.Persona;
import gestorAplicacion.prestacion.Clinica;
import java.util.Scanner;
public class HospitalizarMascota extends OpcionDeMenu{
    Scanner entrada = new Scanner (System.in);

    public void ejecutar() throws Throwable {

        Administrador admin = new Administrador();
        Cliente cliente = ListadoMascotas.listado(admin);
        System.out.println("Ingresa el número de la máscota que hospitalizarás: \n" +
                "Escriba 'Salir' Para regresar al menú. ");
        int opcion = in.nextInt()-1;
        if(!cliente.getMascotas().contains(opcion)){
            Mascota mascota = cliente.getMascotas().get(opcion);
            Clinica.hospitalizarMascota(mascota);
            System.out.println("*** La mascota ha sido hospitalizada.");
        }
        else{
            System.out.println("Numero incorrecto");
            ejecutar();
        }

    }

    public String toString(){
        return "Hospitalizar Mascota.";
    }
}