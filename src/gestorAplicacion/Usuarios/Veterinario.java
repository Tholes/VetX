package gestorAplicacion.Usuarios;

import java.util.ArrayList;

import gestorAplicacion.prestacion.Cita;

public class Veterinario extends Persona {

    private static int cantidadVeterinarios;
    private String especialidad;
    private byte experiencia;
    private int sueldo;
    private final long idTarjetaProfesional;
    private ArrayList<Cita> citasAsignadas = new ArrayList<Cita>();

    public Veterinario(String nombre, String email, String direccion, String ciudad , Long telefono ,String especialidad, byte experiencia, int sueldo, long idTarjetaProfesional) {
        super(nombre,email,direccion,ciudad,telefono);
        this.especialidad = especialidad;
        this.experiencia = experiencia;
        this.sueldo = sueldo;
        cantidadVeterinarios++;
        this.idTarjetaProfesional = idTarjetaProfesional;

    }

    //Cómo no todos los veterinarios tienen una especialidad, los consideraremos cómo generales
    //y que ganan un sueldo mínimo
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

    public void asignarCita(Cita cita){
        citasAsignadas.add(cita);
    }

    public String getCitasAsignadas(){
        String ans = "----------------------------------------------------------\n";

        for(int i = 0; i<citasAsignadas.size();i++){
            ans += citasAsignadas.get(i)+"\n";
        }
        ans += "----------------------------------------------------------\n";
        
        return ans;
    }
    public String toString() {
        return "Soy " + super.getNombre() + " mi email es: " + super.getEmail() + " vivo en: " + super.getDireccion() + " mi especialidad es: " + especialidad + " tengo " + experiencia + " años de experiencia";
    }


}
