package gestorAplicacion.Usuarios;

import BaseDatos.Data;

public class Administrador extends Persona {

    public Administrador(String nombre, String email, String usuario, String key){
        super(nombre, email, usuario, key);
    }

    
    public void contratarVeterinario(){
        
    }
    
    public void aprobarCitas(){
        //Aquí creariamos los objetos de las clases citas
    }

    //Al pedir una cita, el administrador le va a asignar un veterinario a esa cita.

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
}
