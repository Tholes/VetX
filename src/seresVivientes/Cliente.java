package seresVivientes;

public class Cliente {

    private int id;
    private String nombre;
    private String email;
    private String direccion;
    private String ciudad;
    private long telefono;
    private Paciente mascota;

    public int getId() {
        return id;
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

    public Paciente getMascota() {
        return mascota;
    }

    public void setMascota(Paciente mascota) {
        this.mascota = mascota;
    }
    
}
