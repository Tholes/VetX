package UIMain.funcionalidades;
//Opción de menú 7
import UIMain.OpcionDeMenu;
import BaseDatos.Data;
import gestorAplicacion.Animales.Mascota;
import gestorAplicacion.prestacion.Clinica;

import java.util.Scanner;
public class HospitalizarMascota extends OpcionDeMenu{
    Scanner entrada = new Scanner (System.in);

    public void ejecutar(){

        System.out.println("Ingresar el Id de la mascota que se va a hospitalizar");
        int id = entrada.nextInt();
        Mascota mascota = (Mascota) Data.mascotas.get(id);
        Clinica.hospitalizarMascota(mascota);


    }

    public String toString(){

        return "Hospitalizar Mascota";
    }
}