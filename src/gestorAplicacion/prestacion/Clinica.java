package gestorAplicacion.prestacion;


public class Clinica {
    
    private String nombreClinica;
    private String direccion;
    private long telefono;
    private long nit;
    private String comentarios;
    private String redesSociales;
       
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
    
}


