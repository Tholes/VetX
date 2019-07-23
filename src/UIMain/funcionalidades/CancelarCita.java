package UIMain.funcionalidades;
//Opción de menú 2
import BaseDatos.Data;
import UIMain.OpcionDeMenu;
import gestorAplicacion.Usuarios.Cliente;
import gestorAplicacion.prestacion.Cita;

import java.util.Scanner;

public class CancelarCita extends OpcionDeMenu{
    Scanner in = new Scanner(System.in);
    public void ejecutar(){
        System.out.println("POR FAVOR INGRESAR USUARIO ");
        String nombreUsuario = in.nextLine();
        Cliente cliente = (Cliente) Data.usuarios.get(nombreUsuario);
        if(cliente.getCitasAsignadas().isEmpty()==true){
            System.out.println("No tenia citas");
        }else{

            System.out.println("Cita Cancelada");
        }
    }

    public String toString(){
        return "Cancelar Cita";
    }

}