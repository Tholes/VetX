package gestorAplicacion.Usuarios;

public class Veterinario extends Persona {

    private static int cantidadVeterinarios;
    private String especialidad;
    private byte experiencia;
    private int sueldo;
    private final long idTarjetaProfesional;

    public Veterinario(String nombre, String email, String direccion, String ciudad , Long telefono ,String especialidad, byte experiencia, int sueldo, long idTarjetaProfesional) {
        super(nombre,email,direccion,ciudad,telefono);
        this.especialidad = especialidad;
        this.experiencia = experiencia;
        this.sueldo = sueldo;
        cantidadVeterinarios++;
        this.idTarjetaProfesional = idTarjetaProfesional;

    }

    public Veterinario(String nombre, String email, String direccion, String ciudad, long telefono, String especialidad, byte experiencia, long idTarjetaProfesional) {
        this(nombre, email, direccion,ciudad,telefono,"general", experiencia, 828116, idTarjetaProfesional);
    }

    public static int getCantidadVeterinarios() {
        return cantidadVeterinarios;
    }

    public long getIdProfesional() {
        return idTarjetaProfesional;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(byte experiencia) {
        this.experiencia = experiencia;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public String toString() {
        return "Soy " + super.getNombre() + " mi email es: " + super.getEmail() + " vivo en: " + super.getDireccion() + " mi especialidad es: " + especialidad + " tengo " + experiencia + " años de experiencia";
    }
}
