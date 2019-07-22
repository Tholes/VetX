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
        System.out.println("Ingrese id de la mascota: ");
        int id = entrada.nextInt();
        Clinica.hospitalizarMascota(Data.mascotas.get(id));

    }

    public String toString(){

        return "Hospitalizar Mascota";
    }
}