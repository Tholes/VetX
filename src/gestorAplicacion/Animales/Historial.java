package gestorAplicacion.Animales;
import java.util.Date;

public class Historial{
    
    private int codigo;
    private String observaciones;
    private Date fecha;
    
    public int getCogido(){
        return codigo;
    }
    
    public void setCodigo(int cod){
        this.codigo = cod;
    }
    
    public String getObservaciones(){
        return observaciones;   
    }
    
    public void setObservaciones(String observacion){
        this.observaciones = observacion;
    }
    
    public Date getFecha() {
        return fecha;
    }

    public void setFechaNacimiento(Date fechaObservacion) {
        this.fecha = fechaObservacion;
    }
    
    
}
