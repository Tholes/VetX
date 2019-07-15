package gestorAplicacion.Usuarios;

import java.util.ArrayList;
import gestorAplicacion.Animales.*;
import gestorAplicacion.prestacion.*;
import java.util.Date;

public class Cliente extends Persona {

    private static int cantidadClientes;
    private final int id;
    private ArrayList<Mascota> mascotas = new ArrayList<>();
    private ArrayList<Servicio> servicios = new ArrayList<>();
    private ArrayList<Cita> citasAsignadas = new ArrayList<>();

    public Cliente(String nombre, String email, String direccion, String ciudad, long telefono) {
        super(nombre,email,direccion,ciudad,telefono);
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
        return "Soy " + super.getNombre() + " mi correo es: " + super.getEmail() + " vivo en: " + super.getDireccion() + " en la ciudad de " + super.getCiudad() + " y tengo " + mascotas.size() + " mascotas";
    }

  
    public void registrarMascota(String nombre,Date fechaNacimiento ,char sexo, String especie, String raza){
        Mascota mascota = new Mascota(nombre, fechaNacimiento, sexo, especie, raza, this);
        this.setMascota(Mascota);

    }


    public boolean borrarMascota(Mascota mascota){
        if(mascotas.contains(mascota)){
            mascotas.remove(mascota);
            mascota.eliminarMascota();
            return true;
        }
        return false;
    }

}
