package UIMain.funcionalidades;
import BaseDatos.in;
import UIMain.Main;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Animales.Mascota;
import gestorAplicacion.Usuarios.Cliente;
import gestorAplicacion.prestacion.Clinica;

import java.io.IOException;
import java.util.Scanner;
public class HospitalizarMascota extends OpcionDeMenu{
    Scanner entrada = new Scanner (System.in);

    public void ejecutar() throws IOException {

        Cliente cliente = ListadoMascotas.listado(Main.getUsuarioActivo());
        System.out.println("Ingresa el número de la máscota que hospitalizarás: ");
        int opcion = in.nextInt()-1;
        if(!cliente.getMascotas().contains(opcion)){
            Mascota mascota = cliente.getMascotas().get(opcion);
            Clinica.hospitalizarMascota(mascota);
            System.out.println("La mascota ha sido hospitalizada.");
        }
        else{
            System.out.println("Numero incorrecto");
            ejecutar();
        }

    }

    public String toString(){
        return "Hospitalizar Mascota";
    }
}