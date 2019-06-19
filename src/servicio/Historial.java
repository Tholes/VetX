package servicio;
import seresVivientes.*;
import java.util.ArrayList;
import finanzas.*;
import java.util.Date;
public class Historial {
    private int id;
    //private  Paciente mascota;
    private ArrayList<Procedimiento>procedimiento=new ArrayList<>();
    private Date fechaConsulta;
    private ArrayList<Veterinario>veterinario=new ArrayList<>();

    public Historial(int id, Date fechaConsulta) {
        this.id = id;
        this.fechaConsulta = fechaConsulta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Procedimiento> getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(ArrayList<Procedimiento> procedimiento) {
        this.procedimiento = procedimiento;
    }

    public Date getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public ArrayList<Veterinario> getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(ArrayList<Veterinario> veterinario) {
        this.veterinario = veterinario;
    }
}
