package UIMain;

import BaseDatos.Data;
import UIMain.funcionalidades.*;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import gestorAplicacion.Usuarios.Persona;
import java.io.IOException;
import java.util.ArrayList;


public class Main {

    private static Persona usuarioActivo;
    private static MenuDeConsola menu;
    private static MenuDeConsola menuPorDefecto;
    public static void main(String[] args) throws IOException, Throwable {
        System.out.println("BIENVENIDO A NUESTRA CLÍNICA!");
        System.out.println("GRACIAS POR PREFERIR NUESTROS SERVICIOS.");
        System.out.println("POR FAVOR ELIGE UNA DE LAS SIGUIENTES OPCIONES: ");
        System.out.println("");
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
