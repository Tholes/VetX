package gestorAplicacion.prestacion;
import java.util.ArrayList;


import BaseDatos.Data;
import gestorAplicacion.Animales.Mascota;
import gestorAplicacion.Usuarios.*;

public class Cita {
    private static int cantidadCitas;
    private String fechaCita;
    private Veterinario veterinario;
    private Cliente cliente;
    private static ArrayList<String> disponibilidad = new ArrayList<>();
    private int id;
    private Mascota mascota;

    public Cita(String fechaCita, Veterinario veterinario, Cliente cliente, Mascota mascota) {
        this.fechaCita = fechaCita;
        this.veterinario = veterinario;
        this.cliente = cliente;
        this.mascota = mascota;
        actualizarDisponibilidad(fechaCita);
        cantidadCitas++;
        this.id = cantidadCitas;
    }

    public static void actualizarDisponibilidad(String fecha){
        disponibilidad.add(fecha);
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public static String getDisponibilidad() {
        String ans = "--------------------- FECHAS NO DISPONIBLES ------------------------------\n";
        for (int i = 0; i < disponibilidad.size() ; i++) {
            ans += (i+1)+" "+disponibilidad.get(i) +"\n";
        }
        ans += "--------------------------------------------------------------------------\n";
        return ans;
    }

    public static boolean getDisponibilidad(String fechaCita) {
        return disponibilidad.contains(fechaCita);
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public void cancelarCita() throws Throwable{
        Data.citas.remove(id);
        this.finalize();
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public static void setDisponibilidad(ArrayList<String> nuevasFechas) {
        disponibilidad = nuevasFechas;
    }

    @Override
    public String toString(){
        String ans;
        ans = "Sr "+cliente.getNombre()+" información sobre su cita:\n";
        ans += "Fecha: "+fechaCita+"\n";
        ans += "Mascota: "+mascota.getNombre()+"\n";
        ans += "Veterinario: " + veterinario.getNombre()+"\n";
        return ans;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public boolean aprobarCita(String fecha){
        return veterinario.fechaCitaDisponible(fecha);
    }

    public void cambiarCita(String fecha, Veterinario vet){
        disponibilidad.remove(fechaCita);
        vet.eliminarCita(this);
        this.fechaCita = fecha;
        this.veterinario = vet;
        vet.asignarCita(this);
        actualizarDisponibilidad(fecha);
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public static void nuevaCita(String fechaCita, Veterinario veterinario, Cliente cliente, Mascota mascota){
        Cita cita = new Cita(fechaCita, veterinario, cliente, mascota);
        veterinario.asignarCita(cita);
        cliente.setCita(cita,mascota);
        Data.citas.put(cita.getId(),cita);
    }

}
