package gestorAplicacion.prestacion;

import java.util.ArrayList;

import BaseDatos.Data;
import gestorAplicacion.Animales.Mascota;

public class Clinica {
    
    private String nombreClinica;
    private String direccion;
    private long telefono;
    private long nit;
    private String comentarios;
    private String redesSociales;
    private static ArrayList<Mascota> mascotasHospitalizadas = new ArrayList<>();

    public String getNombre() {
        return nombreClinica;
    }

    public void setNombre(String nombre) {
        this.nombreClinica = nombre;
    }
    
    public String getDireccion(){
        return direccion;
    }
    
    public void setDireccion(String dir){
        this.direccion = dir;
    }
    
    public long getTelefono(){
        return telefono;
    }
    
    public void setTelefono(long tel){
        this.telefono = tel;
    }
    
    public long getNit(){
        return nit;
    }
    
    public void setNit(long numNit){
        this.nit = numNit;
    }
    
    public String getComentarios() {
        return comentarios;
    }

    public void setComentario(String comentario) {
        this.comentarios = comentario;
    }
    
    public String getRedes() {
        return redesSociales;
    }

    public void setRedes(String red) {
        this.redesSociales = red;
    }
    
    public static void hospitalizarMascota(Mascota mascota){
        mascotasHospitalizadas.add(mascota);
        mascota.setEstado(true, null);
        Data.hospitalizados.put(mascota.getId(), mascota);
    }

    public boolean darDeAlta(Mascota mascota){

        if(mascotasHospitalizadas.contains(mascota)){
            mascota.setEstado(false, null);
            mascotasHospitalizadas.remove(mascota);
            return true;
        }
        return false;
    }

}


