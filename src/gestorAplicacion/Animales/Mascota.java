package gestorAplicacion.Animales;

import gestorAplicacion.Usuarios.*;
import gestorAplicacion.prestacion.*;

import java.util.HashMap;

public class Mascota {
    /*
     * Cada clase tendrá una lista estatica donde se almacenarán los objetos creados de esta clase
     * */
    public static HashMap<Integer,Mascota > mascotas = new HashMap<>();
    private static int cantidadPacientes;
    private int id;
    private String nombre;
    private String raza;
    private String especie;
    private char sexo; //valores definidos de M/H (Macho/Hembra)
    private String fechaNacimiento;
    private Cliente amo;
    private boolean estado;
    private Clinica clinica;

    public Mascota(String nombre, String fechaNacimiento, char sexo , String especie, String raza, Cliente amo){
        this.nombre = nombre;
        this.raza = raza;
        this.sexo = sexo;
        this.amo = amo;
        this.especie = especie;
        this.fechaNacimiento = fechaNacimiento;
        cantidadPacientes++;
        this.id = cantidadPacientes;
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

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo){
        this.sexo = sexo;
    }

    public String getEspecie() {
        return especie;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Cliente getAmo() {
        return amo;
    }

    public void setAmo(Cliente amo) {
        this.amo = amo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado, Clinica clinica) {
        this.estado = estado;
        this.clinica = clinica;
    }

    public void eliminarMascota() throws Throwable{
        mascotas.remove(id);
        this.finalize();
    }

    @Override
    public String toString(){
        return "Nombre: "+nombre+", especie: "+ especie;
    }

    public static HashMap<Integer, Mascota> getMascotas() {
        return mascotas;
    }

    public static void setMascotas(HashMap<Integer, Mascota> mascotas) {
        Mascota.mascotas = mascotas;
    }

    public static void registrarNuevaMascota(Mascota mascota){
        mascotas.put(mascota.getId(),mascota);
    }
}
