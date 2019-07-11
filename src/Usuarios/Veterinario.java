package Usuarios;

public class Veterinario extends Persona {//Herencia de clase Persona, habría que cambiar muchas cosas abajo
    // pero serviría para reducir líneas de código, 
    //y no sobreescribir tantos setters y getters

    private static int cantidadVeterinarios;
    private String especialidad;
    private byte experiencia;
    private int sueldo;
    private final long idTarjetaProfesional;

    /*
    El constructor de veterinario en caso de no contener el cargo, será tomado cómo un médico GENERAL y su sueldo será un SMMLV 
    puede estar sujeto a cambios ya que son muchos parametros.
    Recibe la tarjeta profesional cómo un long para que el tipo de dato sea diferente.
    Recibe la experiencia cómo un byte para variar un poco el tipo de dato.
     */
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
        return "Soy " + nombre + " mi email es: " + email + " vivo en: " + direccion + " mi especialidad es: " + especialidad + " tengo " + experiencia + " años de experiencia";
    }
}
