package UIMain.funcionalidades;
import UIMain.OpcionDeMenu;
import modelo.gestorAplicacion.Usuarios.Veterinario;


public class SueldoVeterinarios extends OpcionDeMenu {
    @Override
    public void ejecutar() {
        System.out.println("*** La nomina por mes de los veterinario es: " + Veterinario.sueldototal + " pesos por mes");
    }

    @Override
    public String toString() {
        return "Nomina de veterinarios.";
    }
}
