package gestorAplicacion.Usuarios;

public class Administrador extends Persona {

    public Administrador(String nombre, String email, String usuario, String key){
        super(nombre, email, usuario, key);
    }

    
    public void contratarVeterianrio(){
        
    }
    
    public void aprobarCitas(){
        //Aquí creariamos los objetos de las clases citas
    }

    //Al pedir una cita, el administrador le va a asignar un veterinario a esa cita.

}
