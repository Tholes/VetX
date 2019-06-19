package seresVivientes;

import java.util.ArrayList;
import finanzas.*;

public class Cliente {

    private int id;
    private String nombre;
    private String email;
    private String direccion;
    private String ciudad;
    private long telefono;
    private ArrayList<Paciente> Mascotas = new ArrayList<>();
    private ArrayList<Servicio> pagoServicio = new ArrayList<>();

    public Cliente(String nombre, String email, String direccion, long telefono) {
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Cliente(String nombre, String email, String direccion) {
        this(nombre, email, direccion, 0);
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

    public ArrayList<Paciente> getMascotas() {
        return Mascotas;
    }

    public void setMascotas(ArrayList<Paciente> Mascotas) {
        this.Mascotas = Mascotas;
    }

    public ArrayList<Servicio> getPagoServicio() {
        return pagoServicio;
    }

    public void setPagoServicio(ArrayList<Servicio> pagoServicio) {
        this.pagoServicio = pagoServicio;
    }

}
