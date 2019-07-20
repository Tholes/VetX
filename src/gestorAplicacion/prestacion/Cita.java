package gestorAplicacion.prestacion;
import java.util.ArrayList;
import java.util.Date;
import gestorAplicacion.Usuarios.*;

public class Cita {
    private Date fechaCita;
    private Veterinario veterinario;
    private Cliente cliente;
    private static ArrayList<Date> disponibilidad; 
    private Procedimiento procedimiento;

    public Cita(Date fechaCita, Veterinario veterinario, Cliente cliente) {
        this.fechaCita = fechaCita;
        this.veterinario = veterinario;
        this.cliente = cliente;
        actualizarDisponibilidad(fechaCita);
    }

    public static void actualizarDisponibilidad(Date fechaCita){
        disponibilidad.remove(fechaCita);
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public static String getDisponibilidad() {
        
        String ans = "----------------------------------------------------------\n";
        for (int i = 0; i < disponibilidad.size() ; i++) {
            int year = disponibilidad.get(i).getYear();
            int mes = disponibilidad.get(i).getMonth();
            int dia = disponibilidad.get(i).getDay();
            ans += year+"/"+mes+"/"+dia +"\n";
        }
        ans += "----------------------------------------------------------\n";
        return ans;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public boolean nuevaFechaCita(Date fecha){
        if(disponibilidad.contains(fecha)){
            disponibilidad.add(fechaCita);
            disponibilidad.remove(fecha);
            fechaCita = fecha;    
            return true;
        }
        return false;
    }
    
    public void cancelarCita() throws Throwable{
        this.finalize();
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public static void setDisponibilidad(ArrayList<Date> nuevasFechas) {
        disponibilidad = nuevasFechas;
    }

    @Override
    public String toString(){
        String ans;
        ans = "Sr "+cliente.getNombre()+" informaci�n sobre su cita:\n";
        ans += "Fecha: "+fechaCita.getYear()+"/"+fechaCita.getMonth()+"/"+fechaCita.getDay()+"\n";
        ans += "Veterinario: " + veterinario.toString()+"\n";
        return ans;
    }

}
