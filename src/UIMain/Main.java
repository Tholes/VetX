package UIMain;

import BaseDatos.Data;
import UIMain.funcionalidades.*;
import gestorAplicacion.Usuarios.Persona;
import gestorAplicacion.Usuarios.Veterinario;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;


public class Main {

    private static Persona usuarioActivo;
    private static MenuDeConsola menu;
    private static MenuDeConsola menuPorDefecto;
    public static void main(String[] args) throws IOException {
        inicializarDatos();
        while(true){
            try{
                if(Main.usuarioActivo != null){
                    menu = new MenuDeConsola(usuarioActivo);
                    menu.lanzarMenu();
                }
                else {
                    menuPorDefecto.lanzarMenu();
                }
            }

            catch (Exception e){
                System.out.println(e);
                Data.guardarDatos();
                System.out.println("Saliendo...");
                System.exit(0);
            }
        }
    }

    public static void inicializarDatos(){
        Data.cargarDatos();

        ArrayList<OpcionDeMenu> opcionesInvitado = new ArrayList<OpcionDeMenu>(){{
            add(new IniciarSesion());
            add(new Registrarse());
            add(new SalirDeLaAplicacion());
        }};
        menuPorDefecto = (new MenuDeConsola(opcionesInvitado));
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
