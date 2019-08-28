package UIMain;

import UIMain.funcionalidades.*;

import vista.VentanaPrincipal;
import modelo.gestorAplicacion.Usuarios.Persona;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    private static Persona usuarioActivo;
    private static MenuDeConsola menu;
    private static MenuDeConsola menuPorDefecto;
    public static VentanaPrincipal ventanaLogin = new VentanaPrincipal();
    public static void main(String[] args) throws IOException, Throwable {

    }
    public static Persona getUsuarioActivo() {
        return usuarioActivo;
    }

    public static void setUsuarioActivo(Persona usuario) {
        usuarioActivo = usuario;
    }

    public static MenuDeConsola getMenu() {
        return menu;
    }
}
