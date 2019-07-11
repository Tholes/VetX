package gestorAplicacion.Usuarios;

public class Persona {

    private int id;
    private String nombre;
    private String email;
    private String contraseña;
    private String direccion;
    private String ciudad;
    private long telefono;

    //Necesitamos un constructor por defecto, para los usuarios invitados.
    public Persona(){
        
    }

    public Persona(String nombre, String email,String direccion, String ciudad, Long telefono){
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

}
