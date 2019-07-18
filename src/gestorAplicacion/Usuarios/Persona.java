package gestorAplicacion.Usuarios;
import gestorAplicacion.Animales.*;
import gestorAplicacion.prestacion.*;
import java.util.Date;
public class Persona {

    private int id;
    private String nombre;
    private String email;
    private String key;
    private String direccion;
    private String ciudad;
    private long telefono;

    //Usuarios invitados.
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

    public void registrarMascota(String nombre,Date fechaNacimiento ,char sexo, String especie, String raza, Cliente cliente){
        Mascota mascota = new Mascota(nombre, fechaNacimiento, sexo, especie, raza, cliente);
        cliente.setMascota(mascota);

    }

    public boolean borrarMascota(Mascota mascota, Cliente cliente) throws Throwable {
        if(cliente.getMascotas().contains(mascota)){
            cliente.borrarMascota(mascota);
            return true;
        }
        return false;
    }

    public boolean pedirCita(int year,int mes, int dia){  
        Date fecha = new Date(year,mes,dia); 
        if(Cita.getDisponibilidad().contains((CharSequence) fecha)){
            return true;
        }
        return false;
    }

    public boolean cancelarCita(Cita cita, Cliente cliente) throws Throwable {
        if(cliente.getCitasAsignadas().contains(cita)){
            cliente.getCitasAsignadas().remove(cita);
            cita.cancelarCita();
            return true;
        }
        return false;
    }

}
