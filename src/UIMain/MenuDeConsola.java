
package UIMain;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


import BaseDatos.Data;
import UIMain.funcionalidades.*;
import gestorAplicacion.Usuarios.Administrador;
import gestorAplicacion.Usuarios.Cliente;
import gestorAplicacion.Usuarios.Persona;
import gestorAplicacion.Usuarios.Veterinario;

public class MenuDeConsola {

    public static HashMap<Integer,OpcionDeMenu> listaOpciones = new HashMap<Integer,OpcionDeMenu>(){{
        put(1, new IniciarSesion());
        put(2, new VerDisponibilidad());
        put(3, new PedirCita());
        put(4, new CambiarFechaCita());
        put(5, new CancelarCita());
        put(6, new SueldoVeterinarios());
        put(7, new ContratarVeterinario());
        put(8, new ListadoMascotas());
        put(9, new RegistrarMascota());
        put(10, new HospitalizarMascota());
        put(11, new DarDeAlta());
        put(12, new DarPermisos());
        put(13, new Registrarse());
        put(14, new CerrarSesion());
        put(15, new SalirDeLaAplicacion());
    }};

    private Persona usuario;
    public ArrayList<OpcionDeMenu> menuUsuario = new ArrayList<>();

    public MenuDeConsola(Persona usuario, ArrayList<Integer> menu){
        this.usuario = usuario;
        for (int i = 0; i < menu.size(); i++) {
                menuUsuario.add(listaOpciones.get(menu.get(i)));
        }
    }


    public MenuDeConsola(Persona cliente){

        if(cliente instanceof Cliente){
            ArrayList<Integer> indiceOpciones = Data.menuCliente;
            for (int i = 0; i <indiceOpciones.size() ; i++) {
                menuUsuario.add(listaOpciones.get(indiceOpciones.get(i)));
            }
        }

        else if(cliente instanceof Veterinario){
            ArrayList<Integer> indiceOpciones = Data.menuVeterinario;
            for (int i = 0; i <indiceOpciones.size() ; i++) {
                menuUsuario.add(listaOpciones.get(indiceOpciones.get(i)));
            }
        }

        else if(cliente instanceof Administrador){
            ArrayList<Integer> indiceOpciones = Data.menuAdministrador;
            for (int i = 0; i < indiceOpciones.size() ; i++) {
                menuUsuario.add(listaOpciones.get(indiceOpciones.get(i)));
            }
        }

    }

    public MenuDeConsola(ArrayList<OpcionDeMenu> menu){
        this.menuUsuario = menu;
    }

    public ArrayList<OpcionDeMenu> getMenuUsuario() {
        return menuUsuario;
    }

    public Persona getUsuario() {
        return usuario;
    }

    public void setUsuario(Persona usuario) {
        this.usuario = usuario;
    }

    public void lanzarMenu() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Menu: ");
        for (int i = 0;i < menuUsuario.size(); i++) {
            System.out.println((i+1)+". "+menuUsuario.get(i));
        }
        System.out.print("Ingrese una opción: ");
        int opcion = in.nextInt();
        menuUsuario.get((opcion-1)).ejecutar();
    }
    
    public void verOpciones(){
        System.out.println("Opciones de Menu: ");
        for (int i = 0; i < menuUsuario.size(); i++) {
            System.out.println((i+1)+" "+menuUsuario.get(i));
        }
    }

}