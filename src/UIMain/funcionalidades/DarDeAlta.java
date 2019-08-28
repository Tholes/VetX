package UIMain.funcionalidades;
//Opción de menú 5
import UIMain.OpcionDeMenu;
import modelo.gestorAplicacion.Animales.Mascota;
import modelo.gestorAplicacion.prestacion.Clinica;

import java.util.Scanner;

public class DarDeAlta extends OpcionDeMenu{
    Scanner in = new Scanner(System.in);
    public void ejecutar(){
        System.out.println(Clinica.mascotasEnfermas());
        System.out.println("Ingresa el número de la máscota que darás de alta: \n" +
                "Escriba 'Salir' Para regresar al menú. ");
        int opcion = in.nextInt()-1;
        Mascota mascota = Clinica.getMascotasHospitalizadas().get(opcion);
        if(mascota != null){
            Clinica.darDeAlta(mascota);
            System.out.println("La mascota ha sido dada de alta");
        }
        else{
            System.out.println("Numero incorrecto");
            ejecutar();
        }


    }

    public String toString(){
        return "Dar de alta.";
    }
}