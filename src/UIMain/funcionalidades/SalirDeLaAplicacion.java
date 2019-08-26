package UIMain.funcionalidades;

import BaseDatos.Data;
import UIMain.OpcionDeMenu;

import java.io.IOException;

public class SalirDeLaAplicacion extends OpcionDeMenu {

    @Override
    public void ejecutar() throws IOException {
        Data guardar = new Data();
        guardar.guardarDatos();
        System.out.println("Saliendo...");
        System.exit(0);
    }

    @Override
    public String toString() {
        return "Salir de la aplicación.";
    }
}
