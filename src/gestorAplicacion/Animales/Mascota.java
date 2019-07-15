package gestorAplicacion.Animales;

import java.util.Date;
import gestorAplicacion.Usuarios.*;
import gestorAplicacion.prestacion.*;
public class Mascota {

    private static int cantidadPacientes;
    private int id;
    private String nombre;
    private String raza;
    private String especie;
    private char sexo; //valores definidos de M/H
    private Date fechaNacimiento;
    private Cliente amo;
    private boolean estado;
    private Clinica clinica;

    public Mascota(String nombre, Date fechaNacimiento, char sexo , String especie, String raza, Cliente amo){
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
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
        this.finalize();
    }

    @Override
    public String toString(){
        return "Mi nombre es "+nombre+" soy un/a "+raza+" soy de sexo: "+sexo+" nací el "+fechaNacimiento+" mi dueño es: "+amo.getNombre();
    }

}
