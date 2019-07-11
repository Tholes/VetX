package gestorAplicacion.prestacion;
import java.util.ArrayList;
import gestorAplicacion.Usuarios.Veterinario;
import java.util.Date;
public class Cita {
    private Date fechaCita;
    private Veterinario veterinario;
    private static ArrayList<Date> disponibilidad; 

    public Cita(Date fechaCita, Veterinario veterinario, ArrayList<Date> disponibilidad) {
        this.fechaCita = fechaCita;
        this.veterinario = veterinario;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public static ArrayList<Date> getDisponibilidad() {
        return disponibilidad;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    
    public void setDisponibilidad(ArrayList<Date> disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
}
