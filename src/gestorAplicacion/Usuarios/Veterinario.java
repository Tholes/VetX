package gestorAplicacion.Usuarios;

import java.util.ArrayList;

import BaseDatos.Data;
import UIMain.Main;
import UIMain.MenuDeConsola;
import gestorAplicacion.prestacion.Cita;

public class Veterinario extends Persona {
    /*
     * Cada clase tendrá una lista estatica donde se almacenarán los objetos creados de esta clase
     * */
    public static  ArrayList<Integer> menuVeterinario = new ArrayList<>();
    public ArrayList<Integer> menuPersonal = new ArrayList<>();
    public static ArrayList<Veterinario> veterinarios =new ArrayList<>();
    private static int cantidadVeterinarios;
    private String especialidad;
    private byte experiencia;
    private int sueldo;
    private long idTarjetaProfesional;
    public ArrayList<Cita> citasAsignadas = new ArrayList<Cita>();
    public static long sueldototal = 0;

    public Veterinario(){
        super();
    }

    public Veterinario(String nombre, String email, String especialidad, byte experiencia, int sueldo, long idTarjetaProfesional,String usuario, String key) {
        super(nombre,email,usuario,key);
        this.especialidad = especialidad;
        this.experiencia = experiencia;
        this.sueldo = sueldo;
        cantidadVeterinarios++;
        sueldototal = sueldototal + sueldo;
        this.idTarjetaProfesional = idTarjetaProfesional;
    }

    /*
    Cómo no todos los veterinarios tienen una especialidad, los consideraremos cómo generales
    y ganan un sueldo mínimo
    */

    public Veterinario(String nombre, String email, byte experiencia, long idTarjetaProfesional, String usuario, String contraseña) {
        this(nombre, email,"general", experiencia, 828116, idTarjetaProfesional,usuario,contraseña);
    }

    public boolean fechaCitaDisponible(String fecha){
        for (int i = 0; i < citasAsignadas.size(); i++) {
            if(citasAsignadas.get(i).getFechaCita().equals(fecha)){
                return true;
            }
        }
        return false;
    }

    public static Veterinario veterinarioDisponible(String fecha){
        for(int i=0;i<veterinarios.size();i++){
            if(!veterinarios.get(i).fechaCitaDisponible(fecha)){
                return veterinarios.get(i);
            }
        }return null;
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

    public void eliminarCita(Cita cita){
        if(citasAsignadas.contains(cita)){
            citasAsignadas.remove(cita);
        }
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
        return "Soy " + super.getNombre() + " mi email es: " + super.getEmail() + " mi especialidad es: " + especialidad + " tengo " + experiencia + " años de experiencia";
    }

    public static String registrarse(String nombre, String email, String especialidad, byte experiencia, int sueldo, long idTarjetaProfesional,String usuario, String key) {
        if(!usuarios.containsKey(usuario)){
            Veterinario vet = new Veterinario(nombre,email,especialidad,experiencia,sueldo,idTarjetaProfesional,usuario,key);
            usuarios.put(usuario,vet);
            Main.setUsuarioActivo(vet);
            return "Registro completo.\n";
        }
        return "Nombre de usuario existente";
    }

    public static MenuDeConsola getMenu(Veterinario veterinario){
        ArrayList<Integer> indiceOpciones = menuVeterinario;
        MenuDeConsola menuUsuario = new MenuDeConsola(veterinario,indiceOpciones);
        return menuUsuario;
    }

    public void eliminarme() throws Throwable {
        citasAsignadas.clear();
        super.eliminarme();
    }

    public static ArrayList<Integer> getMenuVeterinario() {
        return menuVeterinario;
    }

    public static void setMenuVeterinario(ArrayList<Integer> menuVeterinario) {
        Veterinario.menuVeterinario = menuVeterinario;
    }

    public ArrayList<Integer> getMenuPersonal() {
        return menuPersonal;
    }

    public void setMenuPersonal(ArrayList<Integer> menuPersonal) {
        this.menuPersonal = menuPersonal;
    }

    public static ArrayList<Veterinario> getVeterinarios() {
        return veterinarios;
    }

    public static void setVeterinarios(ArrayList<Veterinario> veterinarios) {
        Veterinario.veterinarios = veterinarios;
    }
}
