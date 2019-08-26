package gestorAplicacion.prestacion;

import java.util.ArrayList;
import java.util.HashMap;

import BaseDatos.Data;
import gestorAplicacion.Animales.Mascota;

public class Clinica {

    /*
     * Cada clase tendrá una lista estatica donde se almacenarán los objetos creados de esta clase
     * */
    private String nombreClinica;
    private String direccion;
    private long telefono;
    private long nit;
    private String comentarios;
    private String redesSociales;
    public static HashMap<Integer,Mascota> mascotasHospitalizadas = new HashMap<>();

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
        mascotasHospitalizadas.put(mascota.getId(),mascota);
        mascota.setEstado(true, null);
    }

    public static void darDeAlta(Mascota mascota){
        if(mascotasHospitalizadas.containsValue(mascota)){
            mascota.setEstado(false, null);
            mascotasHospitalizadas.remove(mascota);
        }
    }

    public static String mascotasEnfermas(){
        if(mascotasHospitalizadas.size() == 0){
            return "No hay mascotas hospitalizadas.";
        }else {
            String ans =  "********************* Mascotas hospitalizadas ************\n";
            for (int i = 0; i < mascotasHospitalizadas.size(); i++) {
                ans += (i+1)+" "+ mascotasHospitalizadas.get(i)+"\n";
            }
            ans += "*************************************************";
            return ans;
        }

    }

    public static HashMap<Integer, Mascota> getMascotasHospitalizadas() {
        return mascotasHospitalizadas;
    }

    public static void setMascotasHospitalizadas(HashMap<Integer, Mascota> mascotasHospitalizadas) {
        Clinica.mascotasHospitalizadas = mascotasHospitalizadas;
    }
}


