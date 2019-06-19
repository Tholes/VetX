package servicio;
import java.util.ArrayList;
import seresVivientes.*;
import java.util.Date;
public class Cita {
    private Date fechaCita;
    private Veterinario veterinario;
    private ArrayList<Date> disponibilidad;

    public Cita(Date fechaCita, Veterinario veterinario, ArrayList<Date> disponibilidad) {
        this.fechaCita = fechaCita;
        this.veterinario = veterinario;
        this.disponibilidad = disponibilidad;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public ArrayList<Date> getDisponibilidad() {
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
