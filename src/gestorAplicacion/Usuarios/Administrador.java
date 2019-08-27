package gestorAplicacion.Usuarios;

import BaseDatos.Data;
import UIMain.Main;

import java.util.ArrayList;


public class Administrador extends Persona {

    /*
     * Cada clase tendrá una lista estatica donde se almacenarán los objetos creados de esta clase
     * */
    public static ArrayList<Integer> menuAdministrador = new ArrayList<>();
    public ArrayList<Integer> menuPersonal = new ArrayList<>();

    public Administrador(){

    }
    public Administrador(String nombre, String email, String usuario, String key){
        super(nombre, email, usuario, key);
    }

    public static void contratarVeterinario(String nombre, String email, String especialidad, byte experiencia, int sueldo, long idtarjetaProfesional, String usuario, String key){

        Veterinario nuevoVeterinario = new Veterinario(nombre, email, especialidad, experiencia, sueldo, idtarjetaProfesional, usuario, key) ;
        usuarios.put(usuario, nuevoVeterinario);

    }

    public static void registrarAdministrador(String nombre, String email, String usuario, String key){
        Administrador admin = new Administrador(nombre, email, usuario, key);
        //Asignarle el menú de Administrador (Data.menuAdministrador)
        usuarios.put(usuario,admin);
    }

    public static void eliminarCuenta(String usuario) throws Throwable{
        Persona persona = Persona.fromUsuarioGetPersona(usuario);
        usuarios.remove(usuario);
        persona.borrarMiCuenta();
    }
    
    public String registrarse(String nombre, String email, String usuario,String key) {

        if(!usuarios.containsKey(usuario)){
            Administrador admin = new Administrador(nombre,email,usuario,key);
            usuarios.put(usuario,admin);
            menuPersonal = getMenuAdministrador();
            Main.setUsuarioActivo(admin);
            return "Registro completo.";
        }
        return "Nombre de usuario existente";
    }

    @Override
    public String toString() {
        return "Administrador{} " + super.toString();
    }

    public static ArrayList<Integer> getMenuAdministrador() {
        return menuAdministrador;
    }

    public static void setMenuAdministrador(ArrayList<Integer> menuAdministrador) {
        Administrador.menuAdministrador = menuAdministrador;
    }

    public ArrayList<Integer> getMenuPersonal() {
        return menuPersonal;
    }

    public void setMenuPersonal(ArrayList<Integer> menuPersonal) {
        this.menuPersonal = menuPersonal;
    }
}
