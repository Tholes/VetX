package UIMain.funcionalidades;
//Opción de menú 5
import UIMain.OpcionDeMenu;
import java.util.Scanner;

import static BaseDatos.Data.hospitalizados;

public class DarDeAlta extends OpcionDeMenu{
    Scanner in = new Scanner(System.in);
    public void ejecutar(){
        System.out.println("Ingrese Id de la mascota hospitalizada: ");
        int id = in.nextInt();
        if(hospitalizados.containsKey(id)){
            hospitalizados.remove(id);
        }
        else{
            System.out.println("Id(Identificación) de la mascota no encontrado");
        }

    }

    public String toString(){
        return "Dar de alta";
    }
}