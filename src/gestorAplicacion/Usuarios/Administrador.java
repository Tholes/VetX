package gestorAplicacion.Usuarios;

public class Administrador extends Persona {

    public Administrador(String nombre, String email, String usuario, String contraseña){
        super(nombre, email, usuario, contraseña);
    }
    
    public void asignarConsultorio(Veterinario vet){
        // ¿Tenemos consultarios?
    }
    
    public void contratarVeterianrio(){
        
    }
    
    public void aprobarCitas(){
        //Aquí creariamos los objetos de las clases citas
    }

    //Al pedir una cita, el administrador le va a asignar un veterinario a esa cita.

}
