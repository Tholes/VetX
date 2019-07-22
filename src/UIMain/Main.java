package UIMain;

import BaseDatos.Data;
import UIMain.funcionalidades.*;
import gestorAplicacion.Usuarios.Administrador;
import gestorAplicacion.Usuarios.Cliente;
import gestorAplicacion.Usuarios.Persona;
import gestorAplicacion.Usuarios.Veterinario;


import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    private static Persona usuarioActivo;
    private static MenuDeConsola menu;

    public static void main(String[] args) throws IOException {
        inicializarDatos();
        menu = new MenuDeConsola(new Veterinario());
        menu.lanzarMenu();
    }

    public static void inicializarDatos(){
        Data.cargarDatos();

        ArrayList<OpcionDeMenu> opcionesInvitado = new ArrayList<OpcionDeMenu>(){{
            add(new IniciarSesion());
            add(new Registrarse());
            add(new SalirDeLaAplicacion());
        }};
        menu = (new MenuDeConsola(opcionesInvitado));
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

    public static void setMenu(MenuDeConsola menuA) {
        menu = menuA;
    }
}