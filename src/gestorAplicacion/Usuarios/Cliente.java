package gestorAplicacion.Usuarios;

import java.util.ArrayList;

import BaseDatos.Data;
import gestorAplicacion.Animales.*;
import gestorAplicacion.prestacion.*;
import java.util.Date;
import java.util.HashMap;

public class Cliente extends Persona {

    private static int cantidadClientes;
    private final int id;
    private ArrayList<Mascota> mascotas = new ArrayList<>();
    private ArrayList<Servicio> servicios = new ArrayList<>();

    private HashMap<Cita,Mascota> citasAsignadas = new HashMap<>();

    public Cliente(String nombre, String email,String usuario ,String contraseña) {
        super(nombre,email,usuario,contraseña);
        cantidadClientes++;
        id = cantidadClientes;
    }

    public int getId() {
        return id;
    }

    public static int getCantidadClientes() {
        return cantidadClientes;
    }

    public String mascotasRegistradas() {
        String listadoMascotas = "----------------------------------------------------------\n";
        if(mascotas.size() == 0){
            listadoMascotas += "No tiene mascotas registradas\n";
            listadoMascotas += "----------------------------------------------------------\n";
            return listadoMascotas;
        }
        else if (mascotas.size() == 1) {
            listadoMascotas += "Su mascota es: \n";
            listadoMascotas += mascotas.get(0);
            listadoMascotas += "----------------------------------------------------------\n";
            return listadoMascotas;
        }
        listadoMascotas = "Sus mascotas son: \n";
        for (int i = 0; i < mascotas.size(); i++) {
            listadoMascotas += mascotas.get(i);
        }
        listadoMascotas += "----------------------------------------------------------\n";
        return listadoMascotas;
    }

    public ArrayList<Mascota> getMascotas(){
        return mascotas;
    }

    public void setMascota(Mascota Mascota) {
        mascotas.add(Mascota);
    }

    public String getServicios() {
        String serviciosCompletos = "----------------------------------------------------------";
        serviciosCompletos += "Los servicios que ha usado " + super.getNombre() + " en nuestra veterinaria son: \n";

        for (int i = 0; i < servicios.size(); i++) {
            serviciosCompletos += servicios.get(i) + "\n";
        }
        serviciosCompletos += "----------------------------------------------------------";
        
        return serviciosCompletos;
    }

    public void setServicio(Servicio servicio) {
        servicios.add(servicio);
    }

    public String toString() {
        return "Soy " + super.getNombre() + " mi correo es: " + super.getEmail() + " y tengo " + mascotas.size() + " mascotas";
    }

    public void registrarMascota(String nombre,Date fechaNacimiento ,char sexo, String especie, String raza){
        Mascota mascota = new Mascota(nombre, fechaNacimiento, sexo, especie, raza, this);
        this.setMascota(mascota);

    }

    public boolean borrarMascota(Mascota mascota) throws Throwable{
        if(mascotas.contains(mascota)){
            Data.mascotas.remove(mascota.getId());
            mascotas.remove(mascota);
            mascota.eliminarMascota();

            return true;
        }
        return false;
    }

    public void borrarTodasLasMascotas() throws Throwable{
        while (!mascotas.isEmpty()){
            Mascota mascota = mascotas.get(0);
            mascota.eliminarMascota();
        }
    }

    public HashMap<Cita,Mascota> getCitasAsignadas() {
        return citasAsignadas;
    }

    public void citaAsignada(Cita cita, Mascota mascota){
        citasAsignadas.put(cita,mascota);
    }

    @Override
    public void borrarMiCuenta() throws  Throwable{
        borrarTodasLasMascotas();
        Data.usuarios.remove(getNombreUsuario());
        this.finalize();
    }

}
