package UIMain;

import BaseDatos.Data;
import UIMain.funcionalidades.*;
import gestorAplicacion.Usuarios.Persona;


import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    private static Persona usuarioActivo;
    private static MenuDeConsola menu;


    public static void main(String[] args){
        inicializarDatos();
        menu.getMenuUsuario();
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
