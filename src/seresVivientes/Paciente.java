package seresVivientes;

import java.util.Date;

public class Paciente {

    private int id;
    private String nombre;
    private String raza;
    private String sexo;
    private Date fechaNacimiento;
    private Cliente dueño;
    private boolean estado;
    
    public Paciente(String nombre, String raza, String sexo, Cliente amo){
        this.nombre = nombre;
        this.raza = raza;
        this.sexo = sexo;
        dueño = amo;
    }
    
    public Paciente(String nombre, String raza, Cliente amo){
        this(nombre,raza,"NN",amo);
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

}
