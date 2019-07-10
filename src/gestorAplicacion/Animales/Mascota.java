package gestorAplicacion.Animales;

import java.util.Date;
import Usuarios.*;

public class Mascota {

    private static int cantidadPacientes;
    private int id;
    private String nombre;
    private String raza;
    private String sexo;
    private Date fechaNacimiento;
    private Cliente dueño;
    private boolean estado;
    
    public Mascota(String nombre, String raza, String sexo, Cliente amo, Date fechaNacimiento){
        this.nombre = nombre;
        this.raza = raza;
        this.sexo = sexo;
        dueño = amo;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Cliente getDueño() {
        return dueño;
    }

    public void setDueño(Cliente dueño) {
        this.dueño = dueño;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public String toString(){
        return "Mi nombre es "+nombre+" soy un/a "+raza+" soy de sexo: "+sexo+" nací el "+fechaNacimiento+" mi dueño es: "+dueño.getNombre();
    }

}
