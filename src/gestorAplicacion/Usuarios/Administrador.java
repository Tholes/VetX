package gestorAplicacion.Usuarios;

import BaseDatos.Data;
import UIMain.Main;


public class Administrador extends Persona {


    public Administrador(){

    }
    public Administrador(String nombre, String email, String usuario, String key){
        super(nombre, email, usuario, key);
    }

    public static void contratarVeterinario(String nombre, String email, String especialidad, byte experiencia, int sueldo, long idtarjetaProfesional, String usuario, String key){

        Veterinario nuevoVeterinario = new Veterinario(nombre, email, especialidad, experiencia, sueldo, idtarjetaProfesional, usuario, key) ;
        Data.usuarios.put(usuario, nuevoVeterinario);

    }

    public static void registrarAdministrador(String nombre, String email, String usuario, String key){
        Administrador admin = new Administrador(nombre, email, usuario, key);
        //Asignarle el menú de Administrador (Data.menuAdministrador)
        Data.usuarios.put(usuario,admin);
    }

    public static void eliminarCuenta(String usuario) throws Throwable{
        Persona persona = Persona.fromUsuarioGetPersona(usuario);
        Data.usuarios.remove(usuario);
        persona.borrarMiCuenta();
    }

    public static String registrarse(String nombre, String email, String usuario,String key) {

        if(!Data.usuarios.containsKey(usuario)){
            Administrador admin = new Administrador(nombre,email,usuario,key);
            Data.usuarios.put(usuario,admin);
            Main.setUsuarioActivo(admin);
            return "Registro completo.";
        }
        return "Nombre de usuario existente";
    }

    @Override
    public String toString() {
        return "Administrador{} " + super.toString();
    }
}
