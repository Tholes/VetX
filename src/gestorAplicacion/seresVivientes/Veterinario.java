package gestorAplicacion.seresVivientes;
public class Veterinario {
    
    private static int cantidadVeterinarios;
    private int id;
    private String nombre;
    private String email;
    private String direccion;
    private String cargo;
    private String especialidad;
    private int experiencia;
    private int sueldo;
    
    /*
    El constructor de veterinario en caso de no contener el cargo, será tomado cómo un médico GENERAL, puede estar sujeto a cambios
    ya que son muchos parametros.
    En caso de no contener el sueldo, daremos por sentado que se gana un mínimo, no estoy seguro de ambos constructores, ya que pueden generar errores.
    */
    
    public Veterinario(String nombre, String email, String direccion ,String cargo, String especialidad, int experiencia, int sueldo){
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.cargo = cargo;
        this.especialidad = especialidad;
        this.experiencia = experiencia;
        this.sueldo = sueldo;
        cantidadVeterinarios++;
        this.id = cantidadVeterinarios;
    }
    
    public Veterinario(String nombre, String email, String direccion ,String cargo, int experiencia, int sueldo){
        this(nombre,email,direccion,cargo,"general",experiencia,sueldo);
    }
    public Veterinario(String nombre, String email, String direccion ,String cargo,String especialidad, int experiencia){
        this(nombre,email, direccion, cargo, especialidad, experiencia,828116);
    }
    
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
    
    public String toString(){
        return "Soy "+nombre+" mi email es: "+email+ " vivo en: "+direccion + " mi cargo es: "+ cargo+" tengo "+experiencia+" años de experiencia";
    }
}
